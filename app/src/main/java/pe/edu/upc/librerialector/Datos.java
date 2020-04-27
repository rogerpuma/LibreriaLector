package pe.edu.upc.librerialector;

public class Datos {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private Double precio;
    private String id_moneda;
    private Integer stock;
    private String id_unidad;
    private String imagen;
    Double dcto;

    public Datos(int idProducto, String nombre, String descripcion, String marca, Double precio, String id_moneda, int stock, String id_unidad, String imagen, Double dcto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.id_moneda = id_moneda;
        this.stock = stock;
        this.id_unidad = id_unidad;
        this.imagen = imagen;
        this.dcto = dcto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(String id_moneda) {
        this.id_moneda = id_moneda;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getDcto() {
        return dcto;
    }

    public void setDcto(Double dcto) {
        this.dcto = dcto;
    }
}
