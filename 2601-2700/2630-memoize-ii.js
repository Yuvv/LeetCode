/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cachemap = new Map();
    const valkey = '__val__';
    return function(...args) {
        let hit = true;
        let cm = cachemap;
        for (let i = 0; i < args.length; i++) {
            if (cm.has(args[i])) {
                cm = cm.get(args[i]);
            } else {
                hit = false;
                let ncm = new Map();
                cm.set(args[i], ncm);
                cm = ncm;
            }
        }
        if (hit && cm.has(valkey)) {
            return cm.get(valkey);
        } else {
            let v = fn(...args);
            cm.set(valkey, v);
            return v;
        }
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