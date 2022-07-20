package cst.javaweb.headers.servicio;
import cst.javaweb.headers.modelo.Producto;
import java.util.Arrays;
import java.util.List;

public class ProductoServiceTest implements ProductoService {

    @Override
    public List<Producto> listaProductos() {
        return Arrays.asList(
                new Producto(1,"Coca-Cola","Refresco",22.9f),
                new Producto(2,"Oreo","Galleta de chocolate",18.9f),
                new Producto(3,"Donas","Pan con vainilla",27.8f),
                new Producto(4,"Boing","Jugo con pulpa",14.9f)
        );
    }

}
