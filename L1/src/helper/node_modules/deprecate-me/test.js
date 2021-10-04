#!/usr/bin/env nodeunit

var color = require('cli-color');
var deprecate = require('.');

/* TODO : test for printOnce and printSeveral */
exports.basic = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.basic') + '" is deprecated.', deprecate.str());
  test.done();
}

exports.renamed = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('renamed') + '" is deprecated.', deprecate.str({name: 'renamed'}));
  test.done();
}

exports.since = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.since') + '" is deprecated since ' + color.yellow('0.2.5') + '.', deprecate.str({since: '0.2.5'}));
  test.done();
}

exports.remove = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.remove') + '" is deprecated. It will be removed in ' + color.yellow('2.0.0') + ' (current is ' + color.yellow('1.4.0') + ').', deprecate.str({removed: '2.0.0'}));
  test.done();
}

exports.withMessage = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.withMessage') + '" is deprecated.\n' + color.magenta.bold('--------->') + ' You should use console.log instead.', deprecate.str({message: 'You should use console.log instead'}));
  test.done();
}

exports.replaceBy = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.replaceBy') + '" is deprecated. You should use ' + color.yellow.bold('"replaceBy"') + ' instead.', deprecate.str({replaceBy: 'replaceBy'}));
  test.done();
}

exports.multiple = function(test) {
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('exports.multiple') + '" is deprecated since ' + color.yellow('0.2.5') + '. It will be removed in ' + color.yellow('1.0.0') + ' (current is ' + color.yellow('0.8.0') + ').', deprecate.str({since: '0.2.5', current: '0.8.0', removed: '1.0.0'}));
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('multiple') + '" is deprecated since ' + color.yellow('0.2.5') + '. It will be removed in ' + color.yellow('1.0.0') + ' (current is ' + color.yellow('1.4.0') + ').', deprecate.str({since: '0.2.5', removed: '1.0.0', name: 'multiple'}));
  test.equal(color.magenta('DEPRECATED') + ' Function "' + color.bold('all') + '" is deprecated since ' + color.yellow('0.2.5') + '. It will be removed in ' + color.yellow('1.0.0') + ' (current is ' + color.yellow('0.8.0') + '). You should use ' + color.yellow.bold('"none"') + ' instead.\n' + color.magenta.bold('--------->') + ' You should avoid it.', deprecate.str({since: '0.2.5', removed: '1.0.0', current: '0.8.0', name: 'all', replaceBy: 'none', message: 'You should avoid it'}));
  test.done();
}
