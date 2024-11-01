import java.time.LocalDate;

public class MovimientoInventario {
    private LocalDate fecha;
    private Producto producto;
    private String tipoMovimiento; // "ADICION" o "DISMINUCION"
    private int cantidad;
    private String motivo;

    public MovimientoInventario(LocalDate fecha, Producto producto, String tipoMovimiento, int cantidad, String motivo) {
        this.fecha = fecha;
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public LocalDate getFecha() { return fecha; }
    public Producto getProducto() { return producto; }
    public String getTipoMovimiento() { return tipoMovimiento; }
    public int getCantidad() { return cantidad; }
    public String getMotivo() { return motivo; }
}
