/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    let d = {};
    this.forEach(e => {
        let k = fn(e);
        if (k in d) {
            d[k].push(e);
        } else {
            d[k] = [e];
        }
    });
    return d;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */