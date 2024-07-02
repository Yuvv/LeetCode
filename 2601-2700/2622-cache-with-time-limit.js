var TimeLimitedCache = function() {
    this.vmap = {};
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    let oldV = this.vmap[key];
    this.vmap[key] = [value, now+duration];
    return oldV != undefined && oldV[1] > now;
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const now = Date.now();
    let v = this.vmap[key];
    if (v && v[1] > now) {
        return v[0];
    } else {
        delete this.vmap[key];
        return -1;
    }
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    let cnt = 0;
    const now = Date.now();
    for (let k in this.vmap) {
        let v = this.vmap[k];
        if (v[1] > now) {
            cnt++;
        } else {
            delete this.vmap[k];
        }
    }
    return cnt;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */
