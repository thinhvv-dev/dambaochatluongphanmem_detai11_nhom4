<%-- 
    Document   : interestrate
    Created on : Feb 26, 2020, 10:39:06 PM
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
        <jsp:include page="/headerCus.jsp"></jsp:include>
            <div class="container mt-3" style="text-align: center;">
                <h2>Tính lãi suất</h2>
                <div style="display: none;" id="error">
                    <label style="color: red">Số tiền gửi phải lớn hơn 1,000,000 VND</label>
                </div>
                <table style="font-size: large" class="table table-borderless mt-3">

                    <tr>
                        <td><label>Số tiền gửi *</label></td>
                        <td><input type="number" name="desposite" id="desposite" value="0" placeholder="Số tiền" ></td>
                        <td><label>Loại tiền</label></td>
                        <td><input type="text" name="currency" value="VND" readonly=""></td>
                    </tr>
                    <tr>
                        <td><label>Kì hạn *</label></td>
                        <td>
                            <select name="period" id="period" onchange="myFunction()">
                                <option hidden="" selected="" value="0">Không kì hạn</option>
                            <c:forEach items="${lists}" var="i">
                                <c:if test="${i.period == 0}">
                                    <option value="${i.period}">Không kì hạn</option>
                                </c:if>
                                <c:if test="${i.period != 0}">
                                    <option value="${i.period}">${i.period} Tháng</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label>Lãi suất (%/năm)</label></td>
                    <td>
                        <select name="interestRateLoop" id="interestRateLoop" hidden="">
                            <c:forEach items="${lists}" var="i">
                                <option value="${i.interestRate}"></option>
                            </c:forEach>
                        </select>
                        <input type="number" name="interestRate" id="interestRate" readonly="" value="${lists[lists.size() - 1].interestRate}">
                    </td>
                </tr>
                <tr>
                    <td><label>Ngày đáo hạn</label></td>
                    <td><input type="text" name="todate" id="todate" value="" readonly=""></td>
                    <td><label>Tiền lãi</label></td>
                    <td>
                        <input type="number" name="profit" id="profit" readonly="" value="0">
                    </td>
                </tr>

            </table>

        </div>
        <script>  
            function myFunction() {
                var x = document.getElementById("period").selectedIndex;
                var y = +document.getElementById("period").value;
                var z = document.getElementById("interestRateLoop").options;
                var t = document.getElementById("desposite").value;
                document.getElementById("interestRate").value = z[x - 1].value;
                if (t < 1000000) {
                    document.getElementById("error").style.display = 'block';
                } else if (y != 0) {
                    document.getElementById("profit").value = ((t * z[x - 1].value * y) / 1200).toFixed(0);

                    var date = new Date();
                    var day = date.getDate();
                    var month = date.getMonth() + y;
                    var year = date.getFullYear();
                    var nextDate = new Date(year, month, day);
                    if(day == 30 || day == 31){
                        if(nextDate.getDate()==2||nextDate.getDate()==3){
                            nextDate.setDate(1);
                        }
                    } 
                    document.getElementById("todate").value = nextDate.toLocaleDateString();
                } else {
                    document.getElementById("profit").value = 0;
                    document.getElementById("todate").value = null;
                }
            }
        </script>
    </body>
</html>
