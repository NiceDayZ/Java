var path = require('path');
var color = require('cli-color');
var stack = require('stack-infos');
var printed = {};

function thumbprint(elem) {
  return elem.file + ':' + elem.function + ':' + elem.line + ':' + elem.column;
}

function str(opt) {
  var version;
  try {
    var dirModule = stack(2).dir.split('/node_modules/')[1].split('/')[0];
    version = require(path.join('..', dirModule, 'package.json')).version;
  } catch(e) {
    try {
      // for npm < 3.x
      version = require('../../package.json').version;
    } catch(e) {
      version = process.env.npm_package_version;
    }
  }
  var msg = color.magenta('DEPRECATED') + ' Function "' + color.bold(opt && opt.name ? opt.name : stack(2).function) + '" is deprecated';

  if (opt) {
    if (opt.printOnce !== false
	&& printed[thumbprint(stack(2))] == true)
      return null;
    if (opt.since)
      msg += ' since ' + color.yellow(opt.since);
    msg += '.';
    if (opt.current)
      version = opt.current;
    if (opt.removed) {
      msg += ' It will be removed in ' + color.yellow(opt.removed);
      if (version)
	msg += ' (current is ' + color.yellow(version) + ')';
      msg += '.';
    }
    if (opt.replaceBy)
      msg += ' You should use ' + color.yellow.bold('"' + opt.replaceBy + '"') + ' instead.';
    if (opt.message)
      msg += '\n' + color.magenta.bold('--------->') + ' ' + opt.message + '.';
  }
  else if (printed[thumbprint(stack(2))] == true)
    return null;
  else
    msg += '.';
  printed[thumbprint(stack(2))] = true;
  return msg;
}

module.exports = function(opt) {
  var msg = str(opt);
  if (msg)
    console.warn(msg);
}

module.exports.str = function(opt) {
  return str(opt);
}
