package cst.javaweb.headers.control;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/reloj-dinamico")
public class RelojDinamicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        //Anotación de cabecera para se haga un refresh cada
        //lapso de segundos:
        resp.setHeader("refresh","2");

        // Obtenemos la hora del servidor
        LocalTime hora = LocalTime.now();

        //Le damos formato a la hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm:ss");

        try(PrintWriter salida = resp.getWriter()) {
            salida.println("<!DOCTYPE html>");
            salida.println("<html>");
            salida.println("    <head>");
            salida.println("        <meta charset=\"UTF-8\">");
            salida.println("        <title>Reloj dinamico</title>");
            salida.println("    </head>");
            salida.println("    <body>");
            salida.println("        <h1>Reloj dinamico</h1>");
            salida.println("        <h3>"+hora.format(formato)+"</h3>");
            salida.println("    </body>");
            salida.println("</html>");
        }

    }
}
