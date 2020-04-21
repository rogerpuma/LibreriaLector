package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListarActivity extends AppCompatActivity {

    ListView lista;
    String[][] datos = {
            {"Simplisimo book", "COQUITO", "S/.25.00","Se publicó el 2010 como parte de una gran colección"},
            {"Acuarela", "BARRILITO", "S/.19.00","Kit de acuarelas de divertidos colores"},
            {"Crayones", "CARIOCA", "S/.4.50","De alta calidad y nno contaminante"},
            {"Cuchilla", "OLFA", "S/.10.00","Ideal para cortar cartones, su uso siempre debe estar supervisado por un adulto"},
            {"Playdoh", "NORMA", "S/.25.00","Divertida masita no contaminante para que su niño pueda divertirse dandole forma"},
            {"Silicona líquida", "ARTESCO", "S/.12.50","Ideal para pegar cartones y plásticos"},
            {"Tempera en botella", "JOVY", "S/.8.90","No contiene materiales contaminantes, ideal para pintar grandes areas de trabajo"}
    };

    int[] datosIng ={R.drawable.libro_simplisimo, R.drawable.acuarela_barrilito, R.drawable.crayones_carioca,R.drawable.cuchilla_olfa, R.drawable.playdoh_norma, R.drawable.silicona_artesco, R.drawable.tempera_botella_jovy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lista = (ListView) findViewById(R.id.list1);
        lista.setAdapter(new Adaptador(this, datos, datosIng));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int posicion, long l) {
                Intent VisorDetalle = new Intent(v.getContext(), VisorImagen.class);
                VisorDetalle.putExtra("IMG",datosIng[posicion]);
                VisorDetalle.putExtra("PRODUCTO", datos[posicion][0]);
                VisorDetalle.putExtra("PRICE", datos[posicion][2]);
                VisorDetalle.putExtra("DETALLE",datos[posicion][3]);
                startActivity(VisorDetalle);
            }
        });

    }
}
