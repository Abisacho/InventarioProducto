
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para gestionar la lista de productos.
 */
public class ProductoRepositorio {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }

    /*
    Busca un producto por su ID.
     */
    public Optional<Producto> buscarProductoPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public boolean actualizarProducto(Producto productoActualizado) {
        Optional<Producto> productoExistente = buscarProductoPorId(productoActualizado.getId());
        if (productoExistente.isPresent()) {
            productos.remove(productoExistente.get());
            productos.add(productoActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}
