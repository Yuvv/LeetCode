/**
 * @param {Object} context
 * @param {Array} args
 * @return {null|boolean|number|string|Array|Object}
 */
Function.prototype.callPolyfill = function(context, ...args) {
    return this.call(context, ...args);
}

/// --- testcase ---
function increment() { this.count++; return this.count; }
// 2
console.log(increment.callPolyfill({count: 1}));

