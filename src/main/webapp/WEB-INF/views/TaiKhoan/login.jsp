<%--
  Created by IntelliJ IDEA.
  User: minhs
  Date: 8/27/2021
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-lg-5">
    <div class="card shadow-lg border-0 rounded-lg mt-5">
        <div class="card-header"><h3 class="text-center font-weight-light my-4">Đăng nhập hệ thống quản lý</h3></div>
        <div class="card-body">
            <c:if test="${empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
            <form id="form" method="post">
                <div class="form-floating mb-3">
                    <input class="form-control" id="username" name="username" type="text"
                           placeholder="Nhập vào vào tên đăng nhập"/>
                    <label for="username">Tên đăng nhập</label>
                </div>
                <div class="form-floating mb-3">
                    <input class="form-control" id="password" name="password" type="password"
                           placeholder="Nhập vào mật khẩu"/>
                    <label for="password">Mật khẩu</label>
                </div>
                <div class="form-check mb-3">
                    <input class="form-check-input" id="inputRememberPassword" type="checkbox"
                           value=""/>
                    <label class="form-check-label" for="inputRememberPassword">Lưu mật khẩu</label>
                </div>
                <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                    <a class="small" href="password.html">Quên mật khẩu?</a>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </div>
            </form>
        </div>
        <div class="card-footer text-center py-3">
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/md5.js"></script>
<script src="<c:url value="/resources/js/taikhoan/login.js" />"></script>
