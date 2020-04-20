package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarProductos extends AppCompatActivity implements View.OnClickListener{
    private EditText edtCodigoProducto,edtNombreProducto,edtDescripcionProducto,edtPrecioProducto,edtDescuentoProducto;
    private Button btnRegistrarProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_productos);

        edtCodigoProducto = findViewById(R.id.edtCodigoProducto);
        edtNombreProducto = findViewById(R.id.edtNombreProducto);
        edtDescripcionProducto = findViewById(R.id.edtDescripcionProducto);
        edtPrecioProducto = findViewById(R.id.edtPrecioProducto);
        edtDescuentoProducto = findViewById(R.id.edtDescuentoProducto);

        btnRegistrarProducto = findViewById(R.id.btnRegistrarProducto);

        btnRegistrarProducto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrarProducto:
                DBHelper admin = new DBHelper(this,"bdlibrerialector",null,1);
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
                }
                break;
        }
    }
}
