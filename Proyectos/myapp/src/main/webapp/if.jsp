<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int numero = 8;  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Ejemplo de if</title>
</head>
<body>

    <h2>Ejemplo de if</h2>

    <% if(numero>=2 && numero<=10){ %>
        <h3>El número se encuentra en el rango</3>
    <% }else{ %>
        <h3>El numero está fuera del rango %>
    <% } %>

</body>
</html>