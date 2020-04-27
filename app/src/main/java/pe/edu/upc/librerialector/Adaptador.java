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

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    List<Datos> ListaObjetos;
    List<DataDetallePedido> Listacarrito;

    public Adaptador(Context contexto, List<Datos> listaObjetos, List<DataDetallePedido> listacarrito) {
        this.contexto = contexto;
        this.ListaObjetos = listaObjetos;
        this.Listacarrito=listacarrito;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public List<Datos> getListaObjetos() {
        return ListaObjetos;
    }

    public void setListaObjetos(List<Datos> listaObjetos) {
        ListaObjetos = listaObjetos;
    }

    public List<DataDetallePedido> getListacarrito() {
        return Listacarrito;
    }

    public void setListacarrito(List<DataDetallePedido> listacarrito) {
        Listacarrito = listacarrito;
    }

    @Override
    public int getCount() {
        return ListaObjetos.size();//retorna cantidad de objetos de la lista
    }

    @Override
    public Object getItem(int position) {
        return ListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaObjetos.get(position).getIdProducto();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate=LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.elemento_lista,null); //Se carga la vista al listview

        ImageView imagen=(ImageView) vista.findViewById(R.id.ivlist);
        TextView  nombre = (TextView) vista.findViewById(R.id.tvNombre);
        TextView  marca = (TextView) vista.findViewById(R.id.tvMarca);
        TextView  preciolista = (TextView) vista.findViewById(R.id.tvPreciolista);

        nombre.setText(ListaObjetos.get(position).getNombre().toString());
        marca.setText(ListaObjetos.get(position).getMarca().toString());
        preciolista.setText(ListaObjetos.get(position).getPrecio().toString());
        imagen.setImageResource(R.drawable.acuarela_barrilito);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG",datosIng[(Integer) v.getTag()]);
                contexto.startActivity(visorImagen);*/
            }
        });


        return vista;
    }

}
