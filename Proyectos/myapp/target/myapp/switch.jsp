<%! int dia = 2; %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Switch</title>
</head>
<body>

    <h2>Switch en JSP</h2>

    <%
        switch(dia){
            case 0:
                out.println("Hoy es domingo");
                break;
            case 1:
                out.println("Hoy es lunes");
                break;
            case 2:
                out.println("Hoy es martes");
                break;
            case 3:
                out.println("Hoy es miercoles");
                break;
            case 4:
                out.println("Hoy es jueves");
                break;
            case 5:
                out.println("Hoy es viernes");
                break;
            case 6:
                out.println("Hoy es sabado");
                break;
        }

    %>

</body>
</html>