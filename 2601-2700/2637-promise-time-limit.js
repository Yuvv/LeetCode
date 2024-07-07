/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {

    return async function(...args) {
        let _timer;
        return await Promise.race([
            fn(...args),
            new Promise((_r, rej) => {
                _timer = setTimeout(() => rej('Time Limit Exceeded'), t)
            })
        ]).finally( () => clearTimeout(_timer));
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
