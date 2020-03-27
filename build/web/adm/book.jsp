<%-- 
    Document   : book
    Created on : Feb 27, 2020, 4:03:32 PM
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
    <body onload="myLoad()">
        <jsp:include page="/header.jsp"></jsp:include>
            <div class="container mt-3" style="text-align: center;">
                <h2>Rút sổ</h2>
                <table style="font-size: large" class="table table-borderless" >
                    <tr>

                        <td><label>Số sổ tiết kiệm</label></td>
                        <td><input type="number" name="savingnumber" value="${saving.numberSaving}" readonly=""></td>
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
                    <td><input type="number" value="${saving.idCard}" readonly=""></td>
                    <td><label>Nơi cấp *</label></td>
                    <td><input type="text" value="${saving.issueBy}" readonly=""></td>
                </tr>
                <tr>
                    <td><label>Số tiền gửi *</label></td>
                    <td><input type="number" id="desposite" value="${saving.desposite}" readonly=""></td>
                    <td><label>Loại tiền</label></td>
                    <td><input type="text" value="${saving.currency}" readonly=""></td>
                </tr>
                <tr>
                    <td><label>Kì hạn *</label></td>
                    <td><input type="number" id="priod" value="${saving.period}" readonly=""></td>
                    <td><label>Lãi suất (%/năm)</label></td>
                    <td><input type="number" id="interestRate" value="${saving.interestRate}" readonly=""></td>
                </tr>
                <tr>
                    <td><label>Hình thức thanh toán</label></td>
                    <td><input type="text" value="${saving.paymentMethot}" readonly=""></td>
                    <td><label>Tiền lãi</label></td>
                    <td><input type="number" id="profit" readonly="" value="0"></td>
                </tr>
                <tr>
                    <td><label>Ngày mở</label></td>
                    <td><input type="text" value="${saving.fromDate}" readonly=""></td>
                    <td><label>Ngày đáo hạn</label></td>
                    <td><input type="text" id="todate" value="${saving.toDate}" readonly="" readonly=""></td>
                </tr>
                <tr id="statusSaving">
                    <td colspan="2"><button type="button" class="btn btn-success" id="extension">Gia hạn</button></td>
                    <td colspan="2"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Rút sổ tiết kiệm</button></td>
                </tr>
            </table>
        </div>
        <div class="modal" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container mt-3" style="text-align: center;">
                        <form action="/saving" method="post" class="mt-3">
                            <table style="font-size: large" class="table table-borderless" >
                                <tr>
                                    <td><label>Số sổ tiết kiệm</label></td>
                                    <td><input type="number" name="mySavingNumber" value="${saving.numberSaving}" readonly=""></td>
                                </tr>
                                <tr>
                                    <td><label>Số tiền gửi *</label></td>
                                    <td><input type="number" value="${saving.desposite}" readonly=""></td>
                                </tr>
                                <tr>
                                    <td><label>Thanh toán</label></td>
                                    <td><input type="text" id="payment" readonly=""></td>
                                </tr>
                                <tr hidden="">
                                    <td><label>Không kì hạn</label></td>
                                    <td><input type="number" id="anticipatory" value="${anticipatory}" readonly=""></td>
                                </tr>
                                <td><label>Lãi suất (%/năm)</label></td>
                                <td><input type="number" id="myInterestRate" value="${saving.interestRate}" readonly=""></td>
                                <tr>     
                                    <td><label>Trả lãi</label></td>
                                    <td><input type="number" id="payinterest" readonly="" value="0"></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>

            function myLoad() {
                var x = document.getElementById("desposite").value;
                var y = document.getElementById("interestRate").value;
                var z = document.getElementById("priod").value;

                var status = document.getElementById("status").value;
                document.getElementById("profit").value = ((x * y * z) / 1200).toFixed(2);
                if (status != "Active") {
                    document.getElementById("statusSaving").style.display = 'none';
                }
                var todate = document.getElementById("todate").value.toString();
                var arrayToDate = todate.split("/");
                var now = new Date();
                var arrayCurrentDate = now.toLocaleDateString().toString().split("/");
                if (arrayToDate[0].length === 1) {
                    arrayToDate[0] = "0" + arrayToDate[0];
                }
                if (arrayToDate[1].length === 1) {
                    arrayToDate[1] = "0" + arrayToDate[1];
                }
                if (arrayCurrentDate[0].length === 1) {
                    arrayCurrentDate[0] = "0" + arrayCurrentDate[0];
                }
                if (arrayCurrentDate[1].length === 1) {
                    arrayCurrentDate[1] = "0" + arrayCurrentDate[1];
                }
                var fomatTodate = arrayToDate[2] + arrayToDate[1] + arrayToDate[0];
                var fomatCurrentdate = arrayCurrentDate[2] + arrayCurrentDate[1] + arrayCurrentDate[0];
                if (fomatCurrentdate.toString() < fomatTodate.toString()) {
                    document.getElementById("extension").disabled = true;
                    document.getElementById("payment").value = "Trước thời hạn";
                    var i = document.getElementById("anticipatory").value;
                    document.getElementById("myInterestRate").value = i;
                    document.getElementById("payinterest").value = 1000
                } else {
                    document.getElementById("payment").value = "Sau thời hạn";
                }
            }
        </script>
    </body>
</html>
