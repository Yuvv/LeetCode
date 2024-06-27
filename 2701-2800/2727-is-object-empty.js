/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    if (obj instanceof Array) {
        return obj.length === 0;
    } else {
        let d = {};
        for (var k in obj) {
            if (obj.hasOwnProperty(k)) {
                return false;
            }
        }
        return true;
    }
};


// --- testcase --
// false
console.log(isEmpty({"x":5,"y":42}));
// true
console.log(isEmpty({}));
// false
console.log(isEmpty([null, false, 0]));