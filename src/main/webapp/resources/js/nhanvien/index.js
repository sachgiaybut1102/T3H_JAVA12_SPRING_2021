$(document).ready(function () {
    loadData();
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
                    '<td>' + e.ngaySinh + '</td>' +
                    '<td>' + e.gioiTinh + '</td>' +
                    '<td>' + e.diaChi + '</td>' +
                    '<td>' + e.email + '</td>' +
                    '<td>' + e.sdt + '</td>' +
                    '<td class="text-nowrap" style="width:1px;">' +
                    '<a class="btn btn-sm btn-warning mr-1">Sửa</a>' +
                    '&nbsp;' +
                    '<a class="btn btn-sm btn-info mr-1">Chi tiết</a>' +
                    '&nbsp;' +
                    '<a class="btn btn-sm btn-danger">Xóa</a>' +
                    '</td>' +
                    '</tr>';
            });

            $('#tb-view tbody').empty().append(html);
        }
    });
}