//生成验证码
function createCode(length) {
    var code = "";
    var codeLength = parseInt(length); //验证码的长度
    var checkCode = $("#checkCode");
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++) { //循环组成验证码的字符串
        var charNum = Math.floor(Math.random() * 62); //获取随机验证码下标
        code += codeChars[charNum]; //组合成指定字符验证码
    }
    if (checkCode) {
        checkCode.className = "code"; //为验证码区域添加样式名
        $("#checkCode").text(code); //将生成验证码赋值到显示区
    }
}

//检查验证码是否正确
function validateCode() {
    var checkCode = $("#checkCode").text();  //获取显示区生成的验证码
    var inputCode = $("#code").val(); //获取输入的验证码
    if (inputCode.toUpperCase() != checkCode.toUpperCase()) {
        createCode(4);
        return false;
    }
    return true;
}