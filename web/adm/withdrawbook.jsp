<%-- 
    Document   : withdrawbook
    Created on : Feb 26, 2020, 11:43:33 PM
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
            <h2>Rút sổ</h2>
            <form action="/withdrawbook" method="post" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td><label>Số sổ tiết kiệm</label></td>
                        <td><input type="number" name="savingbook" required="" placeholder="Số sổ tiết kiệm"></td>
                    </tr>
                    <tr>
                        <td><label>Số CMND/CCCD</label></td>
                        <td><input type="number" name="idcard" required="" placeholder="Số CMND/CCCD"></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2"><button type="sumbit" class="btn btn-success">Tìm kiếm</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
