package pe.edu.upc.librerialector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    String user, clave;
    EditText edtuser, edtpass;
    Button btnlogin,btnregistrar;
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        edtuser=(EditText) findViewById(R.id.edtuser);
        edtpass=(EditText) findViewById(R.id.edtpass);
        contexto=this;
        user=edtuser.getText().toString();
        clave= edtpass.getText().toString();

        btnregistrar = findViewById(R.id.btnregistrar);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Listar = new Intent(view.getContext(), ListarActivity.class);
                if (user=="admin" & clave=="admin"){
                    startActivity(Listar);
                }
                else Toast.makeText(contexto, "Usuario o clave incorrecta", Toast.LENGTH_SHORT).show();
                //Inicio
                final String username = edtuser.getText().toString();
                final String password = edtpass.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(LoginActivity.this,ListarActivity.class);
                                LoginActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("error registro").setNegativeButton("Retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
                //Fin
            }
        });

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(view.getContext(), RegistrarUsuario.class);
                startActivity(registro);
            }
        });
    }
}
