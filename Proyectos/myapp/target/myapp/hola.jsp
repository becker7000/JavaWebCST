<%-- Esto es una declaración --%>
<%! java.util.Calendar calendario = java.util.Calendar.getInstance(); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Hola</title>
</head>
<body>

    <pre>
    <h2>Hola desde un Java Server Page</h2>
    <%-- ESTO ES UN SCRIPTLET --%>
    <% out.println("Tu dirección es: "+request.getRemoteAddr()); %>

    <% if(calendario.get(java.util.Calendar.AM_PM)==java.util.Calendar.AM ) { %>
        <h4>Buenos dias</h4>
    <% }else{ %>
        <h4>Buenas tardes</h4>
    <% } %>

    <%-- ESTO ES UNA EXPRESION --%>
    <h4>La fecha de hoy: <%=calendario.getTime()%></h4>

</body>
</html>