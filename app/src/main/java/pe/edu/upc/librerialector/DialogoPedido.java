package pe.edu.upc.librerialector;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DialogoPedido {

    public interface FinalizaDialogo{
        void CantidadDialogo(Integer cantidad);
    }

    private FinalizaDialogo interfaz;

    public DialogoPedido(final Context contexto, FinalizaDialogo actividad){

        interfaz=actividad;

        final Dialog dialogo= new Dialog(contexto);

        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setContentView(R.layout.cantidad);

        final TextView tvdPedido = (TextView) dialogo.findViewById(R.id.tvdpedido);
        final EditText edtCantidad = (EditText) dialogo.findViewById(R.id.edtCantidad);
        TextView tvAceptar = (TextView) dialogo.findViewById(R.id.tvAceptar);
        TextView tvCancelar = (TextView) dialogo.findViewById(R.id.tvCancelar);

        tvAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interfaz.CantidadDialogo(Integer.parseInt(edtCantidad.getText().toString()));

                dialogo.dismiss();
            }
        });
        tvCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }


}
