package pe.edu.upc.librerialector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText edtNombre,edtUsuario,edtPassword,edtEdad;
    Button btnRegistrarUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        edtNombre = findViewById(R.id.edtNombreUsuario);
        edtUsuario = findViewById(R.id.edtUsuarioUsuario);
        edtPassword = findViewById(R.id.edtPasswordUsuario);
        edtEdad = findViewById(R.id.edtEdadUsuario);

        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        btnRegistrarUsuario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            final String name=edtNombre.getText().toString();
            final String username=edtUsuario.getText().toString();
            final String password=edtPassword.getText().toString();
            final int age=Integer.parseInt(edtEdad.getText().toString());

            Response.Listener<String> respoListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if(success){
                            Intent intent = new Intent(RegistrarUsuario.this,LoginActivity.class);
                            RegistrarUsuario.this.startActivity(intent);
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarUsuario.this);
                            builder.setMessage("error registro").setNegativeButton("Retry",null).create().show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, respoListener);
            RequestQueue queue = Volley.newRequestQueue(RegistrarUsuario.this);
            queue.add(registerRequest);
    }
}
