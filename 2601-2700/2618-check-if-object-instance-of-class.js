/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (classFunction === null || classFunction === undefined || Number.isNaN(classFunction)) {
        return false;
    }
    try {
        if (obj instanceof classFunction) {
            return true;
        }
    } catch (Error) {}

    if (obj === classFunction) {
        return false;
    }

    if (obj === classFunction) {
        return false;
    }

    if (obj === null || obj == undefined) {
        return false;
    }
    cfp = classFunction.prototype
    op = obj['__proto__']
    while (op != null) {
        if (op === cfp) {
            return true;
        }
        op = op['__proto__']
    }
    return false;

};


/// --- testcase ---
// true
console.log(checkIfInstanceOf(new Date(), Date));
// true
class Animal {};
class Dog extends Animal {};
console.log(checkIfInstanceOf(new Dog(), Animal));
// true
console.log(checkIfInstanceOf(5, Number));
// false
console.log(checkIfInstanceOf(Date, Date));
// true
console.log(checkIfInstanceOf(5n, Object));
// true
console.log(checkIfInstanceOf(5n, BigInt));
// false
console.log(checkIfInstanceOf(NaN, NaN));
// false
console.log(checkIfInstanceOf(null, null));
// false
console.log(checkIfInstanceOf(undefined, undefined));
// true
console.log(checkIfInstanceOf(NaN, Number));
// false
console.log(checkIfInstanceOf(null, Date));
// true
console.log(checkIfInstanceOf(Object, Object));
// false
console.log(checkIfInstanceOf(null, []));
