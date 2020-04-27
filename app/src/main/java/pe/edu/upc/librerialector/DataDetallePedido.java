package pe.edu.upc.librerialector;

public class DataDetallePedido {
    int id_producto;
    String nombre;
    int id_pedido;
    Double precio;
    int cantidad;
    Double monto;

    public DataDetallePedido(int id_producto, String nombre, int id_pedido, Double precio, int cantidad, Double monto) {
        this.id_producto = id_producto;
        this.nombre=nombre;
        this.id_pedido = id_pedido;
        this.precio = precio;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
