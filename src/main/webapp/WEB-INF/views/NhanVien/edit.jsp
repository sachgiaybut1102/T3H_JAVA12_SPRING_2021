<%--
  Created by IntelliJ IDEA.
  User: MinhNgo
  Date: 7/21/2021
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card container shadow col-md-6 col-12 mt-3">
    <div class="card-body">
        <h1>Chỉnh sửa</h1>
        <h2>Khách hàng</h2>
        <hr/>
        <form method="post" action="/nhanvien/editconfirmed">
            <input id="maNv" name="maNv" value="${item.maNv}" hidden/>
            <div class="form-group">
                <label class="form-label font-weight-bold">Họ tên</label>
                <input id="tenNv" name="tenNv" class="form-control" value="${item.tenNv}"/>
            </div>
            <div class="form-group">
                <label class="form-label font-weight-bold">Ngày sinh</label>
                <input id="ngaySinh" name="ngaySinh" type="date" class="form-control"
                       value="${item.ngaySinh}"/>
            </div>
            <div class="form-group">
                <label class="form-label font-weight-bold">Giới tính</label>
                <select id="gioiTinh" name="gioiTinh" class="form-control" data-value="${item.gioiTinh}">
                    <option value="true">Nam</option>
                    <option value="false">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label class="form-label font-weight-bold">Số điện thoại</label>
                <input id="sdt" name="sdt" class="form-control" value="${item.sdt}"/>
            </div>
            <div class="form-group">
                <label class="form-label font-weight-bold">EMail</label>
                <input id="email" name="email" class="form-control" value="${item.email}"/>
            </div>
            <div class="form-group">
                <label class="form-label font-weight-bold">Địa chỉ</label>
                <input id="diaChi" name="diaChi" class="form-control" value="${item.diaChi}"/>
            </div>
            <hr/>
            <div class="form-group">
                <button type="submit" id="btn-add" class="btn btn-sm btn-success">Thay đổi</button>
                <a class="btn btn-sm btn-light" href="/nhanvien/index">Hủy</a>
            </div>
        </form>

    </div>
</div>
<script src="<c:url value="/resources/js/nhanvien/edit.js"/>"></script>