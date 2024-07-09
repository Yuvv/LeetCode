/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
    let promises = functions.map((fn) => fn());
    return new Promise((resolve, reject) => {
        const results = [];
        let remaining = promises.length;

        if (remaining === 0) {
            resolve(results);
            return;
        }

        promises.forEach((promise, index) => {
            promise.then(
                value => {
                    results[index] = value;
                    remaining--;

                    if (remaining === 0) {
                        resolve(results);
                    }
                },
                error => {
                    reject(error);
                }
            );
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
