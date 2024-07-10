/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let x = n-1;
    return function() {
        x++;
        return x;
    };
};

/**
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
