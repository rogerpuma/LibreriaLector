package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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

import java.io.StringReader;
import java.text.DecimalFormat;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        contexto=carrito.this;
        Global globalclass = (Global) getApplicationContext();
        listacarro = (ListView) findViewById(R.id.listaCarrito);
        btnpagar = (Button) findViewById(R.id.btnPagar);
        tvtotal =(TextView) findViewById(R.id.tvTotal);
        detalle = new ArrayList<>();
        detalle= globalclass.getCarritocompras();

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
            }
        });
    }
    private void ejecutarServicio(String url){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(contexto, "Operación exitosa", LENGTH_SHORT).show();
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
                parametros.put("fecha",new Date().toString());
                parametros.put("total",total.toString());
                parametros.put("id_usuario","U00003");
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(contexto);
        requestQueue.add(stringRequest);
    }
}
