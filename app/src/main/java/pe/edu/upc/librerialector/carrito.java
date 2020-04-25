package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class carrito extends AppCompatActivity {
    ListView listacarro;
    TextView tvProdcar, tvCantcar, tvmontoprod;
    Button btnpagar;
    String datoscar[][];
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_carrito);
        contexto=this;
        Global globalclass = (Global) getApplicationContext();
        //listacarro = (ListView) findViewById(R.id.listaCarrito);
        //btnpagar = (Button) findViewById(R.id.btnPagar);
        datoscar= globalclass.getCarrito();

        Toast.makeText(this,"carrito cargado:"+datoscar.length, LENGTH_SHORT).show();
        listacarro.setAdapter(new AdaptadorCarrito(this,datoscar));

        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Toast.makeText(contexto,"Se registra su pedido", LENGTH_SHORT).show();

            }
        });
    }
}
