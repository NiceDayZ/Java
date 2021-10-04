# Stack-infos

Get informations about each function in the stack.

## Installation

```bash
npm install stack-infos
```

## Usage

```javascript
var stack = require('stack-infos');
function test() {
	stack();
}
```

It will return an object which look like this :

```javascript
{
	file: '/home/Emeraude/node_modules/stack-infos/test.js',
	dir: '/home/Emeraude/node_modules/stack-infos',
	function: 'test',
	line: 3,
	column: 2
}
```

Note that it can take an int as parameter than represent the level of the stack. 0 is the last function, 1 is the function that call it.

You can also get it as a string

```javascript
function test() {
	stack.string(0); // returns 'test (/home/Emeraude/node_modules/stack-infos/test.js:3:2)'
	stack.string(1); // returns 'null (/home/Emeraude/node_modules/stack-infos/test.js:1:1)'
}
```

You can also get the full stack in an array of objects similar to `stack()`

```javascript
function test() {
	stack.full(); // returns an array of objects
	stack.size(); // return the size of the full stack
}
```

### Author

Emeraude
