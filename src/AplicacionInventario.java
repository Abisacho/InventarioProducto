import java.time.LocalDate;

public class AplicacionInventario {
    public static void main(String[] args) {
        ProductoServicio servicio = new ProductoServicio();

        Producto producto1 = new Producto(1, "Café", "Bebidas", 10, 3.50, LocalDate.of(2024, 12, 31));
        servicio.registrarProducto(producto1);

        servicio.adicionarExistencias(1, 5, "Reposición de stock");
        servicio.disminuirExistencias(1, 3, "Venta de producto");

        System.out.println("Productos en inventario:");
        for (Producto producto : servicio.listarProductos()) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad());
        }

        System.out.println("\nMovimientos registrados:");
        for (MovimientoInventario movimiento : servicio.listarMovimientos()) {
            System.out.println("Fecha: " + movimiento.getFecha() + ", Tipo: " + movimiento.getTipoMovimiento() +
                               ", Producto: " + movimiento.getProducto().getNombre() + ", Cantidad: " + movimiento.getCantidad() +
                               ", Motivo: " + movimiento.getMotivo());
        }
    }
}
