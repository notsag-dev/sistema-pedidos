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
 * Created by Tonga on 29/09/2015.
 */
public class AdaptadorItemLineaString  extends BaseAdapter {
    ArrayList<String> valores;
    ArrayList<Integer> identificadores;
    Context context;

    AdaptadorItemLineaString(Context parContext){
        valores = new ArrayList<String>();
        identificadores = new ArrayList<Integer>();
        context = parContext;
        notifyDataSetChanged();
    }

    public void agregarLinea(String s, int id){
        valores.add(s);
        identificadores.add(id);
    }

    @Override
    public int getCount() {
        return valores.size();
    }

    @Override
    public Object getItem(int arg0) {
        return valores.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return identificadores.get(arg0);
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        TextView linea = new TextView(context);
        linea.setText(valores.get(posicion));
        return linea;
    }

    public ArrayList<String> getLineas(){
        return valores;
    }

    public void completarValoresSQL(String consultaFiltro, String nombreCampo){
        try {
            BaseDeDatos baseLocal = new BaseDeDatos(context);
            SQLiteDatabase bd = baseLocal.getReadableDatabase();
            Cursor curStrings = bd.rawQuery(consultaFiltro, null);
            while (curStrings.moveToNext()) {
                valores.add(curStrings.getString(curStrings.getColumnIndexOrThrow(nombreCampo)));
                identificadores.add(curStrings.getInt(curStrings.getColumnIndexOrThrow("_id")));
            }
            notifyDataSetChanged();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
