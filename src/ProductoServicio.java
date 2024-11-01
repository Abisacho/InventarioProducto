import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoServicio {
    private ProductoRepositorio repositorio = new ProductoRepositorio();
    private List<MovimientoInventario> movimientos = new ArrayList<>();

    public void registrarProducto(Producto producto) {
        repositorio.agregarProducto(producto);
    }

    public List<Producto> listarProductos() {
        return repositorio.obtenerTodosLosProductos();
    }

    public Optional<Producto> buscarProducto(int id) {
        return repositorio.buscarProductoPorId(id);
    }

    public boolean actualizarProducto(Producto producto) {
        return repositorio.actualizarProducto(producto);
    }

    public boolean eliminarProducto(int id) {
        return repositorio.eliminarProducto(id);
    }

    public boolean adicionarExistencias(int idProducto, int cantidad, String motivo) {
        Optional<Producto> producto = repositorio.buscarProductoPorId(idProducto);
        if (producto.isPresent()) {
            producto.get().setCantidad(producto.get().getCantidad() + cantidad);
            MovimientoInventario movimiento = new MovimientoInventario(
                LocalDate.now(), producto.get(), "ADICION", cantidad, motivo
            );
            movimientos.add(movimiento);
            return true;
        }
        return false;
    }

    public boolean disminuirExistencias(int idProducto, int cantidad, String motivo) {
        Optional<Producto> producto = repositorio.buscarProductoPorId(idProducto);
        if (producto.isPresent() && producto.get().getCantidad() >= cantidad) {
            producto.get().setCantidad(producto.get().getCantidad() - cantidad);
            MovimientoInventario movimiento = new MovimientoInventario(
                LocalDate.now(), producto.get(), "DISMINUCION", cantidad, motivo
            );
            movimientos.add(movimiento);
            return true;
        }
        return false;
    }

    public List<MovimientoInventario> listarMovimientos() {
        return movimientos;
    }
}

