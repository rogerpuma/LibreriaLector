package pe.edu.upc.librerialector;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static pe.edu.upc.librerialector.R.id.listViewProductos;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoListarProductos#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FragmentoListarProductos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoListarProductos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoListarProductos newInstance(String param1, String param2) {
        FragmentoListarProductos fragment = new FragmentoListarProductos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public FragmentoListarProductos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    private TextView tv1;
    private ListView lv1;

    private String descripciones [] = {"Lapicero","Borrador","Papel A4", "Tajador", "Plumones", "Colores"};
    private String precios [] = {"10.00","11.00","12.00", "13.00", "14.00", "15.00"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_listar_productos, container, false);
    }
}
