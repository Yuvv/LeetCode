/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    switch (typeof(obj)) {
        case 'boolean':
        case 'string':
        case 'number':
            if (obj) {
                return obj
            }
            break;
        case 'object':
            if (obj instanceof Array) {
                let arr = [];
                for (let i = 0; i < obj.length; i++) {
                    let v = compactObject(obj[i]);
                    if (v) {
                        arr.push(v);
                    }
                }
                return arr;
            } else if (obj) {
                let d = {};
                for (var k in obj) {
                    if (obj.hasOwnProperty(k)) {
                        let v = compactObject(obj[k]);
                        if (v) {
                            d[k] = v;
                        }
                    }
                }
                return d;
            }
            break;
        default:
            break
    }
};

// --- testcase --
// [1]
console.log(compactObject([null, 0, false, 1]));
// {"b":[1]}
console.log(compactObject({"a":null, "b": [false, 1]}));
// [5, [], [16]]
console.log(compactObject([null, 0, 5, [0], [false, 16]]));

