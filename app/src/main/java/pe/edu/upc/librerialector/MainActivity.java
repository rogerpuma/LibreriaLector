package pe.edu.upc.librerialector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Fragment> fragments;
    private FragmentTransaction transaction;
    private Button btnListarProductos,btnRegistrarProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListarProductos = (Button)findViewById(R.id.btnBuscarProductos);
        btnRegistrarProductos = (Button)findViewById(R.id.btnRegistrarProductos);

        btnListarProductos.setOnClickListener(this);
        btnRegistrarProductos.setOnClickListener(this);

        fragments = new ArrayList<>();

        fragments.add(new FragmentoListarProductos()); //get(0)
        fragments.add(new FragmentoRegistrarProductos()); //get(1)
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBuscarProductos:
                transaction = getSupportFragmentManager().beginTransaction();
                //transaction.replace(R.id.container, fragments.get(1));
                transaction.replace(R.id.containerProductos,fragments.get(0));
                transaction.commit();

                break;
            case R.id.btnRegistrarProductos:
                transaction = getSupportFragmentManager().beginTransaction();
                //transaction.replace(R.id.container, fragments.get(1));
                transaction.replace(R.id.containerProductos,fragments.get(1));
                transaction.commit();
                break;
        }//fin de switch
    }
}
