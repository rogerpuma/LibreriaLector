package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<DataDetallePedido> listacarrito = new ArrayList<>();
    ArrayList<Datos> listadatos;
    EditText edtCriterio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        lista = (ListView) findViewById(R.id.list1);
        listadatos = new ArrayList<>();
        String url="http://lectorlibreria.atwebpages.com/index.php/productos";
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        listadatos.add(new Datos(
                                Integer.parseInt(object.getString("idProducto")),
                                object.getString("nombre"),
                                object.getString("descripcion"),
                                object.getString("marca"),
                                Double.parseDouble(object.getString("precio")),
                                object.getString("id_moneda"),
                                Integer.parseInt(object.getString("stock")),
                                object.getString("id_unidad"),
                                object.getString("imagen"),
                                Double.parseDouble(object.getString("dcto"))));

                    }
                    Adaptador miadaptador = new Adaptador(getApplicationContext(),listadatos,listacarrito);
                    lista.setAdapter(miadaptador);

                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Toast.makeText(this,"Productos de tu libreria",Toast.LENGTH_SHORT).show();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int posicion, long l) {

                Intent VisorDetalle = new Intent(v.getContext(), VisorImagen.class);
                VisorDetalle.putExtra("ID",listadatos.get(posicion).getIdProducto());
                VisorDetalle.putExtra("IMG",listadatos.get(posicion).getImagen());
                VisorDetalle.putExtra("NOMBRE", listadatos.get(posicion).getNombre());
                VisorDetalle.putExtra("PRECIO", listadatos.get(posicion).getPrecio());
                VisorDetalle.putExtra("MONEDA", listadatos.get(posicion).getId_moneda());
                VisorDetalle.putExtra("DESCRIPCION",listadatos.get(posicion).getDescripcion());
                VisorDetalle.putExtra("DCTO",listadatos.get(posicion).getDcto());

                startActivity(VisorDetalle);

            }
        });

    }

    public void buscar(View v){
        EditText edtCriterio = (EditText) findViewById(R.id.edtBuscar);
        String criterio=edtCriterio.getText().toString();
        String url="http://lectorlibreria.atwebpages.com/index.php/productos/"+criterio;
        lista = (ListView) findViewById(R.id.list1);
        listadatos = new ArrayList<>();

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        listadatos.add(new Datos(
                                Integer.parseInt(object.getString("idProducto")),
                                object.getString("nombre"),
                                object.getString("descripcion"),
                                object.getString("marca"),
                                Double.parseDouble(object.getString("precio")),
                                object.getString("id_moneda"),
                                Integer.parseInt(object.getString("stock")),
                                object.getString("id_unidad"),
                                object.getString("imagen"),
                                Double.parseDouble(object.getString("dcto"))));

                    }
                    Adaptador miadaptador = new Adaptador(getApplicationContext(),listadatos,listacarrito);
                    lista.setAdapter(miadaptador);

                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        Toast.makeText(this,"buscaste:"+criterio,Toast.LENGTH_SHORT).show();
    }

}
