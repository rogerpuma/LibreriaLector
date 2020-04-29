package pe.edu.upc.librerialector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class AdaptadorListaPedidos extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contexto;
    List<DatosPedido> pedidos;

    public AdaptadorListaPedidos(Context contexto, List<DatosPedido> pedidos) {
        this.contexto = contexto;
        this.pedidos = pedidos;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public List<DatosPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<DatosPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int i) {
        return pedidos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return pedidos.get(i).getIdPedido();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate=LayoutInflater.from(contexto);
        final View vistaPedido = inflater.inflate(R.layout.elemento_listapedido,null);

        TextView npedido= (TextView) vistaPedido.findViewById(R.id.tvNPedido);
        TextView  fecha = (TextView) vistaPedido.findViewById(R.id.tvFecha);
        TextView  importe = (TextView) vistaPedido.findViewById(R.id.tvImporte);

        npedido.setText(pedidos.get(position).getIdPedido());

        fecha.setText(String.valueOf(pedidos.get(position).getFecha()));
        DecimalFormat precision = new DecimalFormat("#.00");
        importe.setText(precision.format(pedidos.get(position).getTotal()));
        return vistaPedido;

    }
}
