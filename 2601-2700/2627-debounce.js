/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {

    let tid = undefined;

    return function(...args) {
        if (tid && !tid._destroyed) {
            clearTimeout(tid);
        }
        tid = setTimeout(() => {
            fn(...args);
        }, t);
    };
};


const log = debounce(console.log, 100);
log('Hello'); // cancelled
log('Hello'); // cancelled
log('Hello'); // Logged at t=100ms

