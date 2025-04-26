/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    arr.sort((a, b) => {
        let x = fn(a);
        let y = fn(b);
        if (x < y) return -1;
        if (x > y) return 1;
        return 0;
    });
    return arr;
};
