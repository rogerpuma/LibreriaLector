package pe.edu.upc.librerialector;

public class ProductoDAO {
    private int codigoProducto;
    private String nombreProducto,descripcionProducto,precioProducto,descuentoProducto;

    public int getCodigoProducto() {        return codigoProducto;    }

    public void setCodigoProducto(int codigoProducto) {        this.codigoProducto = codigoProducto;    }

    public String getNombreProducto() {        return nombreProducto;    }

    public void setNombreProducto(String nombreProducto) {        this.nombreProducto = nombreProducto;    }

    public String getDescripcionProducto() {        return descripcionProducto;    }

    public void setDescripcionProducto(String descripcionProducto) {        this.descripcionProducto = descripcionProducto;    }

    public String getPrecioProducto() {        return precioProducto;    }

    public void setPrecioProducto(String precioProducto) {        this.precioProducto = precioProducto;    }

    public String getDescuentoProducto() {        return descuentoProducto;    }

    public void setDescuentoProducto(String descuentoProducto) {        this.descuentoProducto = descuentoProducto;    }
}
