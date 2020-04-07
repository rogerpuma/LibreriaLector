package pe.edu.upc.librerialector;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.R.layout;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater=null;

    Context contexto;
    String [][] datos;
    int[]   datosIng;

    public Adaptador(Context contexto, String[][] datos, int[] imagenes ){

        this.contexto=contexto;
        this.datos=datos;
        this.datosIng=imagenes;

        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);


    };

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView  nombre = (TextView) vista.findViewById(R.id.tvNombre);
        TextView  marca = (TextView) vista.findViewById(R.id.tvMarca);
        TextView  preciolista = (TextView) vista.findViewById(R.id.tvPreciolista);
        ImageView imagen=(ImageView) vista.findViewById(R.id.ivlist);

        nombre.setText(datos[i][0]);
        marca.setText(datos[i][1]);
        preciolista.setText(datos[i][2]);

        imagen.setImageResource(datosIng[i]);

        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG",datosIng[(Integer) v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });


        return vista;
    }

    @Override
    public int getCount() {
        return datosIng.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
