package pe.edu.upc.librerialector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorCarrito extends BaseAdapter {

    private static LayoutInflater inflater=null;

    Context contextocar;
    String [][] datoscar;

    public AdaptadorCarrito(Context contextocar, String[][] datoscar){
        this.contextocar=contextocar;
        this.datoscar=datoscar;

        inflater=(LayoutInflater)contextocar.getSystemService(contextocar.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vistacar = inflater.inflate(R.layout.elemento_carrito,null);
        TextView nombre = (TextView) vistacar.findViewById(R.id.tvProdcar);
        TextView  cantidad = (TextView) vistacar.findViewById(R.id.tvCantcar);
        TextView  monto = (TextView) vistacar.findViewById(R.id.tvMontoprod);

        nombre.setText(datoscar[i][0]);
        cantidad.setText(datoscar[i][1]);
        monto.setText(datoscar[i][2]);

        return vistacar;
    }

    @Override
    public int getCount() {
        return datoscar.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
