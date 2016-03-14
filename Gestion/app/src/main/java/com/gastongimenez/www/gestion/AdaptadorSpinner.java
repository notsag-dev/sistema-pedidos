package com.gastongimenez.www.gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tonga on 14/03/2016.
 */
public class AdaptadorSpinner extends BaseAdapter {
    ArrayList<String> valores;
    ArrayList<Integer> identificadores;
    Context context;

    AdaptadorSpinner (Context parContext) {
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
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(  Context.LAYOUT_INFLATER_SERVICE );
        View row=inflater.inflate(R.layout.simple_spinner_item, parent, false);
        TextView label=(TextView)row.findViewById(R.id.textItemSpinner);
        label.setText(valores.get(posicion));
        return row;
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



