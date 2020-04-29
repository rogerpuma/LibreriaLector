package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class carrito extends AppCompatActivity {
    ListView listacarro;
    TextView tvProdcar, tvCantcar, tvmontoprod;
    List<DataDetallePedido> detalle;
    Button btnpagar;
    TextView tvtotal;
    Context contexto;
    Double total=0.00;
    int id_pedido=0;
    String strDate,idusuario;
    String prueba1,prueba2,prueba3,prueba4,prueba5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_carrito);
        contexto=carrito.this;
        Global globalclass = (Global) getApplicationContext();
        //listacarro = (ListView) findViewById(R.id.listaCarrito);
        //btnpagar = (Button) findViewById(R.id.btnPagar);
        //tvtotal =(TextView) findViewById(R.id.tvTotal);
        detalle = new ArrayList<>();
        detalle= globalclass.getCarritocompras();
        idusuario=globalclass.getUser();

        Toast.makeText(this,"carrito cargado:"+detalle.size(), LENGTH_SHORT).show();

        listacarro.setAdapter(new AdaptadorCarrito(contexto, detalle));

        for(int i=0;i<detalle.size();i++){
            total=total+detalle.get(i).getMonto();
        };
        DecimalFormat precision = new DecimalFormat("#.00");

        tvtotal.setText("S/."+precision.format(total));
        btnpagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Toast.makeText(contexto,"Registrando su pedido...", LENGTH_SHORT).show();
               ejecutarServicio("http://lectorlibreria.atwebpages.com/index.php/pedidos");
                Toast.makeText(contexto, "Operación exitosa, gracias por comprar en nuestra tienda", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void ejecutarServicio(String url){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                insertardetalle();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(contexto,error.toString(), LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                Date fecha = new Date();
                SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
                strDate=formateador.format(fecha);
                parametros.put("fecha", strDate);
                parametros.put("total",total.toString());
                parametros.put("id_usuario",idusuario);
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(contexto);
        requestQueue.add(stringRequest);
    }
    public void insertardetalle(){
        String url="http://lectorlibreria.atwebpages.com/index.php/pedidos/consulta/"+idusuario;

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());

                    for (int i=0; i<jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        id_pedido = Integer.parseInt(object.getString("idPedido"));
                    }
                     for(int j=0;j<detalle.size();j++){
                         insertar("http://lectorlibreria.atwebpages.com/index.php/pedidos/detalle",j);
                     }
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
    }
    private void insertar(String url, final int pos){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //Toast.makeText(contexto, "Operación exitosa"+prueba1+"-"+prueba2+"-"+prueba3+"-"+prueba4+"-"+prueba5, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(contexto,error.toString(), LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                DecimalFormat precision = new DecimalFormat("#.00");

                parametros.put("id_producto",String.valueOf(detalle.get(pos).getId_producto()));
                parametros.put("id_pedido", String.valueOf(id_pedido));
                parametros.put("precio",String.valueOf(precision.format(detalle.get(pos).getPrecio())));
                parametros.put("cantidad",String.valueOf(detalle.get(pos).getCantidad()));
                parametros.put("monto",String.valueOf(precision.format(detalle.get(pos).getMonto())));
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(contexto);
        requestQueue.add(stringRequest);
    }
}
