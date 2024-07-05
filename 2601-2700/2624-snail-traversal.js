/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    const res = [];
    if (rowsCount * colsCount != this.length) {
        return res;
    }
    for (let i = 0; i < rowsCount; i++) {
        res.push(new Array(colsCount));
    }
    // snail
    let k = 0;
    for (let j = 0; j < colsCount; j++) {
        if (j % 2 == 0) {
            for (let i = 0; i < rowsCount; i++) {
                res[i][j] = this[k];
                k++;
            }
        } else {
            for (let i = rowsCount-1; i >= 0; i--) {
                res[i][j] = this[k];
                k++;
            }
        }
    }

    return res;

}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */
