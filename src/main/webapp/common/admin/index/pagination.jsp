<%--
  Created by IntelliJ IDEA.
  User: minhs
  Date: 8/22/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="d-flex justify-content-between mb-1">
    <div class="d-flex justify-content-start">
        <div class="d-flex">
            <label class="text-nowrap align-middle font-weight-bold align-self-center">Số lượng hiển thị bản ghi: </label>
        </div>
        &nbsp;
        <div>
            <select id="select-pagesize" name="select-pageSize" class="form-control">
            </select>
        </div>
    </div>
    <div class="d-flex justify-content-start">
        <label id="current-totalpage" class="font-weight-bold align-self-center">Trang </label>
    </div>
</div>
<div class="d-flex justify-content-center ">
    <ul id="pagination" data-pageCount="${param.pageCount}"></ul>
</div>