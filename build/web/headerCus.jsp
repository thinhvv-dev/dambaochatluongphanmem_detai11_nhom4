<%-- 
    Document   : headerCus
    Created on : Apr 1, 2020, 2:02:35 PM
    Author     : NguyenDinhTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style>
            ul{
                background: lightslategray;
                width: 100%;
            }
            a{
                color: white;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-light">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/customer/taikhoan">Thông tin tài khoản</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer/moso">Mở sổ tiết kiệm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer/interestrate">Tính lãi suất</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dangxuat">Đăng xuất</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
