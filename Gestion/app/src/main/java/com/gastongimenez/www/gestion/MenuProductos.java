package com.gastongimenez.www.gestion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


public class MenuProductos extends ActionBarActivity {
    ListView listaProductos;
    EditText filtroProductos;
    AdaptadorItemLineaProducto adaptadorProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_productos);
        listaProductos = (ListView) findViewById(R.id.listaProductos);
        adaptadorProductos = new AdaptadorItemLineaProducto (getApplicationContext());
        listaProductos.setAdapter(adaptadorProductos);
        filtroProductos = (EditText) findViewById(R.id.filtroProducto);
        filtroProductos.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adaptadorProductos.completarProductos(filtroProductos.getText().toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_productos, menu);
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

    public void agregarProducto (View v){
        Intent intent = new Intent(getApplicationContext(), CrearProducto.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
        startActivity(intent);
    }
}
