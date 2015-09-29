package com.gastongimenez.www.gestion;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CrearPedido extends ActionBarActivity {
    SQLiteDatabase bd;
    AutoCompleteTextView clienteSug;
    AutoCompleteTextView productoSug;
    AdaptadorItemLineaPedido adaptPedido;
    ItemAutoTextAdapter adaptadorCliente;
    ItemAutoTextAdapter adaptadorProducto;
    EditText cantidadProductos;
    Cliente clienteSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_nuevo);

        // Creo referencias a campos
        clienteSug = (AutoCompleteTextView) findViewById(R.id.AutoCompleteCliente);
        clienteSeleccionado = new Cliente();
        productoSug = (AutoCompleteTextView) findViewById(R.id.AutoCompleteProducto);

        // Abro base
        BaseDeDatos baseLocal = new BaseDeDatos(this);
        bd = baseLocal.getReadableDatabase();

        // Seteo sugerencia del cliente
        adaptadorCliente = new ItemAutoTextAdapter(this, bd.rawQuery("SELECT _id, nombre FROM clientes ORDER BY nombre",null),0);
        adaptadorCliente.setParametrosConsulta("SELECT _id, nombre FROM clientes WHERE nombre like'%", "%' ORDER BY nombre ", "nombre");
        clienteSug.setAdapter(adaptadorCliente);
        clienteSug.setOnItemClickListener(adaptadorCliente);

        // Seteo sugerencia producto
        adaptadorProducto = new ItemAutoTextAdapter(this, bd.rawQuery("SELECT _id, nombre, cantidad_stock, precio FROM productos ORDER BY nombre",null),0);
        adaptadorProducto.setParametrosConsulta("SELECT _id, nombre, cantidad_stock, precio FROM productos WHERE nombre like'%", "%' ORDER BY nombre ", "nombre");
        productoSug.setAdapter(adaptadorProducto);
        productoSug.setOnItemClickListener(adaptadorProducto);

        // Seteo adaptador de la lista de líneas
        adaptPedido= new AdaptadorItemLineaPedido(this.getApplicationContext());

        ListView listaLineas = (ListView)findViewById(R.id.lineaspedido);
        listaLineas.setAdapter(adaptPedido);
        listaLineas.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        // Seteo variable del campo de cantidad
        cantidadProductos = (EditText)findViewById(R.id.cantidadProductos);
    }

    public void agregarLineaPedido (View v){
        if (!((productoSug.getText().toString().isEmpty()) || cantidadProductos.getText().toString().isEmpty())) {
            Cursor cursorProducto = adaptadorProducto.cursorUltPosElegida;
            if (cursorProducto != null) {
                LineaProducto laux = new LineaProducto();
                laux.idProducto = cursorProducto.getInt(cursorProducto.getColumnIndexOrThrow("_id"));
                laux.cantidad = Integer.parseInt(cantidadProductos.getText().toString());
                laux.precioUnitario = cursorProducto.getFloat(cursorProducto.getColumnIndexOrThrow("precio"));
                laux.nombreProducto = cursorProducto.getString(cursorProducto.getColumnIndexOrThrow("nombre"));
                adaptPedido.agregarLinea(laux);
                adaptPedido.notifyDataSetChanged();
                cantidadProductos.setText("");
                productoSug.setText("");
            }
        }
    }

    public void guardarPedido (View v){
        try{
            Cursor cursorCliente = adaptadorCliente.cursorUltPosElegida;
            if (cursorCliente != null) {
                clienteSeleccionado.idCliente = cursorCliente.getInt(cursorCliente.getColumnIndexOrThrow("_id"));
                clienteSeleccionado.nombre = cursorCliente.getString(cursorCliente.getColumnIndexOrThrow("nombre"));
                System.out.println("Log prueba> cliente seleccionado " + clienteSeleccionado.nombre + " " + clienteSeleccionado.idCliente);
                bd.execSQL("INSERT INTO pedidos VALUES (null," + clienteSeleccionado.idCliente + ",0,0,"+ adaptPedido.importeTotal+")");
                ArrayList<LineaProducto> lineas = adaptPedido.getLineas();
                Cursor cursor = null;
                cursor = bd.rawQuery("SELECT MAX(_id) AS maxid FROM pedidos", null);
                cursor.moveToLast();
                int maxId = cursor.getInt(0);

                LineaProducto lp = null;
                for (int i = 0; i < adaptPedido.getCount(); i++) {
                    lp = lineas.get(i);
                    bd.execSQL("INSERT INTO lineas_pedidos VALUES (null," +
                            maxId + "," +
                            (i + 1) + "," +
                            lp.idProducto + "," +
                            lp.cantidad + "," +
                            lp.precioUnitario + ")");
                }
                Intent intent = new Intent(getApplicationContext(), MenuPedidos.class);
                startActivity(intent);
            } else {
                System.out.println("log prueba Cliente no seleccionado");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pedido_nuevo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuPedidos.class);
        startActivity(intent);
    }
}
