package cst.javaweb.headers.control;
import com.fasterxml.jackson.databind.ObjectMapper;
import cst.javaweb.headers.modelo.Producto;
import cst.javaweb.headers.servicio.ProductoService;
import cst.javaweb.headers.servicio.ProductoServiceTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos-json")
public class APIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService productoService = new ProductoServiceTest();
        List<Producto> productos = productoService.listaProductos();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream,Producto.class);

        resp.setContentType("text/html; charset=UTF-8");
        try(PrintWriter salida = resp.getWriter()) {
            salida.println("<!DOCTYPE html>");
            salida.println("<html>");
            salida.println("    <head>");
            salida.println("        <meta charset=\"UTF-8\">");
            salida.println("        <title></title>");
            salida.println("    </head>");
            salida.println("    <body>");
            salida.println("        <h1>Detalles del producto</h1>");
            salida.println("        <ul>");
            salida.println("        <li>Nombre: "+producto.getNombre()+"</li>");
            salida.println("        <li>Descripción: "+producto.getDescripcion()+"</li>");
            salida.println("        <li>Precio: "+producto.getPrecio()+"</li>");
            salida.println("        </ul>");
            salida.println("    </body>");
            salida.println("</html>");
        }

    }
}
