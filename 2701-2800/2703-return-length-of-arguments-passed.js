/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length;
};

// --- testcase --
// 3
console.log(argumentsLength(1,2,3));
// 0
console.log(argumentsLength());
