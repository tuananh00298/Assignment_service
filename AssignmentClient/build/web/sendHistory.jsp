<%-- 
    Document   : sendHistory
    Created on : Aug 23, 2018, 4:47:49 PM
    Author     : Tuan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1"  class="table">
            <tr>
                <td scope="col">ID</td>
                <td scope="col">Name</td>
                <td scope="col">Receiver ID</td>
                <td scope="col">Fee</td>
                <td scope="col">Date</td>
                <td scope="col">Received Amount:</td>
                <td scope="col">Bill ID</td>
            </tr>
            <c:forEach items="${ListTransaction}" var="u">
                <tr>
                <td scope="row"><c:out value="${u.id}"/></td>
                <td><c:out value="${u.transactionName}"/></td>
                <td><c:out value="${u.receiverId}"/></td>
                <td><c:out value="${u.transactionFee}"/></td>
                <td><c:out value="${u.transactionDate}"/></td>
                <td><c:out value="${u.receiveAmount}"/></td>
                <td><c:out value="${u.billId}"/></td>
                </tr>
            </c:forEach> 
        </table>
                <form action="index.jsp">
            <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
            <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>
            <input type="submit" class="btn btn-success" value="Back to Menu"/>
        </form>
    </body>
</html>
