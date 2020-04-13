<%-- 
    Document   : danhsachtaikhoantietkiem
    Created on : Apr 4, 2020, 1:07:29 PM
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
            a{
                color: black;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/headerCus.jsp"></jsp:include>
            <div class="container mt-3" style="text-align: center;">
                <h2>Danh sách sổ tiết kiệm</h2>
                <table class="table" style="font-size: large">
                    <tr>
                        <th>No.</th>
                        <th>Số sổ tiết kiệm</th>
                        <th>Tên</th>
                        <th>Kì hạn</th>
                        <th>Lãi suất</th>
                        <th>Số tiền gửi</th>
                        <th>Ngày gửi</th>
                        <th>Ngày đến hạn</th>
                        <th>Trạng thái</th>
                    </tr>
                <c:forEach items="${listSaving}" var="i" varStatus="loop">
                    <tr>
                        <td><c:out value="${loop.index + 1}"/></td>
                        <td><c:out value="${i.getNumberSaving()}"/></td>
                        <td><c:out value="${i.getFullName()}"/></td>
                        <td><c:out value="${i.getPeriod()}"/></td>
                        <td><c:out value="${i.getInterestRate()}"/></td>
                        <td><c:out value="${i.getDesposite()}"/></td>
                        <td><c:out value="${i.getFromDate()}"/></td>
                        <td><c:out value="${i.getToDate()}"/></td>
                        <td><a href="/customer/rutso?savingbook=${i.getNumberSaving()}&idcard=${i.getIdCard()}" style="color: black">Rút sổ</a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
