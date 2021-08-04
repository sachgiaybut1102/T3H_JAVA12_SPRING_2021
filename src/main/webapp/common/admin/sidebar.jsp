<%--
  Created by IntelliJ IDEA.
  User: MinhNgo
  Date: 6/16/2021
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
        <div class="nav">
            <div class="sb-sidenav-menu-heading">Cơ bản</div>
            <a class="nav-link" href="index.html">
                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                Bàn làm việc
            </a>
            <div class="sb-sidenav-menu-heading">Hệ thống</div>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                Thông tin các nhân
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="/nhanvien/index">Nhân viên</a>
                    <a class="nav-link" href="/khachhang/index">Khách hàng</a>
                    <a class="nav-link" href="/nhacungcap/index">Nhà cung cấp</a>
                    <a class="nav-link" href="/nhasanxuat/index">Nhà sản xuất</a>
                </nav>
            </div>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts-1" aria-expanded="false" aria-controls="collapseLayouts-1">
                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                Thông tin hàng hóa
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts-1" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="/donvitinh/index">Đơn vị tính</a>
                    <a class="nav-link" href="/loaihang/index">Loại hàng hóa</a>
                    <a class="nav-link" href="/hanghoa/index">Hàng hóa</a>
                </nav>
            </div>
            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts-2" aria-expanded="false" aria-controls="collapseLayouts-2">
                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                Nhập - xuất
                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
            </a>
            <div class="collapse" id="collapseLayouts-2" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                <nav class="sb-sidenav-menu-nested nav">
                    <a class="nav-link" href="/hoadonnhap/index">Nhập hàng</a>
                    <a class="nav-link" href="/hoadonxuat/index">Xuất hàng</a>
                </nav>
            </div>
        </div>
    </div>
    <div class="sb-sidenav-footer">
        <div class="small">Logged in as:</div>
        Start Bootstrap
    </div>
</nav>
