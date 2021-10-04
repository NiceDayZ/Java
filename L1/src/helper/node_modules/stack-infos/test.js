#!/usr/bin/env node

try {
    require('pretty-console.log').enable();
} catch(e) {
    console.warn('You can install `pretty-console.log` npm module to make this display prettier');
}

var stack = require('./index.js');

function test() {
    console.log(stack());
    console.log(stack(1));
    console.log(stack.size());
    console.log(stack.full());
    console.log(stack.string());
}

test();
