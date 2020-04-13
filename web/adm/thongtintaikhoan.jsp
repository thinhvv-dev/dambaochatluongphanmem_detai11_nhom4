<%-- 
    Document   : thongtintaikhoan
    Created on : Apr 1, 2020, 1:32:36 PM
    Author     : NguyenDinhTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <style type="text/css">
            input[type="email"],input[type="number"],select,button,input[type="text"]{
                font-family: "Times New Roman";
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #cccccc;
                box-sizing: border-box;
            }
            label{
                padding-top: 12px;
                margin-top: 8px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/header.jsp"></jsp:include>
            <div class="container mt-3" style="text-align: center;">
                <h2>Thông tin tài khoản</h2>
                <form action="/admin/xacnhannoptien" method="post" class="mt-3">
                    <table style="font-size: large" class="table table-borderless" >
                        <tr>

                            <td><label>Số tài khoản</label></td>
                            <td><input type="number" name="banknumber" value="${saving.banknumber}" readonly=""></td>
                        <td><label>Trạng thái</label></td>
                        <td><input type="text" id="status" readonly="" value="${saving.status}"></td>
                    </tr>
                    <tr>
                        <td><label>Họ tên *</label></td>
                        <td><input type="text" value="${saving.fullName}" readonly=""></td>
                        <td><label>Địa chỉ *</label></td>
                        <td><input type="text" value="${saving.address}" readonly=""></td>
                    </tr>
                    <tr>
                        <td><label>Số điện thoại</label></td>
                        <td><input type="number" value="${saving.phone}" readonly=""></td>
                        <td><label>Email</label></td>
                        <td><input type="email" value="${saving.email}" readonly=""></td>
                    </tr>
                    <tr>
                        <td><label>Số CMND/CCCD *</label></td>
                        <td><input type="number" value="${saving.idcard}" readonly=""></td>
                        <td><label>Số dư</label></td>
                        <td><input type="number" value="${saving.accountBalance}" readonly=""></td>
                    </tr>
                    <tr>
                        <td><label>Số tiền gửi</label></td>
                        <td colspan="3"><input type="number" id="sodu" value="0" name="sodu" required="" placeholder="Số tiền gửi" onkeyup="myFuction()"></td>
                    </tr>
                    <tr id="statusSaving">
                        <td colspan="4"><button id="sumbit" type="sumbit" class="btn btn-success" id="extension" disabled="">Nộp tiền</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <script>
            function myFuction() {
                var t = document.getElementById("sodu").value;
                if (t >= 50000) {
                    document.getElementById("sumbit").disabled = false;
                } else {
                    document.getElementById("sumbit").disabled = true;
                }
            }
        </script>
    </body>
</html>
