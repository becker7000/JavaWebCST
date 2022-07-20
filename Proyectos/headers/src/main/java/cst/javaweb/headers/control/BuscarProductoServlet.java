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
import java.util.Optional;

@WebServlet("/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductoService productoService = new ProductoServiceTest();
        String nombre = req.getParameter("nombre");

        // Algoritmo para buscar un objeto en una lista:
        Optional<Producto> encontrado = productoService.listaProductos()
                .stream()
                .filter( producto -> producto.getNombre().contains(nombre))
                .findFirst();


        if(encontrado.isPresent()){
            resp.setContentType("text/html; charset=UTF-8");
            try (PrintWriter salida = resp.getWriter()) {
                salida.println("<!DOCTYPE html>");
                salida.println("<html>");
                salida.println("    <head>");
                salida.println("        <meta charset=\"UTF-8\">");
                salida.println("        <title>Producto encontrado</title>");
                salida.println("    </head>");
                salida.println("    <body>");
                salida.println("        <h1>Detalles del producto</h1>");
                salida.println("        <h3>Nombre: "+encontrado.get().getNombre()+"</h3>");
                salida.println("        <h3>Descripción: "+encontrado.get().getDescripcion()+"</h3>");
                salida.println("        <h3>Precio: "+encontrado.get().getPrecio()+"</h3>");
                salida.println("    </body>");
                salida.println("</html>");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Producto no encontrado");
        }

    }
}
