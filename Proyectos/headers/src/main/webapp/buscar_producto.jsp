
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buscar producto</title>
</head>
<body>

    <h2>Buscar producto</h2>

    <form action="<%=request.getContextPath()%>/buscar-producto" method="post">
        <div>
            <label for="nombre">Nombre del producto: </label>
        </div>
        <div>
            <input type="text" id="nombre" name="nombre" />
        </div>
        <div>
            <input type="submit" value="Buscar">
        </div>

    </form>

</body>
</html>