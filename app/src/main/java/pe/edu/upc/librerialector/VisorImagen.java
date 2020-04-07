package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        ImageView img = (ImageView) findViewById(R.id.ivVisor);
        TextView precioI = (TextView) findViewById(R.id.tvPrecioItem);
        TextView estado = (TextView) findViewById(R.id.tvEstado);
        TextView detalle =(TextView) findViewById(R.id.multiDetalle);
        Button btnTiendas = (Button) findViewById(R.id.btnTiendas);

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
            img.setImageResource(b.getInt("IMG"));
            detalle.setText(b.getString("DETALLE"));
            precioI.setText(b.getString("PRICE"));
        }
    }
}
