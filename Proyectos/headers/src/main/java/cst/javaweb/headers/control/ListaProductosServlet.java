package cst.javaweb.headers.control;
import cst.javaweb.headers.modelo.Producto;
import cst.javaweb.headers.servicio.ProductoService;
import cst.javaweb.headers.servicio.ProductoServiceTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos","/productos-xls","/productos.html"})
public class ListaProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        //Mandamos a llamar la lista de productos implementada
        ProductoService productoService = new ProductoServiceTest();
        List<Producto> productos = productoService.listaProductos();

        //Código para importar a excel:
        String servletPath = req.getServletPath();
        boolean esExcel = servletPath.endsWith("-xls");

        if(esExcel){
            // Importamos a excel
            resp.setContentType("application/vnd.ms-excel");
            // Fijamos los datos del archivo en la cabecera
            resp.setHeader("Content-Disposition","attachment;filename=listaProductos.xls");
        }

        try(PrintWriter salida = resp.getWriter()) {
            if(!esExcel){
                salida.println("<!DOCTYPE html>");
                salida.println("<html>");
                salida.println("    <head>");
                salida.println("        <meta charset=\"UTF-8\">");
                salida.println("        <title>Lista de productos</title>");
                salida.println("    </head>");
                salida.println("    <body>");
                salida.println("        <h1>Listado de productos</h1>");
                salida.println("        <a href=\""+req.getContextPath()+"/productos-xls\">Importar a excel</a>");
            }

            //Tabla:
            salida.println("    <table>");
            salida.println("        <tr>");
            salida.println("            <th>ID</th>");
            salida.println("            <th>Nombre</th>");
            salida.println("            <th>Descripcion</th>");
            salida.println("            <th>Precio</th>");
            salida.println("        </tr>");
            productos.forEach( producto -> {
                salida.println("        <tr>");
                salida.println("            <td>"+producto.getId()+"</td>");
                salida.println("            <td>"+producto.getNombre()+"</td>");
                salida.println("            <td>"+producto.getDescripcion()+"</td>");
                salida.println("            <td>"+producto.getPrecio()+"</td>");
                salida.println("        </tr>");
            });
            salida.println("    </table>");
            //Termina tabla

            if(!esExcel){
                salida.println("    </body>");
                salida.println("</html>");
            }
        }

    }
}
