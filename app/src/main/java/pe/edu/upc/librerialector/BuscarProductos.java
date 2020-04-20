package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarProductos extends AppCompatActivity implements View.OnClickListener{
    private EditText edtCodigoProducto,edtNombreProducto,edtDescripcionProducto,edtPrecioProducto,edtDescuentoProducto;
    private Button btnBuscarProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_productos);
        Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show();
        edtCodigoProducto = findViewById(R.id.edtCodigoProducto);
        btnBuscarProducto = findViewById(R.id.btnBuscarProductos);
        btnBuscarProducto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBuscarProductos:
                DBHelper admin = new DBHelper(this,"bdlibrerialector",null,1);
                SQLiteDatabase bdlibrerialector = admin.getWritableDatabase();
                String codigo = edtCodigoProducto.getText().toString();
                if (!codigo.isEmpty()){
                    Cursor fila = bdlibrerialector.rawQuery(
                            "select nombre, descripcion, precio, descuento from productos where codigo = " + codigo,null);
                    //Toast.makeText(this,"fila.getString(0)",Toast.LENGTH_LONG).show();
                    if (fila.moveToFirst()){
                        edtNombreProducto.setText(fila.getString(0));
                        edtDescripcionProducto.setText(fila.getString(1));
                        edtPrecioProducto.setText(fila.getString(2));
                        edtDescuentoProducto.setText(fila.getString(3));
                        bdlibrerialector.close();
                    } else {
                        Toast.makeText(this,"No existe el codigo",Toast.LENGTH_LONG).show();
                        bdlibrerialector.close();
                    }
                } else {
                    Toast.makeText(this,"Falta el codigo",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void buscar () {
        DBHelper admin = new DBHelper(this,"bdlibrerialector",null,1);
        SQLiteDatabase bdlibrerialector = admin.getWritableDatabase();
        String codigo = edtCodigoProducto.getText().toString();
        if (!codigo.isEmpty()){
            Cursor fila = bdlibrerialector.rawQuery(
                    "select nombre, descripcion, precio, descuento from productos where codigo = " + codigo,null);
            if (fila.moveToFirst()){
                edtNombreProducto.setText(fila.getString(0));
                edtDescripcionProducto.setText(fila.getString(1));
                edtPrecioProducto.setText(fila.getString(2));
                edtDescuentoProducto.setText(fila.getString(3));
                bdlibrerialector.close();
            } else {
                Toast.makeText(this,"No existe el codigo",Toast.LENGTH_LONG).show();
                bdlibrerialector.close();
            }
        } else {
            Toast.makeText(this,"Falta el codigo",Toast.LENGTH_LONG).show();
        }
    }
}
