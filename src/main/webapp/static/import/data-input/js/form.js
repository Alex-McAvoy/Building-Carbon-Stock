//表单提交
layui.use(["form", "jquery"], function () {
    var form = layui.form;
    var $ = layui.jquery;

    //电力能耗表单提交
    form.on("submit(electricityConsumptionForm)", function (data) {
        console.log(data);
        $.ajax({
            type: "POST",
            url: APP_PATH + "/electricity-consumption/saveElectricityConsumption",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#electricityConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        });
        return false;
    });

    //天然气能耗表单提交
    form.on("submit(gasConsumptionForm)", function (data) {
        $.ajax({
            type: "POST",
            url: APP_PATH + "/gas-consumption/saveGasConsumption",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#gasConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        })
        return false;
    });

    //汽油能耗表单提交
    form.on("submit(gasolineConsumptionForm)", function (data) {
        $.ajax({
            type: "POST",
            url: APP_PATH + "/gasoline-consumption/saveGasolineConsumptionForm",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#gasolineConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        })
        return false;
    });

    //柴油能耗表单提交
    form.on("submit(dieselFuelConsumptionForm)", function (data) {
        $.ajax({
            type: "POST",
            url: APP_PATH + "/dieselFuel-consumption/saveDieselFuelConsumptionForm",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#dieselFuelConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        })
        return false;
    });

    //蒸汽能耗表单提交
    form.on("submit(steamConsumptionForm)", function (data) {
        $.ajax({
            type: "POST",
            url: APP_PATH + "/steam-consumption/saveSteamConsumptionForm",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#steamConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        })
        return false;
    });

    //热量/冷量能耗表单提交
    form.on("submit(heatConsumptionForm)", function (data) {
        $.ajax({
            type: "POST",
            url: APP_PATH + "/heat-consumption/saveHeatConsumptionForm",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data.field),
            success: function (result) {
                if(result.code == 100){ //提交成功
                    $("#heatConsumptionForm")[0].reset();
                    layui.form.render();
                }
                layer.alert(result.extend.message);
            }, error: function () {
                layer.alert("提交失败，请重试");
            }
        })
        return false;
    });
});
