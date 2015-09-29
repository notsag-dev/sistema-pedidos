package com.gastongimenez.www.gestion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tonga on 09/04/2015.
 */
public class AdaptadorItemLineaPedido  extends BaseAdapter {

    public ArrayList<LineaProducto> lineas;
    public Context context;
    public Float importeTotal;

    AdaptadorItemLineaPedido(Context parContext){
        lineas = new ArrayList<LineaProducto>();
        context = parContext;
        importeTotal = 0f;
    }

    public void agregarLinea(LineaProducto lp){
        importeTotal += lp.precioUnitario * lp.cantidad;
        lineas.add(lp);
    }

    @Override
    public int getCount() {
        return lineas.size();
    }

    @Override
    public Object getItem(int arg0) {
        return lineas.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.elemento_lista_lineas_pedido, parent, false);

        TextView textCantidadItems = (TextView) rowView.findViewById(R.id.cantidadProductosItem);
        TextView textNombreProducto = (TextView) rowView.findViewById(R.id.nombreProductoItem);
        System.out.println("log posicion " + posicion);
        String nombre = lineas.get(posicion).nombreProducto;
        textNombreProducto.setText(nombre);
        String cantidad = Integer.toString(lineas.get(posicion).cantidad);
        textCantidadItems.setText(cantidad);

        return rowView;
    }

    ArrayList<LineaProducto> getLineas(){
        return lineas;
    }

}
