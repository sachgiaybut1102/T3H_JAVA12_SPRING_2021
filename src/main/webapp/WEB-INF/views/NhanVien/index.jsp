<%--
  Created by IntelliJ IDEA.
  User: MinhNgo
  Date: 7/18/2021
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Danh sách nhân viên</h1>
<p>
    <a href="/nhanvien/add" class="btn btn-sm btn-success">Thêm mới</a>
</p>
<form id="submit" method="get">
    <input id="pageNumber" name="pageNumber" value="${pageNumber}" hidden/>
    <input id="pageSize" name="pageSize" value="${pageSize}" hidden/>
</form>
<div class="table-responsive shadow">
    <table id="tb-view" class="table table-sm table-hover table-striped">
        <thead>
        <tr>
            <th>Mã nhân viên</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>SĐT</th>
            <th>Địa chỉ</th>
            <th>Email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.maNv}</td>
                <td>${item.tenNv}</td>
                <td>${item.ngaySinh}</td>
                <td>${item.gioiTinh}</td>
                <td>${item.sdt}</td>
                <td>${item.diaChi}</td>
                <td>${item.email}</td>
                <td class="text-nowrap" style="width:1px;">
                    <a class="btn btn-sm btn-warning mr-1" href="/nhanvien/edit/${item.maNv}">Sửa</a>
                    <a class="btn btn-sm btn-info mr-1">Chi tiết</a>
                    <a class="btn btn-sm btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul id="pagination-demo" data-pageCount="${pageCount}"></ul>
    <div class="d-flex">
        <div>Số lượng hiển thị trên trang:</div>
        <select class="form-control count-row"></select>
    </div>
    <input id="upload" type="file" />
    <button id="btn-upload"></button>
</div>
<script src="<c:url value="/resources/js/nhanvien/index.js"/>"></script>