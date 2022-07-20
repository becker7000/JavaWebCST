package cst.javaweb.myapp.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola")
public class HolaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter salida = resp.getWriter() ;

        //Generamos nuestro html:
        salida.println("<!DOCTYPE html>");
        salida.println("<html>");
        salida.println("<head>");
        salida.println("    <meta charset=\"UTF-8\">");
        salida.println("    <title>Hola servlet</title>");
        salida.println("</head>");
        salida.println("<body>");
        salida.println("    <h2>Hola a todos desde un Servlet</h2>");
        for(int i=0; i<7; i++){
            salida.println("    <h4 style='color: darkblue'> i = "+i+"</h4>");
        }
        salida.println("</body>");
        salida.println("</html>");

    }


}
