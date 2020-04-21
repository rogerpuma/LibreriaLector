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

import java.util.Collections;

import pe.edu.upc.librerialector.Adaptador;

import static java.lang.Double.parseDouble;

public class VisorImagen extends AppCompatActivity implements DialogoPedido.FinalizaDialogo{
    Context contexto;
    String producto,precio;

    String[][] carro;
    TextView precioI,estado,detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        contexto = this;

        ImageView img = (ImageView) findViewById(R.id.ivVisor);
        TextView precioI = (TextView) findViewById(R.id.tvPrecioItem);
        TextView estado = (TextView) findViewById(R.id.tvEstado);
        TextView detalle =(TextView) findViewById(R.id.tvDetalle);
        Button btncomprar = (Button) findViewById(R.id.btnComprar);
        Button btnTiendas = (Button) findViewById(R.id.btnTiendas);

        btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent pedido = new Intent(this, DialogoPedido.class);*/
                new DialogoPedido(contexto, VisorImagen.this);
            }
        });

        btnTiendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Tiendas = new Intent(v.getContext(), TiendasActivity.class);
                startActivity(Tiendas);
            }
        });

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null){
            producto=b.getString("PRODUCTO");
            precio =b.getString("PRICE");
            img.setImageResource(b.getInt("IMG"));
            detalle.setText(b.getString("DETALLE"));
            precioI.setText(precio);
        }
    }

    @Override
    public void CantidadDialogo(Integer cantidad) {
        DialogoMensaje(cantidad);
    }
    private void DialogoMensaje(final Integer c){
        Global globalclass = (Global) getApplicationContext();
        String precioexacto = precio.substring(3,precio.length()-3);
        Double monto = parseDouble(precioexacto) * c;
        carro = globalclass.getCarrito();

        Integer tamaño = carro.length;

        for ( int i=0; i< tamaño;i++ ){
            carro[i][0]=producto;
            carro[i][1]=precioexacto;
            carro[i][2]=String.valueOf(monto);
        }
        /*if (i == 1) {
            String nombre = carro[0][0];

            if (nombre=="NN"){
                carro[0][0] = producto;
                carro[0][1] = precioexacto;
                carro[0][2] = String.valueOf(monto);
            }
            else{
                carro[i][0] = producto;
                carro[i][1] = precioexacto;
                carro[i][2] = String.valueOf(monto);
            }*/
            globalclass.setCarrito(carro);

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
