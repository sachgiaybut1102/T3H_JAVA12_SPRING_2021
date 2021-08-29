$(document).ready(function () {
    $('#form').submit(function(){
        var md5 = CryptoJS.MD5($('#password').val()).toString();
        $('#password').val(md5);

        console.log(md5);

    })
})