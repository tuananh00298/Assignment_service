<%-- 
    Document   : payment
    Created on : Aug 23, 2018, 11:37:31 AM
    Author     : Tuan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Payment</title>
    </head>
    <body>
        <div class="container col-4">
            <h1 class="text-center"><span>NEW </span><lable>Payment</lable></h1>
            <form action="paymentConfirm.jsp" method="GET">

                <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                <div class="form-group">
                    <label for="id">Partner ID:</label>
                    <input type="text" class="form-control" name="partnerId" placeholder="" maxlength="10" required/>
                </div>
                <div class="form-group">
                    <label for="billId">Bill ID:</label>
                    <input type="text" class="form-control" placeholder="" name="billId" maxlength="10" required/>
                </div>
                <div class="form-group">
                    <label for="accountId">Account ID:</label>
                    <input type="text" class="form-control" name="accountId" placeholder="" maxlength="20" required/>
                </div>
                <div class="form-group">
                    <label for="accountPin">Partner's PIN Code:</label>
                    <input type="text" class="form-control" name="accountPin" placeholder="" maxlength="4" required/>
                </div>
                <div class="form-group">
                    <label for="id">Transaction Name:</label>
                    <input type="text" class="form-control" name="transactionName" placeholder="" maxlength="10" required/>
                </div>
                <div class="form-group">
                    <label for="transactionAmount">Payment Amount:</label>
                    <input type="text" class="form-control" name="transactionAmount" placeholder="" required/>
                </div>
                <div class="form-group">
                    <label for="feePayer">Fee Payer:</label>
                    <div class="form-group">
                        <select name="feePayer" class="selectpicker form-control">
                            <option value="1">sender(partner)</option>
                            <option value="2">receiver(you)</option>
                        </select>
                    </div>
                    <input type="submit" value="Next Step" class="btn btn-success col-12"/>
            </form>
            <%
                String id = request.getParameter("id");
                request.setAttribute("id", request.getParameter("id"));
            %>
            <form>
                <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>
                <input type="submit" value="Back to Menu"  class="btn btn-primary col-12"/>
            </form>


        </div>
    </body>
</html>
