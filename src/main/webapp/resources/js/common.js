$(document).ready(function () {
    $('.date-default').val(getCurrentDateVale());
    initSelectRowCount();
})

function getCurrentDateVale() {
    var date = new Date();

    var year = date.getFullYear();
    var numMonth = parseInt(date.getMonth()) + 1;
    var month = numMonth < 10 ? ('0' + numMonth) : numMonth;
    var date = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();

    var val = year + '-' + month + '-' + date;

    console.log(val);

    return val;
}

function getGender(isMale) {
    if (isMale) {
        return 'Nam';
    }

    return 'Nữ';
}

function initPagination() {
    let id = '#pagination-demo';

    let currentPage = parseInt($('#pageNumber').val());
    let pageSize = parseInt($('#pageSize').val());
    let totalPages = parseInt($(id).data('pagecount'));

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

    let element = $('.count-row');

    $.each(arr, function (i, e) {
        $(element).append('<option value="' + e + '">' + e + '</option>');
    });

    $(element).val($('#pageSize').val());

    $(element).change(function () {
        $('#pageSize').val($(this).val());

        $('#submit').submit();
    });
}