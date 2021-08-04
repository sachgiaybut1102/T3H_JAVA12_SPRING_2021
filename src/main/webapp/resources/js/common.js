$(document).ready(function(){
    $('.date-default').val(getCurrentDateVale());
})

function getCurrentDateVale(){
    var date = new Date();

    var year = date.getFullYear();
    var numMonth = parseInt(date.getMonth()) + 1;
    var month = numMonth < 10 ? ('0' + numMonth) : numMonth;
    var date = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();

    var val = year + '-' + month + '-' + date;

    console.log(val);

    return val;
}

function getGender(isMale){
    if(isMale){
        return 'Nam';
    }

    return 'Nữ';
}