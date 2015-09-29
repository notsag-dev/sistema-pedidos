package com.gastongimenez.www.gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Tonga on 19/03/2015.
 */
public class ItemAutoTextAdapter  extends CursorAdapter implements android.widget.AdapterView.OnItemClickListener {

    private BaseDeDatos bd;
    Context contexto;
    String consultaComienzo;
    String consultaFinal;
    String columnaSelec;
    Cursor cursorUltPosElegida;


    public ItemAutoTextAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        contexto = context;
        consultaComienzo = null;
        consultaFinal = null;
        columnaSelec = null;
        cursorUltPosElegida = null;
    }

    public void setParametrosConsulta (String parConsultaComienzo, String parConsultaFinal, String parColumnaSelec){
        consultaComienzo = parConsultaComienzo;
        consultaFinal = parConsultaFinal;
        columnaSelec = parColumnaSelec;
    }

    @Override
        public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
            BaseDeDatos baseLocal = new BaseDeDatos(contexto);
            SQLiteDatabase bd = baseLocal.getReadableDatabase();
            System.out.println("Log prueba: "+constraint);
            Cursor cursor = bd.rawQuery(consultaComienzo + constraint + consultaFinal, null);
            return cursor;
        }

        public String convertToString(Cursor cursor) {
            final int columnIndex = cursor.getColumnIndexOrThrow(columnaSelec);
            final String str = cursor.getString(columnIndex);
            return str;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            final String text = convertToString(cursor);
            ((TextView) view).setText(text);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final View view =
                    inflater.inflate(android.R.layout.simple_dropdown_item_1line,
                            parent, false);
            return view;
        }

        @Override
        public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
            // Obtengo el cursor posicionado en el lugar donde se hizo click
            cursorUltPosElegida = (Cursor) listView.getItemAtPosition(position);

            // Obtengo el nombre
            String nombre = cursorUltPosElegida.getString(cursorUltPosElegida.getColumnIndexOrThrow(columnaSelec));

            // Actualizo el text view
            ((TextView) view).setText(nombre);
        }
}
