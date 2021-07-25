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
        <tbody></tbody>
    </table>
</div>
<script src="<c:url value="/resources/js/nhanvien/index.js"/>"></script>