/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let cachemap = {};
    return function(...args) {
        const cacheKey = args.join(',');
        if (cacheKey in cachemap) {
            return cachemap[cacheKey];
        }
        let v = fn(...args);
        cachemap[cacheKey] = v;
        return v;
    }
}


/**
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1
 */
