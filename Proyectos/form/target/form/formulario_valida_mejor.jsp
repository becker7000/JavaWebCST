<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>

<%
    Map<String,String> errores = (Map<String,String>)request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Mejor validación</title>
    <style>
        small{
            color: red;
        }
    </style>
</head>
<body>

    <h3>Formulario con mejor validación</h3>

    <form action="./validacion-mejor" method="post">
        <div>
            <label for="username">Nombre: </label>
            <input type="text" id="username" name="username" />

            <% if(errores!=null && errores.containsKey("username")){
                out.println("<br/><small>"+errores.get("username")+"</small>");
            } %>

        </div>
        <div>
            <label for="password">Contraseña: </label>
            <input type="password" id="password" name="password" />

            <% if(errores!=null && errores.containsKey("password")){
                out.println("<br/><small>"+errores.get("password")+"</small>");
            } %>

        </div>
        <div>
            <label for="email">Correo: </label>
            <input type="text" id="email" name="email" />
            <% if(errores!=null && errores.containsKey("email")){
                out.println("<br/><small>"+errores.get("email")+"</small>");
            } %>
        </div>
        <div>
            <label for="pais">País: </label>
            <div>
                <select id="pais" name="pais">
                    <option value="mexico">México</option>
                    <option value="colombia">Colombia</option>
                    <option value="argentina">Argentina</option>
                    <option value="brasil">Brasil</option>
                </select>
            </div>

            <% if(errores!=null && errores.containsKey("pais")){
               out.println("<br/><small>"+errores.get("pais")+"</small>");
            } %>

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

            <% if(errores!=null && errores.containsKey("lenguaje")){
                out.println("<br/><small>"+errores.get("lenguaje")+"</small>");
            } %>

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

            <% if(errores!=null && errores.containsKey("idioma")){
               out.println("<br/><small>"+errores.get("idioma")+"</small>");
            } %>

        </div>
        <div>
            <input type="submit" value="Enviar">
        </div>

    </form>

</body>
</html>