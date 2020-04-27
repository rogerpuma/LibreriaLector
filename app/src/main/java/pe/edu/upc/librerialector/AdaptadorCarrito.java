package pe.edu.upc.librerialector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class AdaptadorCarrito extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contextocar;
    List<DataDetallePedido> detalle;



    public AdaptadorCarrito(Context contextocar, List<DataDetallePedido> detalle){
        this.contextocar=contextocar;
        this.detalle=detalle;
        inflater=(LayoutInflater)contextocar.getSystemService(contextocar.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vistacar = inflater.inflate(R.layout.elemento_carrito,null);
        TextView nombre = (TextView) vistacar.findViewById(R.id.tvProdcar);
        TextView  cantidad = (TextView) vistacar.findViewById(R.id.tvCantcar);
        TextView  monto = (TextView) vistacar.findViewById(R.id.tvMontoprod);

        nombre.setText(detalle.get(i).getNombre());

        cantidad.setText((""+detalle.get(i).getCantidad()));
        DecimalFormat precision = new DecimalFormat("#.00");
        monto.setText(precision.format(detalle.get(i).getMonto()));
        return vistacar;
    }

    @Override
    public int getCount() {
        return detalle.size();
    }
    public List<DataDetallePedido> getDetalle() {
        return detalle;
    }
    @Override
    public Object getItem(int i) {

        return detalle.get(i);
    }

    @Override
    public long getItemId(int i) {

        return detalle.get(i).getId_pedido();
    }

}
