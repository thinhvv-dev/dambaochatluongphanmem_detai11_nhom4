<%-- 
    Document   : moso
    Created on : Apr 4, 2020, 11:13:40 AM
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
                <h2>Mở sổ tiết kiệm</h2>
                <div style="display: none;" id="error">
                    <label style="color: red">Số tiền gửi phải lớn hơn 1,000,000 VND</label>
                </div>
                <div style="display: none;" id="error2">
                    <label style="color: red">Số tiền gửi lớn hơn số dư: ${saving.accountBalance}</label>
                </div>
                <form action="/customer/moso" method="post" class="mt-3">
                    <table style="font-size: large" class="table table-borderless">
                        <tr>
                            <td><label>Họ tên</label></td>
                            <td><input type="text" value="${saving.fullName}" readonly=""></td>
                            <td><label>Địa chỉ</label></td>
                            <td><input type="text" value="${saving.address}" readonly=""></td>
                        </tr>
                        <tr>
                            <td><label>Số điện thoại</label></td>
                            <td><input type="number" value="${saving.phone}" readonly=""></td>
                            <td><label>Email</label></td>
                            <td><input type="email" value="${saving.email}" readonly=""></td>
                        </tr>
                        <tr>
                            <td><label>Số CMND/CCCD</label></td>
                            <td><input type="number" value="${saving.idcard}" readonly=""></td>
                            <td><label>Số tài khoản</label></td>
                            <td><input type="text" value="${saving.banknumber}" readonly=""></td>
                            <td><input type="number" hidden="" id="accountBalance" value="${saving.accountBalance}" readonly=""></td>
                        </tr>
                        <tr>
                            <td><label>Số tiền gửi *</label></td>
                            <td><input type="number" name="desposite" id="desposite" value="0" required="" placeholder="Số tiền" onkeyup="myFunctionKeyup()"></td>
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
                        <td><label>Hình thức thanh toán</label></td>
                        <td>
                            <select name="paymentMethot">
                                <option hidden="" selected="" value="${listPayments[listPayments.size()-1].name}">${listPayments[listPayments.size()-1].name}</option>
                                <c:forEach items="${listPayments}" var="i">
                                    <option value="${i.name}"> ${i.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label>Tiền lãi</label></td>
                        <td>
                            <input type="number" name="profit" id="profit" readonly="" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td><label>Ngày đáo hạn</label></td>
                        <td><input type="text" name="todate" id="todate" value="" readonly=""></td>
                        <td><label>Số sổ tiết kiệm</label></td>
                        <td><input type="text" name="numbersaving" id="numbersaving" value="${numbersaving}" readonly=""></td>
                    </tr>
                    <tr>
                        <td colspan="4"><button type="sumbit" id="buttonSubmit" class="btn btn-success" disabled="true">Mở số tiết kiệm</button></td>
                    </tr>
                </table>

            </form>

        </div>
        <script>
            function myFunctionKeyup(){
                var t = +document.getElementById("desposite").value;
                var balance = +document.getElementById("accountBalance").value;
      
                if(t>=1000000){
                    if(balance>=t){
                        
                        document.getElementById("error2").style.display = 'none';
                        document.getElementById("buttonSubmit").disabled = false;
                    }
                    else{
                        
                        document.getElementById("error2").style.display = 'block';
                        document.getElementById("buttonSubmit").disabled = true;
                    }
                }
                else{
                    document.getElementById("buttonSubmit").disabled = true;
                }
            }
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
