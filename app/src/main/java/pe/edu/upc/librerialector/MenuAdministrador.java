package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdministrador extends AppCompatActivity implements View.OnClickListener{
    private Button btnRegistrarProductos,btnModificarProductos,btnEliminarProductos,btnListarProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);

        btnRegistrarProductos = findViewById(R.id.btnRegistrarProductos);
        btnModificarProductos = findViewById(R.id.btnModificarProductos);
        btnEliminarProductos = findViewById(R.id.btnEliminarProductos);
        btnListarProductos = findViewById(R.id.btnBuscarProductos);

        btnRegistrarProductos.setOnClickListener(this);
        btnModificarProductos.setOnClickListener(this);
        btnEliminarProductos.setOnClickListener(this);
        btnListarProductos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegistrarProductos:
                Intent registrar = new Intent(v.getContext(), RegistrarProductos.class);
                startActivity(registrar);
                break;
            case R.id.btnModificarProductos:
                Intent modificar = new Intent(v.getContext(), ModificarProductos.class);
                startActivity(modificar);
                break;
            case R.id.btnEliminarProductos:
                Intent eliminar = new Intent(v.getContext(), EliminarProductos.class);
                startActivity(eliminar);
                break;
            case R.id.btnBuscarProductos:
                Intent buscar = new Intent(v.getContext(), BuscarProductos.class);
                startActivity(buscar);
                break;
        }//fin de switch
    }
}
