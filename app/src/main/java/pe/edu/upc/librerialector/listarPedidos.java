package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class listarPedidos extends AppCompatActivity {
    private String usuario, nombre;
    ListView lista;
    ArrayList<DatosPedido> pedidos;
    TextView tvUsuario;
    Button btnRegresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pedidos);
        pedidos=new ArrayList<>();
        lista=(ListView)findViewById(R.id.lvPedidos);
        tvUsuario=(TextView)findViewById(R.id.tvUsuario);
        btnRegresa=(Button)findViewById(R.id.btnRegPed);
        Global globalclass = (Global) getApplicationContext();
        usuario=globalclass.getUser();
        tvUsuario.setText(usuario);

        String url="http://lectorlibreria.atwebpages.com/index.php/pedidos/"+usuario;
        lista = (ListView) findViewById(R.id.list1);
        pedidos = new ArrayList<>();

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());
                    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh;mm;ss");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        pedidos.add(new DatosPedido(
                                Integer.parseInt(object.getString("idPedido")),
                                formateador.parse(object.getString("fecha")),
                                Double.parseDouble( object.getString("total")),
                                object.getString("id_usuario")));

                    }
                    AdaptadorListaPedidos miadaptador = new AdaptadorListaPedidos(getApplicationContext(),pedidos);
                    lista.setAdapter(miadaptador);

                } catch (JSONException | ParseException e) {
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

        //Toast.makeText(this,"buscaste:"+criterio,Toast.LENGTH_SHORT).show();

        /////////////////////////////////////////////////////////////////////////////////////////
        btnRegresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista= new Intent(view.getContext(),ListarActivity.class);
                startActivity(lista);
            }
        });
    }
}
