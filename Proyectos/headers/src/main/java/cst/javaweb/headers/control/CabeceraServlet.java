package cst.javaweb.headers.control;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabeceras")
public class CabeceraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Algunos elementos que podemos obtener del la cabecera del request:
        String methodRequest = req.getMethod();
        String requestURI = req.getRequestURI(); // uniform resource indefier
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String serverName= req.getServerName();
        String schema = req.getScheme();

        resp.setContentType("text/html; charset=UTF-8");
        try(PrintWriter salida = resp.getWriter()) {
            salida.println("<!DOCTYPE html>");
            salida.println("<html>");
            salida.println("    <head>");
            salida.println("        <meta charset=\"UTF-8\">");
            salida.println("        <title>Headers</title>");
            salida.println("    </head>");
            salida.println("    <body>");
            salida.println("        <h1>Cabecera:</h1>");
            salida.println("        <ul>");
            salida.println("            <li> Método: "+methodRequest+"</li>");
            salida.println("            <li> URI: "+requestURI+"</li>");
            salida.println("            <li> URL: "+requestURL+"</li>");
            salida.println("            <li> Context path: "+contextPath+"</li>");
            salida.println("            <li> Servlet path: "+servletPath+"</li>");
            salida.println("            <li> IP: "+ip+"</li>");
            salida.println("            <li> Port: "+port+"</li>");
            salida.println("            <li> Server name: "+serverName+"</li>");
            salida.println("            <li> Scheme: "+schema+"</li>");
            salida.println("        </ul>");
            salida.println("    </body>");
            salida.println("</html>");
        }

    }
}
