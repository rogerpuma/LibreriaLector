package pe.edu.upc.librerialector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pe.edu.upc.librerialector.Adaptador;

import static java.lang.Double.parseDouble;

public class VisorImagen extends AppCompatActivity implements DialogoPedido.FinalizaDialogo{

    Context contexto;
    int id_producto,cantidad;
    Double precio, dcto;
    String nombre, moneda;
    List<DataDetallePedido> pedido;
    TextView precioI,estado,detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);
        contexto=VisorImagen.this;
        ImageView img = (ImageView) findViewById(R.id.ivVisor);
        TextView precioI = (TextView) findViewById(R.id.tvPrecioItem);
        TextView estado = (TextView) findViewById(R.id.tvEstado);
        TextView detalle =(TextView) findViewById(R.id.tvDetalle);
        Button btncomprar = (Button) findViewById(R.id.btnComprar);
        Button btnTiendas = (Button) findViewById(R.id.btnTiendas);

        btncomprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new DialogoPedido(contexto, VisorImagen.this);

            }
        });

        btnTiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Tiendas = new Intent(v.getContext(), MapsActivity.class);
                startActivity(Tiendas);
            }
        });

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null){
            id_producto=b.getInt("ID");
            nombre=b.getString("NOMBRE");
            precio =b.getDouble("PRECIO");
            dcto =b.getDouble("DCTO");
            moneda=b.getString("MONEDA");
            precioI.setText(String.valueOf(precio)+" "+moneda);
            img.setImageResource(R.drawable.notf);
            detalle.setText(b.getString("DESCRIPCION"));
        }
    }

    @Override
    public void CantidadDialogo(Integer cant) {
         DialogoMensaje(cant);
    }

    private void DialogoMensaje(Integer cant){
        Global globalclass = (Global) getApplicationContext();
        cantidad=cant;
        precio=precio-precio*dcto;
        Double monto = precio * cantidad;
        pedido=new ArrayList<>();
        pedido = globalclass.getCarritocompras();
        pedido.add(new DataDetallePedido(id_producto,nombre,0,precio,cantidad,monto));

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setMessage("Se agrega al carrito de compras...¿Desea seguir comprando?");
        AlertDialog.Builder builder1 = builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent listar = new Intent(contexto, ListarActivity.class);
                startActivity(listar);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent carrito = new Intent(contexto, carrito.class);
                startActivity(carrito);
            }
        });

        builder.show();
    }
}
