<%--
  Created by IntelliJ IDEA.
  User: minhs
  Date: 8/22/2021
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="submit" method="get" asp-action="Index">
    <div class="d-flex justify-content-between">
        <div>
            <p>
                <a href="add" class="btn btn-outline-success text-nowrap"><i class="fas fa-plus-circle"></i>
                    Tạo mới</a>
            </p>
        </div>
        <div class="d-flex justify-content-end">
            <div class="me-3">
                <input id="keyword" name="keyword" class="form-control" placeholder="Nhập vào từ khóa cần tìm"
                       value="${keyword}"/>
            </div>
            <div>
                <button type="submit" class="btn btn-outline-primary text-nowrap"><i class="fas fa-search"> </i> Tìm
                    kiếm
                </button>
            </div>
        </div>
        <input id="pageNumber" name="pageNumber" value="${pageNumber}" hidden/>
        <input id="pageSize" name="pageSize" value="${pageSize}" hidden/>
    </div>
</form>