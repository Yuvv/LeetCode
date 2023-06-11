/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    this.toBe = function (x) {
        if (val === x) {
            return true;
        }
        throw new Error('Not Equal');
    }
    this.notToBe = function (x) {
        if (val !== x) {
            return true;
        }
        throw new Error('Equal');
    }
    return this;
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */