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
public class AdaptadorItemLineaCliente  extends BaseAdapter {


    ArrayList<Cliente> clientes;
    Context context;

    AdaptadorItemLineaCliente(Context parContext){
        clientes = new ArrayList<Cliente>();
        context = parContext;
        completarClientes("");
        notifyDataSetChanged();
    }

    public void agregarLinea(Cliente c){
        clientes.add(c);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return clientes.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.elemento_lista_clientes, parent, false);

        //ImageView imagenCliente = (ImageView) rowView.findViewById(R.id.imagenClienteClientes);
        TextView textNombreCliente = (TextView) rowView.findViewById(R.id.nombreClienteClientes);
        String nombre = clientes.get(posicion).nombre;
        textNombreCliente.setText(nombre);

        return rowView;
    }

    public ArrayList<Cliente> getLineas(){
        return clientes;
    }

    public void completarClientes(String filtroNombre){
        try {
            BaseDeDatos baseLocal = new BaseDeDatos(context);
            SQLiteDatabase bd = baseLocal.getReadableDatabase();
            Cursor curClientes = bd.rawQuery("SELECT * FROM clientes where nombre like '%" + filtroNombre + "%'", null);
            Cliente clienteAux = null;
            clientes = new ArrayList<Cliente>();
            while (curClientes.moveToNext()) {
                clienteAux = new Cliente();
                clienteAux.idCliente = curClientes.getInt(curClientes.getColumnIndexOrThrow("_id"));
                clienteAux.nombre = curClientes.getString(curClientes.getColumnIndexOrThrow("nombre"));
                clienteAux.rut = curClientes.getString(curClientes.getColumnIndexOrThrow("rut"));
                clienteAux.telefono_1 = curClientes.getString(curClientes.getColumnIndexOrThrow("telefono_1"));
                clienteAux.telefono_2 = curClientes.getString(curClientes.getColumnIndexOrThrow("telefono_2"));
                clientes.add(clienteAux);
            }
            notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

