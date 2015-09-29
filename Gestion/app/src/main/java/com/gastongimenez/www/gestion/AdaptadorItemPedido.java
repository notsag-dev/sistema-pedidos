package com.gastongimenez.www.gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tonga on 13/04/2015.
 */
public class AdaptadorItemPedido extends BaseAdapter {
    ArrayList<Pedido> pedidos;
    Context context;

    AdaptadorItemPedido(Context parContext){
        pedidos = new ArrayList<Pedido>();
        context = parContext;
        generarListaPedidos();
    }

    public void agregarLinea(Pedido p){
        pedidos.add(p);
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return pedidos.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.elemento_lista_pedidos, parent, false);
        TextView textNombreCliente = (TextView) rowView.findViewById(R.id.clientePedidoItem);
        TextView textImporteTotalPedido = (TextView) rowView.findViewById(R.id.totalPedidoItem);
        String nombre = pedidos.get(posicion).nombreCliente;
        textNombreCliente.setText(nombre);
        String importeTotal = Float.toString(pedidos.get(posicion).importeTotal);
        textImporteTotalPedido.setText(importeTotal);
        return rowView;
    }

    ArrayList<Pedido> getLineas(){
        return pedidos;
    }

    void generarListaPedidos(){
        try {
            BaseDeDatos baseLocal = new BaseDeDatos(context);
            SQLiteDatabase bd = baseLocal.getReadableDatabase();
            Cursor curPedidos = bd.rawQuery("SELECT p._id as id_pedido, p.id_cliente as id_cliente, p.fecha as fecha, p.hora as hora, p.importe_total as importe_total, c.nombre as nombre_cliente, c.rut as rut" +
                    " FROM pedidos p inner join clientes c on p.id_cliente = c._id", null);
            Pedido pedidoAux = null;

            while (curPedidos.moveToNext()) {
                pedidoAux = new Pedido();
                pedidoAux.idCliente = curPedidos.getInt(curPedidos.getColumnIndexOrThrow("id_cliente"));
                pedidoAux.importeTotal = curPedidos.getFloat(curPedidos.getColumnIndexOrThrow("importe_total"));
                pedidoAux.nombreCliente = curPedidos.getString(curPedidos.getColumnIndexOrThrow("nombre_cliente"));;
                pedidoAux.fecha = curPedidos.getInt(curPedidos.getColumnIndexOrThrow("fecha"));
                pedidos.add(pedidoAux);
            }
            notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
