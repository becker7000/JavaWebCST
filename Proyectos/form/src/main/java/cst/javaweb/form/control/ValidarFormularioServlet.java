package cst.javaweb.form.control;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/formulario-basico")
public class ValidarFormularioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Tipo de codificación:
        resp.setContentType("text/html; charset=UTF-8");

        // Obtenemos los valores de los campos del formulario:
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguaje");
        String idioma = req.getParameter("idioma");

        // Errrores:
        ArrayList<String> errores = new ArrayList<>();
        if(username==null || username.isBlank()){
            errores.add("El nombre de usuario es requerido");
        }
        if(password==null || username.isBlank()){
            errores.add("La contraseña es requerida");
        }
        if(email==null || !email.contains("@")){
            errores.add("El correo es necesario o correo sin @");
        }
        if(pais==null||pais.isBlank()){
            errores.add("El país de origen es necesario");
        }
        if(lenguajes==null || lenguajes.length==0){
            errores.add("Selecciona al menos un lenguaje");
        }
        if(idioma==null||idioma.isBlank()){
            errores.add("El idioma es requerido");
        }

        try (PrintWriter salida = resp.getWriter()) {
            if (errores.isEmpty()) { // Esto es sólo si no se cometen errores
                salida.println("<!DOCTYPE html>");
                salida.println("<html>");
                salida.println("    <head>");
                salida.println("        <meta charset=\"UTF-8\">");
                salida.println("        <title>Datos del formulario</title>");
                salida.println("    </head>");
                salida.println("    <body>");
                salida.println("        <h1>Datos del formulario basico</h1>");

                // Imprimimos los parametros del formulario:
                salida.println("    <ul>");
                salida.println("        <li> Nombre: " + username + " </li>");
                salida.println("        <li> Contraseña: " + password + " </li>");
                salida.println("        <li> Email: " + email + " </li>");
                salida.println("        <li> País: " + pais + " </li>");
                salida.println("<p> Lenguajes: </p>");

                for (int i = 0; i < lenguajes.length; i++) {
                    salida.println("      <li> &nbsp;&nbsp;" + (i + 1) + ")" + lenguajes[i] + "</li>");
                }

                salida.println("        <li> Idioma: " + idioma + " </li>");
                salida.println("    </ul>");

                salida.println("    </body>");
                salida.println("</html>");
            } else {
                errores.forEach(error -> salida.println("<br/>Error: " + error));
            }
        }
    }
}
