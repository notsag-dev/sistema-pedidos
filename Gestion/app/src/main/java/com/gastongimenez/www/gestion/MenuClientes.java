package com.gastongimenez.www.gestion;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class MenuClientes extends ActionBarActivity {
    AdaptadorItemLineaCliente adaptadorClientes;
    TextView filtroCliente;
    ListView listaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clientes);
        listaClientes = (ListView) findViewById(R.id.listaclientes);
        adaptadorClientes = new AdaptadorItemLineaCliente(getApplicationContext());
        listaClientes.setAdapter(adaptadorClientes);

        //listaClientes.setOnClickListener(new OnItemClickListener() {
        //    public void onItemClick(AdapterView<?> parent, View view,
        //                            int position, long id) {
                // TODO: ACÁ REDIRIGIR PARA VER LOS DATOS DEL CLIENTE
                //Object o = prestListView.getItemAtPosition(position);
                //prestationEco str=(prestationEco)o;//As you are using Default String Adapter
                //Toast.makeText(getBaseContext(), str.getTitle(), Toast.LENGTH_SHORT).show();
        //    }
        //});

        filtroCliente = (EditText) findViewById(R.id.filtroCliente);
        filtroCliente.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adaptadorClientes.completarClientes(filtroCliente.getText().toString());
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
        getMenuInflater().inflate(R.menu.menu_menu_clientes, menu);
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

    public void agregarCliente(View v){
        Intent intent = new Intent(getApplicationContext(), CrearCliente.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
        startActivity(intent);
    }
}
