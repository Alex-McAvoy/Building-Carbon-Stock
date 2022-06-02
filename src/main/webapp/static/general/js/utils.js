
//保留小数点后三位
function getThreeBit(value) {
    var temp = Number(value);
    temp = Math.floor(temp * 1000) / 1000;
    temp = temp.toFixed(3);
    return temp;
}

//保留小数点后五位
function getFiveBit(value) {
    var temp = Number(value);
    temp = Math.floor(temp * 100000) / 100000;
    temp = temp.toFixed(5);
    return temp;
}

//解析日期
function parseCreatedTime(createdTime) {
    var temp = new Date(createdTime);
    var date = temp.toLocaleDateString().split("/").join("-");
    return date;
}