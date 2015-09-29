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
 * Created by Tonga on 14/04/2015.
 */
public class AdaptadorItemLineaProducto extends BaseAdapter {


    ArrayList<Producto> productos;
    Context context;

    AdaptadorItemLineaProducto(Context parContext){
        productos = new ArrayList<Producto>();
        context = parContext;
        completarProductos("");
        notifyDataSetChanged();
    }

    public void agregarLinea(Producto c){
        productos.add(c);
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return productos.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.elemento_lista_productos, parent, false);

        // Cantidad de unidades en el pack
        //TextView textCantidadPack = (TextView) rowView.findViewById(R.id.cantidadPackProductos);
        String cantidadPack = productos.get(posicion).cantidadPack;
        //.setText(cantidadPack);

        // Nombre del producto
        TextView textNombreProducto = (TextView) rowView.findViewById(R.id.nombreProductoProductos);
        String nombre = productos.get(posicion).nombre;
        if (cantidadPack.isEmpty()) {
            textNombreProducto.setText(nombre);
        } else {
            textNombreProducto.setText(nombre + " x " + cantidadPack);
        }

        // Precio pack
        TextView textPrecioPack = (TextView) rowView.findViewById(R.id.precioPackProductos);
        textPrecioPack.setText(String.format("%.2f",productos.get(posicion).precioPack));

        // Precio unitario
        TextView textPrecioUnitario = (TextView) rowView.findViewById(R.id.precioUnitarioProductos);
        Float precioUnitario = productos.get(posicion).precioUnitario;
        textPrecioUnitario.setText("Unit.: " + precioUnitario.toString());

        // Precio al publico
        TextView textPrecioPublico = (TextView) rowView.findViewById(R.id.precioPublicoProductos);
        textPrecioPublico.setText("Púb.: " + productos.get(posicion).precioPublico);

        return rowView;
    }

    public ArrayList<Producto> getLineas(){
        return productos;
    }

    public void completarProductos(String filtroNombre){
        try {
            BaseDeDatos baseLocal = new BaseDeDatos(context);
            SQLiteDatabase bd = baseLocal.getReadableDatabase();
            Cursor curProductos = bd.rawQuery("SELECT * FROM productos where nombre like '%" + filtroNombre + "%'", null);
            Producto productoAux = null;
            productos = new ArrayList<Producto>();
            while (curProductos.moveToNext()) {
                productoAux = new Producto();
                productoAux.idProducto = curProductos.getInt(curProductos.getColumnIndexOrThrow("_id"));
                productoAux.nombre = curProductos.getString(curProductos.getColumnIndexOrThrow("nombre"));
                productoAux.cantidadPack = curProductos.getString(curProductos.getColumnIndexOrThrow("cantidad_pack"));
                productoAux.precioUnitario = curProductos.getFloat(curProductos.getColumnIndexOrThrow("precio_unitario"));
                productoAux.cantidadStock = curProductos.getInt(curProductos.getColumnIndexOrThrow("cantidad_stock"));
                productoAux.precioPack = curProductos.getFloat(curProductos.getColumnIndexOrThrow("precio_pack"));
                productoAux.precioPublico = curProductos.getString(curProductos.getColumnIndexOrThrow("precio_publico"));
                //productoAux.categoria = curProductos.getString(curProductos.getColumnIndexOrThrow("categoria"));
                productos.add(productoAux);
            }
            notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
