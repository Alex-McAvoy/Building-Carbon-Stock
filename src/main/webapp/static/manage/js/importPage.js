//导入数据导入页
function importDataInput() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/data-input" width="100%" height="100%"></iframe>'
    );
}

//导入电力计算页
function importElectricity() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/electricity" width="100%" height="100%"></iframe>'
    );
}

//导入天然气计算页
function importGas() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/gas" width="100%" height="100%"></iframe>'
    );
}

//导入汽油计算页
function importGasoline() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/gasoline" width="100%" height="100%"></iframe>'
    );
}

//导入柴油计算页
function importDieselFuel() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/dieselFuel" width="100%" height="100%"></iframe>'
    );
}

//导入蒸汽计算页
function importSteam() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/steam" width="100%" height="100%"></iframe>'
    );
}

//导入供热供冷计算页
function importHeatingCooling() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/calculation/heat" width="100%" height="100%"></iframe>'
    );
}

//导入因子库展示页
function importFactorShow() {
    $("#content").empty();
    $("#content").append(
        '<iframe src="' + APP_PATH + '/import/factor-show" width="100%" height="100%"></iframe>'
    );
}