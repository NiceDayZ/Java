var path = require('path');

function getStack() {
    var orig = Error.prepareStackTrace;
    Error.prepareStackTrace = function(_, stack) {
	return stack;
    };
    var err = new Error;
    Error.captureStackTrace(err, arguments.callee);
    var stack = err.stack;
    Error.prepareStackTrace = orig;
    return stack;
}

module.exports = function(i) {
    i = i ? i + 1 : 1;
    var stack = getStack();
    return {
	file: stack[i].getFileName(),
	dir: path.dirname(stack[i].getFileName()),
	function: stack[i].getFunctionName(),
	line: stack[i].getLineNumber(),
	column: stack[i].getColumnNumber()
    };
}

module.exports.size = function() {
    return getStack().length - 2;
}

module.exports.full = function() {
    var stack = [];
    for (var i = 1; i < this.size() + 1; ++i)
	stack.push(this(i));
    return stack;
}

module.exports.string = function(i) {
    i = i ? i + 1 : 1;
    var stack = this(i);
    return stack.function + ' (' + stack.file + ':' + stack.line + ':' + stack.column + ')';
}
