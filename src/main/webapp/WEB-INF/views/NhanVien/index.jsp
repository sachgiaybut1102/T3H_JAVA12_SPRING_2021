<%--
  Created by IntelliJ IDEA.
  User: MinhNgo
  Date: 7/18/2021
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/common/admin/index/header.jsp">
    <jsp:param name="text" value="Danh sách nhân viên"/>
</jsp:include>
<div class="table-responsive shadow p-3">
    <jsp:include page="/common/admin/index/addAndFind.jsp"/>
    <table id="tb-view" class="table table-bordered table-sm table-hover table-striped">
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
                <td><c:choose>
                    <c:when test="${item.gioiTinh == true}">
                        Nam
                    </c:when>
                    <c:otherwise>Nữ</c:otherwise>
                </c:choose></td>
                <td>${item.sdt}</td>
                <td>${item.diaChi}</td>
                <td>${item.email}</td>
                <jsp:include page="/common/admin/index/objectFunction.jsp">
                    <jsp:param name="id" value="${item.maNv}"/>
                </jsp:include>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/common/admin/index/pagination.jsp">
        <jsp:param name="pageCount" value="${pageCount}"/>
    </jsp:include>
</div>
<script src="<c:url value="/resources/js/nhanvien/index.js"/>"></script>
<script src="<c:url value="/resources/js/common/indexCommon.js"/>"></script>