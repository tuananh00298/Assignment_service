<%-- 
    Document   : menu
    Created on : Aug 23, 2018, 10:27:42 AM
    Author     : Tuan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <div class="container col-6">
            <h1 class="text-center">Hello ${name}</h1>
            <h2 class="text-center">Your balance: ${balance}</h2>
            <div class="row">
                <a href="payment.jsp?id=${id}&name=${name}" class="btn btn-primary col-3">Create New Transaction</a>
                <div class="col-4">
                    <form action="ReceiveHistory">
                        <input type="hidden" value="${id}" name="id"/>
                        <input type="hidden" value="${name}" name="name"/>
                        <input type="submit" class="btn btn-success" value="View Receive Transaction History"/>
                    </form>
                </div>
                <div class="col-4">
                    <form action="SendHistory">
                        <input type="hidden" value="${id}" name="id"/>
                        <input type="hidden" value="${name}" name="name"/>
                        <input type="submit" class="btn btn-success" value="View Send Transaction History"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
