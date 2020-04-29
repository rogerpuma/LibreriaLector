package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class EliminarProductos extends AppCompatActivity {
    private EditText edtCodigoProducto;
    private Button btnEliminarProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_productos);

        edtCodigoProducto = findViewById(R.id.edtCodigoProducto);
        btnEliminarProducto = findViewById(R.id.btnBuscarProductos);

        btnEliminarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(EliminarProductos.this,"Eliminando su producto...", LENGTH_SHORT).show();
                ejecutarServicio("http://lectorlibreria.atwebpages.com/index.php/productosEli");
            }
        });
    }
    private void ejecutarServicio(String url){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(EliminarProductos.this, "Operación exitosa", LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EliminarProductos.this,error.toString(), LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("id",edtCodigoProducto.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(EliminarProductos.this);
        requestQueue.add(stringRequest);
    }
}
