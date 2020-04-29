package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class RegistrarProductos extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNombreProducto,edtDescripcionProducto,edtMarcaProducto,edtPrecioProducto,edtMonedaProducto,edtStockProducto,edtUnidadProducto,edtImagenProducto,edtDescuentoProducto;
    private Button btnRegistrarProducto;
    ArrayList<Producto> listaproductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_productos);

        edtNombreProducto = findViewById(R.id.edtNombreProducto);
        edtDescripcionProducto = findViewById(R.id.edtDescripcionProducto);
        edtMarcaProducto = findViewById(R.id.edtMarca);
        edtPrecioProducto = findViewById(R.id.edtPrecioProducto);
        edtMonedaProducto = findViewById(R.id.edtMoneda);
        edtStockProducto = findViewById(R.id.edtStock);
        edtUnidadProducto = findViewById(R.id.edtUnidad);
        edtImagenProducto = findViewById(R.id.edtImagen);
        edtDescuentoProducto = findViewById(R.id.edtDescuentoProducto);

        btnRegistrarProducto = findViewById(R.id.btnRegistrarProducto);

        btnRegistrarProducto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrarProducto:
                /*DBHelper admin = new DBHelper(this,"bdlibrerialector",null,1);
                SQLiteDatabase bdlibrerialector = admin.getWritableDatabase();
                String codigoProducto = edtCodigoProducto.getText().toString();
                String nombreProducto = edtNombreProducto.getText().toString();
                String descripcionProducto = edtDescripcionProducto.getText().toString();
                String precioProducto = edtPrecioProducto.getText().toString();
                String descuentoProducto = edtDescuentoProducto.getText().toString();

                if (!codigoProducto.isEmpty() && !nombreProducto.isEmpty() && !descripcionProducto.isEmpty() && !precioProducto.isEmpty() && !descuentoProducto.isEmpty()){
                    ContentValues registro = new ContentValues();
                    registro.put("codigo",codigoProducto);
                    registro.put("nombre",nombreProducto);
                    registro.put("descripcion",descripcionProducto);
                    registro.put("precio",precioProducto);
                    registro.put("descuento",descuentoProducto);
                    bdlibrerialector.insert("productos",null,registro);
                    bdlibrerialector.close();
                    edtCodigoProducto.setText("");
                    edtNombreProducto.setText("");
                    edtDescripcionProducto.setText("");
                    edtPrecioProducto.setText("");
                    edtDescuentoProducto.setText("");
                    Toast.makeText(this,"Se guardaron los datos",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Llenar todos los campos",Toast.LENGTH_SHORT).show();
                }*/
                //final int codigo=Integer.parseInt(edtCodigoProducto.getText().toString());
                final String nombre=edtNombreProducto.getText().toString();
                final String descripcion=edtDescripcionProducto.getText().toString();
                final String marca=edtMarcaProducto.getText().toString();
                final float precio=Float.parseFloat(edtPrecioProducto.getText().toString());
                final String moneda=edtMonedaProducto.getText().toString();
                final String stock=edtStockProducto.getText().toString();
                final String unidad=edtUnidadProducto.getText().toString();
                final String imagen=edtImagenProducto.getText().toString();
                final float descuento=Float.parseFloat(edtDescuentoProducto.getText().toString());

                String url = "http://lectorlibreria.atwebpages.com/index.php/productos";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistrarProductos.this, "Operación exitosa", LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrarProductos.this,error.toString(), LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parametros=new HashMap<String, String>();
                        parametros.put("nombre",nombre);
                        parametros.put("descripcion",descripcion);
                        parametros.put("marca",marca);
                        parametros.put("precio",precio+"");
                        parametros.put("id_moneda",moneda);
                        parametros.put("stock",stock+"");
                        parametros.put("id_unidad",unidad);
                        parametros.put("imagen",imagen);
                        parametros.put("dcto",descuento+"");
                        return parametros;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(RegistrarProductos.this);
                requestQueue.add(stringRequest);
                break;
        }
    }
}
