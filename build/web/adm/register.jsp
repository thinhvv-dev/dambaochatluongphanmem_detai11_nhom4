<%-- 
    Document   : register
    Created on : Feb 25, 2020, 9:01:09 PM
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
        <style type="text/css">
            input[type="email"],input[type="number"],button,input[type="text"]{
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
                <h2>Đăng kí tài khoản</h2>
                <form action="/admin/register" method="post" class="mt-3">
                    <table style="font-size: large" class="table table-borderless">
                        <tr>
                            <td><label>Số tài khoản</label></td>
                            <td><input type="number" name="numberaccount" value="${numberaccount}" readonly=""></td>
                    </tr>
                    <tr>
                        <td><label>Họ tên</label></td>
                        <td><input type="text" name="name" required="" placeholder="Họ tên"></td>
                    </tr>
                    <tr>
                        <td><label>Địa chỉ</label></td>
                        <td><input type="text" name="address" required="" placeholder="Địa chỉ"></td>
                    </tr>
                    <tr>
                        <td><label>Số điện thoại</label></td>
                        <td><input type="number" name="phone" minlength="10" maxlength="10" required="" placeholder="Số điện thoại"></td>
                    </tr>
                    <tr>
                        <td><label>Email</label></td>
                        <td><input type="email" name="email" required="" placeholder="Email"></td>
                    </tr>
                    <tr>
                        <td><label>Số CMND/CCCD</label></td>
                        <td><input type="number" minlength="9" name="idcard" required="" placeholder="Số CMND/CCCD"></td>
                    </tr>
                    <tr>
                        <td><label>Số dư</label></td>
                        <td><input type="number" id="sodu" value="0" name="sodu" required="" placeholder="Số dư" onkeyup="myFuction()"></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2"><button id="sumbit" type="sumbit" class="btn btn-success" disabled="">Đăng kí</button></td>
                    </tr>
                </table>
            </form>
            <script>
                function myFuction(){
                    var t = document.getElementById("sodu").value;
                    if(t >= 50000){
                        document.getElementById("sumbit").disabled = false;
                    }
                    else{
                        document.getElementById("sumbit").disabled = true;
                    }
                }
            </script>
        </div>
    </body>
</html>
