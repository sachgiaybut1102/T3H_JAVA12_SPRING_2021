$(document).ready(function () {

    $('#btn-add').click(function () {
        add();
    })
});

function add() {
    console.log($('#ngaySinh').val());
    $.ajax({
        type: 'POST',
        datatype: 'JSON',
        url: '/nhanvien/addconfirmed/',
        data: {
            nhanVien: {
                tenNv: $('#tenNv').val(),
                ngaySinh: $('#ngaySinh').val(),
                gioiTinh: $('#gioiTinh').val(),
                sdt: $('#sdt').val(),
                email: $('#email').val(),
                diaChi: $('#diaChi').val(),
            }
        },
        success: function (result) {
            if (result == "ok") {
                location.replace('/nhanvien/index');
            }

        }
    });
}