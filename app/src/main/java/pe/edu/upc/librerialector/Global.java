package pe.edu.upc.librerialector;

import android.app.Application;

public class Global extends Application {
    private String user;
    private String[][] carritocompras={{"NN","00","00"}};

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String[][] getCarrito() {
        return carritocompras;
    }

    public void setCarrito(String[][] carritocompras) {
        this.carritocompras = carritocompras;
    }



}
