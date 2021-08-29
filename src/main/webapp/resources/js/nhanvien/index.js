$(document).ready(function () {
    //loadData();
    //initPagination();

    $('#btn-upload').click(function () {
        var fileupload = $('#upload').get(0);
        var files = fileupload.files;

        var formdata = new FormData();
        formdata.append('file', files[0]);

        $.ajax({
            type: 'POST',
            datatype: 'JSON',
            data: formdata,
            contentType: false,
            processData: false,
            url: '/uploadfile',
            success: function (result) {
                console.log(result);
            }
        });
        $('#tb-view tbody').empty().append(html);
    })
});

function loadData() {
    $.ajax({
        type: 'GET',
        datatype: 'JSON',
        url: '/nhanvien/getall/',
        success: function (result) {
            console.log(result);
            var html = '';
            $.each(result, function (i, e) {
                html += '<tr>' +
                    '<td>' + e.maNv + '</td>' +
                    '<td>' + e.tenNv + '</td>' +
                    '<td>' + e.viewNgaySinh + '</td>' +
                    '<td>' + (e.gioiTinh == true ? 'Nam' : 'Nữ') + '</td>' +
                    '<td>' + e.diaChi + '</td>' +
                    '<td>' + e.email + '</td>' +
                    '<td>' + e.sdt + '</td>' +
                    '<td class="text-nowrap" style="width:1px;">' +
                    '<a class="btn btn-sm btn-warning mr-1" href="/nhanvien/edit/' + e.maNv + '">Sửa</a>' +
                    '&nbsp;' +
                    '<a class="btn btn-sm btn-info mr-1">Chi tiết</a>' +
                    '&nbsp;' +
                    '<a class="btn btn-sm btn-danger">Xóa</a>' +
                    '</td>' +
                    '</tr>';
            });

            var objs = [];
            $.each(result, function (i, e) {
                var obj = {
                    maNv: e.maNv,
                    tenNv: e.tenNv,
                    viewNgaySinh: e.viewNgaySinh,
                    diaChi: e.diaChi,
                    email: e.email,
                    sdt: e.sdt
                };

                objs.push(obj);
            });

            $.ajax({
                type: 'POST',
                datatype: 'JSON',
                data: {
                    json: JSON.stringify(objs)
                },
                url: '/nhanvien/addlist/',
                success: function (result) {
                    console.log(result);
                }
            });
            $('#tb-view tbody').empty().append(html);
        }
    });
}