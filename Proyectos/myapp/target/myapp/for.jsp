<%! int tam; %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>For</title>
</head>
<body>

    <h2>For en JSP</h2>

    <% for(tam=1; tam<=10; tam++) { %>
        <font color="darkblue" size="<%=tam%>">
            Java Server Pages
        </font><br/>
    <% } %>


</body>
</html>