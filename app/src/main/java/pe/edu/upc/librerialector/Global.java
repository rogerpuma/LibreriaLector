package pe.edu.upc.librerialector;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Global extends Application {
    private String user="U00000";
    private List<DataDetallePedido> carritocompras=new ArrayList<>();

    public List<DataDetallePedido> getCarritocompras() {
        return carritocompras;
    }

    public void setCarritocompras(List<DataDetallePedido> carritocompras) {
        this.carritocompras = carritocompras;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void setCarrito(List<DataDetallePedido> carritocompras) {

        this.carritocompras = carritocompras;
    }



}
