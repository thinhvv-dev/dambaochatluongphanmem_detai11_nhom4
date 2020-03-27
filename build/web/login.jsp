<%-- 
    Document   : login
    Created on : Mar 24, 2020, 9:57:29 PM
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
        <style type="text/css">
            input[type="password"],button,input[type="text"]{
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
                color: white
            }
            
            body {
                background-image: url("/image/background.jpg");
            }
    
        </style>
    </head>
    <body>
        <div class="container mt-3" style="text-align: center; color: white">
            <h2>Đăng nhập</h2>
            <form action="" method="post" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td><label>Tài khoản</label></td>
                        <td><input type="text" name="userName" required="" placeholder="Tài khoản" ></td>
                    </tr>
                    <tr>
                        <td><label>Mật khẩu</label></td>
                        <td><input type="password" name="passWord" required="" placeholder="Mật khẩu"></td>
                    </tr>
                    <tr>
                        <td align="right" colspan="2"><button type="sumbit" class="btn btn-light">Đăng nhập</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
