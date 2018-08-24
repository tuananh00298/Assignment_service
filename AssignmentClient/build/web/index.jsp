<%-- 
    Document   : login
    Created on : Aug 21, 2018, 11:15:32 PM
    Author     : Tuan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <div class="container col-4">
            <h1 class="text-center"><span>USER</span>></h1>
            <form action="Login">

                <div class="form-group">
                    <label for="id">ID</label>
                    <input type="text" name="id" class="form-control" placeholder="" maxlength="10" required/>
                </div>
                <div class="form-group">
                    <label for="password">PASSWORD</label>
                    <input type="password" placeholder="" class="form-control" name="password" maxlength="10" required/>
                </div>
                <div class="center"><input type="submit" class="btn btn-success col-12" value="Login"></div>
            </form>
        
        <div class="footer-copyright text-center py-3">© 2018 Copyright:<a href="#">DeltaDivine</a></div>
        </div>
    </body>
</html>
