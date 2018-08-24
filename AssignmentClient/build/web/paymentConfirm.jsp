<%-- 
    Document   : paymentConfirm
    Created on : Aug 23, 2018, 12:58:04 PM
    Author     : Tuan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container col-4">
        <form action="NewPayment">
            <h1 class="text-center"><span>NEW</span><lable>Payment</lable></h1>
            <div class="inset">
                <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                <div  class="form-group">Partner ID: <%=request.getParameter("partnerId")%> </div><br>
                <input type="hidden" value="<%=request.getParameter("partnerId")%>" name="partnerId"/>

                <div class="form-group">Bill ID: <%=request.getParameter("billId")%></div><br>
                <input type="hidden" value="<%=request.getParameter("billId")%>" name="billId"/>

                <div class="form-group">Account ID: <%=request.getParameter("accountId")%></div><br>
                <input type="hidden" value="<%=request.getParameter("accountId")%>" name="accountId"/>

                <div class="form-group">Partner's PIN Code: <%=request.getParameter("accountPin")%></div><br>
                <input type="hidden" value="<%=request.getParameter("accountPin")%>" name="accountPin"/>
                <div class="form-group">Transaction Name: <%=request.getParameter("transactionName")%></div><br>
                <input type="hidden" value="<%=request.getParameter("transactionName")%>" name="name"/>
                <div class="form-group">Payment Amount: <%=request.getParameter("transactionAmount")%> (VND)</div><br>
                <input type="hidden" value="<%=request.getParameter("transactionAmount")%>" name="transactionAmount"/>
                <div class="form-group">Fee Payer: <%=request.getParameter("feePayer")%></div><br>
                <%
                    int transactionAmount = Integer.parseInt(request.getParameter("transactionAmount"));
                    int fee;
                    if (transactionAmount > 5000000) {
                        fee = transactionAmount / 200;
                    } else if (transactionAmount > 1000000) {
                        fee = transactionAmount / 100;
                    } else if (transactionAmount > 500000) {
                        fee = transactionAmount / 67;
                    } else if (transactionAmount > 100000) {
                        fee = transactionAmount / 50;
                    } else {
                        fee = 10000;
                    }
                    String finalFee = Integer.toString(fee);
//                    request.setAttribute("id", request.getParameter("id"));
//                    request.setAttribute("partnerId", request.getParameter("partnerId"));
//                    request.setAttribute("billId", request.getParameter("billId"));
//                    request.setAttribute("accountId", request.getParameter("accountId"));
//                    request.setAttribute("accountPin", request.getParameter("accountPin"));
//                    request.setAttribute("transactionAmount", request.getParameter("transactionAmount"));
//                    request.setAttribute("name", request.getParameter("transactionName"));
//                    request.setAttribute("fee", finalFee);
%>
                <div class="form-group">Payment Fee: <%=finalFee%></div><br>
                <input type="hidden" value="<%=finalFee%>" name="fee"/>
                <%
                    String receiveAmount;
                    String sendAmount;
                    String feePayer = request.getParameter("feePayer");
                    if (feePayer.equals("2")) {
                        receiveAmount = Integer.toString(transactionAmount - fee);
                        sendAmount = Integer.toString(transactionAmount);
                    } else {
                        receiveAmount = Integer.toString(transactionAmount);
                        sendAmount = Integer.toString(transactionAmount + fee);

                    }
//                    request.setAttribute("receiveAmount", receiveAmount);
//                    request.setAttribute("sendAmount", sendAmount);
%>
                <div class="form-group">Receive Amount: <%=receiveAmount%></div><br>
                <input type="hidden" value="<%=receiveAmount%>" name="receiveAmount"/>
                <div class="form-group">Send Amount: <%=sendAmount%></div><br>
                <input type="hidden" value="<%=sendAmount%>" name="sendAmount"/>
                <input type="submit" class="btn btn-success col-12" value="Submit"/>
            </div><br>
        </form>
                <form>
                <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>
                <input type="submit" class="btn btn-success col-12" value="Cancel"/>
                </form>
        </div>
    </body>
</html>
