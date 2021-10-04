# Deprecate-Me

Mark your methods as deprecated, and display messages with some options.

## Installation

```bash
npm install deprecate-me
```

## Usage

```javascript
var deprecate = require('deprecate-me');
function test() {
	deprecate(); // A warning will be printed when function test will be called for the first time
	console.warn(deprecate.str()); // Return the warning as a string, that you could display later
}
```

Several options can be used trought a simple javascript object:

```javascript
{
	since: '0.2.5', // The function is deprecated since version 0.2.5
	name: 'renamedFunction', // Default is the name of the function where deprecate() is called
	removed: '1.0.0', // The function will be removed in version 1.0.0
	// Note that it will also display the current version, if it can detect it
	current: '0.8.0', // Change value of current version manually
	printOnce: false, // By default, a message is called only the first time you call the function
	// You can avoid this behaviour with this argument
	replaceBy: "toto" // the name of the function you should use instead of the deprecated function
	message: "It's really bad" // This message will be printed in a new line
}
```

## Examples

Some examples are available in `example.js`.

### Author

Emeraude
