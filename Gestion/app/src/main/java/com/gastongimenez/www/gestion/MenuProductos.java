package com.gastongimenez.www.gestion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MenuProductos extends ActionBarActivity {
    ListView listaProductos;
    EditText filtroProductos;
    Spinner listaCategorias;
    Context contexto;
    AdaptadorItemLineaProducto adaptadorProductos;
    AdaptadorItemLineaString adaptadorCategorias;
    Long idCategoriaFiltro;
    String filtroSQLNombre;
    String filtroSQLCategoria;
    Integer auxFiltroCatTodos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contexto = getApplicationContext();
        setContentView(R.layout.activity_menu_productos);
        listaProductos = (ListView) findViewById(R.id.listaProductos);
        adaptadorProductos = new AdaptadorItemLineaProducto (contexto);
        listaProductos.setAdapter(adaptadorProductos);
        adaptadorCategorias = new AdaptadorItemLineaString(contexto);
        adaptadorCategorias.agregarLinea("Todas",-1);
        adaptadorCategorias.completarValoresSQL("select * from categorias","nombre");


        idCategoriaFiltro = auxFiltroCatTodos.longValue();
        listaCategorias = (Spinner) findViewById(R.id.listaCategoriasProductos);
        listaCategorias.setAdapter(adaptadorCategorias);
        listaCategorias.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (id != auxFiltroCatTodos.longValue()){
                    filtroSQLCategoria = " and id_categoria = " + id;
                } else {
                    filtroSQLCategoria = "";
                }
                adaptadorProductos.completarProductos(filtroSQLNombre + filtroSQLCategoria);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        filtroProductos = (EditText) findViewById(R.id.filtroProducto);
        filtroProductos.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtroSQLNombre = "where nombre like '%" + filtroProductos.getText().toString() + "%'";
                adaptadorProductos.completarProductos(filtroSQLNombre + filtroSQLCategoria);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        filtroSQLCategoria = "";
        filtroSQLNombre = "where nombre like '%'";
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
