$(document).ready(function () {
    initPagination();
    initSelectRowCount();

    $('#current-totalpage').append($('#pageNumber').val() + '/' + $('#pageSize').val());
})


function initPagination() {
    let id = '#pagination';

    let currentPage = parseInt($('#pageNumber').val());
    let pageSize = parseInt($('#pageSize').val());
    let totalPages = parseInt($(id).data('pagecount'));
    let keyword = $('#keyword').val();

    console.log(currentPage);
    $(id).twbsPagination({
        totalPages: totalPages,
        visiblePages: 5,
        startPage: currentPage,
        onPageClick: function (e, page) {
            console.log('page clicked: ' + page);

            if (currentPage != page) {
                $('#pageNumber').val(page);
                $('#pageSize').val(pageSize);
                $('#keyword').val(keyword);
                $('#submit').submit();
            }
        },
        first: 'Đầu',
        prev: 'Trước',
        next: 'Sau',
        last: 'Cuối'
    });

    $(id).removeClass('pagination-lg').addClass('pagination-sm');
}

function initSelectRowCount() {
    var arr = [10, 25, 50, 100];

    let element = $('#select-pagesize');

    $.each(arr, function (i, e) {
        $(element).append('<option value="' + e + '">' + e + '</option>');
    });

    $(element).val($('#pageSize').val());

    $(element).change(function () {
        $('#pageSize').val($(this).val());

        $('#submit').submit();
    });
}