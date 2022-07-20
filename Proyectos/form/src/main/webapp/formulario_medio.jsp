<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>

<%
    List<String> errores = (List<String>)request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario con validación intermedia</title>
</head>
<body>

    <h2>Formulario con validación nivel intermedio</h2>

    <% if(errores!=null && errores.size()>0){ %>
        <ul>
            <% for(String error : errores){ %>
                <li><%=error%></li>
            <% } %>
        </ul>
    <% } %>

    <form action="./validacion-intermedia" method="post">
        <div>
            <label for="username">Nombre: </label>
            <input type="text" id="username" name="username" />
        </div>
        <div>
            <label for="password">Contraseña: </label>
            <input type="password" id="password" name="password" />
        </div>
        <div>
            <label for="email">Correo: </label>
            <input type="text" id="email" name="email" />
        </div>
        <div>
            <label for="pais">País: </label>
            <select id="pais" name="pais">
                <option value="mexico">México</option>
                <option value="colombia">Colombia</option>
                <option value="argentina">Argentina</option>
                <option value="brasil">Brasil</option>
            </select>
        </div>
        <div>
            <label for="lenguaje">Selecciona tus lenguajes: </label>
            <div>
                <select id="lenguaje" name="lenguaje" multiple>
                    <option value="java">Java</option>
                    <option value="php">PHP</option>
                    <option value="python">Python</option>
                    <option value="javascript">JavaScript</option>
                </select>
            </div>
        </div>
        <div>
            <div>
                <label>Idiomas: </label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="es" />
                <label>Español</label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="en" />
                <label>Inglés</label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="pg" />
                <label>Portugues</label>
            </div>
        </div>
        <div>
            <input type="submit" value="Enviar">
        </div>

    </form>


</body>
</html>