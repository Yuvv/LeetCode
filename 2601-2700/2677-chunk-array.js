/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    let resList = [];
    for (let i = 0; i < arr.length; i += size) {
        resList.push(arr.slice(i, i + size));
    }
    return resList;
};
