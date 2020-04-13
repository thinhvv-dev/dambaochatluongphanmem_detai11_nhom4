<%-- 
    Document   : rutso
    Created on : Apr 4, 2020, 9:13:10 PM
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
            .modal-lg {
                min-width: 1200px !important;
            }
        </style>
    </head>
    <body onload="myLoad()">
        <jsp:include page="/headerCus.jsp"></jsp:include>
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
                    <td><input type="text" id="ngaymo" value="${saving.fromDate}" readonly=""></td>
                    <td><label>Ngày đáo hạn</label></td>
                    <td><input type="text" id="todate" value="${saving.toDate}" readonly="" readonly=""></td>
                </tr>
                <tr id="statusSaving">
                    <!--<td colspan="2"><button type="button" class="btn btn-success" id="extension">Rút lãi và gia hạn</button></td>-->
                    <td colspan="4"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">Rút sổ tiết kiệm</button></td>
                </tr>
            </table>
        </div>
        <div class="modal" id="myModal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="container mt-3" style="text-align: center;">
                        <form action="/customer/rutso" method="post" class="mt-3">
                            <table style="font-size: large" class="table table-borderless" >
                                <tr>
                                    <td><label>Số sổ tiết kiệm</label></td>
                                    <td><input type="number" name="mySavingNumber" value="${saving.numberSaving}" readonly=""></td>
                                    <td><label>Số tiền gửi *</label></td>
                                    <td><input type="number" value="${saving.desposite}" readonly=""></td>
                                </tr>
                                <tr hidden="">
                                    <td><label>Không kì hạn</label></td>
                                    <td><input type="number" name="anticipatory" id="anticipatory" value="${anticipatory}" readonly=""></td>
                                </tr>
                                <tr>     
                                    <td><label>Kì hạn</label></td>
                                    <td><input type="text" id="songayguidunghan" readonly="" value="0"></td>
                                    <td><label>Lãi suất (%/năm)</label></td>
                                    <td><input type="number" value="${saving.interestRate}" readonly=""></td>
                                </tr>
                                <tr>
                                    <td colspan="1"><label>Tiền lãi</label></td>
                                    <td colspan="3"><input type="number" id="tienlaidunghan" readonly="" value="0"></td>
                                </tr>
                                <tr>     
                                    <td><label>Số ngày gửi quá hạn</label></td>
                                    <td><input type="number" id="songaygui" readonly="" value="0"></td>
                                    <td><label>Lãi suất (%/năm)</label></td>
                                    <td><input type="number" name="myInterestRate" id="myInterestRate" value="${saving.interestRate}" readonly=""></td>

                                </tr>
                                <tr>
                                    <td colspan="1"><label>Tiền lãi</label></td>
                                    <td colspan="3"><input type="number" id="payinterest" readonly="" value="0"></td>
                                </tr>
                                <tr>     
                                    <td colspan="1"><label>Số tiền nhận</label></td>
                                    <td colspan="3"><input type="number" name="sotiennhan" id="sotiennhan" readonly="" value="0"></td>
                                </tr>
                                <tr>     
                                    <td colspan="4"><button type="sumbit" class="btn btn-success" >Rút sổ</button></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function myLoad() {
                var status = document.getElementById("status").value;
//                alert(status);
                if (status != "Active") {
                    document.getElementById("statusSaving").style.display = 'none';

                } else {
                    var x = +document.getElementById("desposite").value;
                    var y = document.getElementById("interestRate").value;
                    var z = +document.getElementById("priod").value;

                    
                    document.getElementById("profit").value = ((x * y * z) / 1200).toFixed(0);

                    var todate = document.getElementById("todate").value.toString();
                    var ngaymo = document.getElementById("ngaymo").value.toString();
                    var arrayToDate = todate.split("/");
                    var arrayNgayMo = ngaymo.split("/");

                    var secondsCurrentdate = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()).getTime();
                    var ngaymo = new Date(arrayNgayMo[2], Number(arrayNgayMo[1]) - 1, arrayNgayMo[0]);
                    var solanquahan = 0;
                    while (true) {
                        let day = ngaymo.getDate();
                        let month = ngaymo.getMonth() + z;
                        let year = ngaymo.getFullYear();
                        let nextDate = new Date(year, month, day);
                        if (day == 30 || day == 31) {
                            if (nextDate.getDate() == 2 || nextDate.getDate() == 3) {
                                nextDate.setDate(1);
                            }
                        }
                        if (secondsCurrentdate < nextDate.getTime()) {
                            break;
                        } else {
                            ngaymo = nextDate;
                            solanquahan = solanquahan + 1;
                        }
                    }
                    var songay = (secondsCurrentdate - ngaymo.getTime()) / 86400000;
                    var i = document.getElementById("anticipatory").value;

                    document.getElementById("myInterestRate").value = i;
                    document.getElementById("songaygui").value = songay;
                    var laiquahan = +((x * i * songay) / 36500).toFixed(0);
                    document.getElementById("payinterest").value = laiquahan;

                    document.getElementById("songayguidunghan").value = solanquahan + " x " + z + " Tháng";
                    var laidunghan = +((x * y * solanquahan * z) / 1200).toFixed(0);
                    document.getElementById("tienlaidunghan").value = laidunghan;

                    document.getElementById("anticipatory").value = 0;
                    document.getElementById("sotiennhan").value = x + laiquahan + laidunghan;
                }
            }
        </script>
    </body>
</html>
