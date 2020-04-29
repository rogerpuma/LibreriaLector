package pe.edu.upc.librerialector;

import java.util.Date;

public class DatosPedido {
    int idPedido;
    Date fecha;
    Double total;
    String id_usuario;

    public DatosPedido(int idPedido, Date fecha, Double total, String id_usuario) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.total = total;
        this.id_usuario = this.id_usuario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
