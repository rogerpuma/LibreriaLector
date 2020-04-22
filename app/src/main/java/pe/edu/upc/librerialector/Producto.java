package pe.edu.upc.librerialector;

import android.media.Image;

public class Producto {
    private int codigo,usuario;
    private String nombre,descripcion;
    private float precio,descuento;
    private Image imagen;

    public int getCodigo() {
        return codigo;
    }

    public int getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
