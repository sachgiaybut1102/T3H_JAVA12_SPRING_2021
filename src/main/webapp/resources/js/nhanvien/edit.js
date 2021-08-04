$(document).ready(function () {
    var gt = $('#gioiTinh').data('value');
    console.log(gt);
    $('#gioiTinh option[value=' + gt + ']').attr('selected', 'selected');
})