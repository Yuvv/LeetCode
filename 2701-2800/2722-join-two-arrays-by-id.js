/**
 * 2722-join-two-arrays-by-id.js
 *
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    var arr2map = {};
    for (var i = 0; i < arr2.length; i++) {
        arr2map[arr2[i].id] = arr2[i];
    }
    var res = [];
    for (var i = 0; i < arr1.length; i++) {
        var item1 = arr1[i];
        var item2 = arr2map[item1.id];
        if (item2) {
            Object.assign(item1, item2);
            delete arr2map[item1.id];
        }
        res.push(item1);
    }
    for (var k  in arr2map) {
        res.push(arr2map[k]);
    }
    res.sort(function (a,b) { return a.id-b.id; });
    return res;
};
