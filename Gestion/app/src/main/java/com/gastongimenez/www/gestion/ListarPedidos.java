package com.gastongimenez.www.gestion;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by Tonga on 13/04/2015.
 */
public class ListarPedidos extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listapedidos);

        // Creo el adaptador para manejar la lista de pedidos
        AdaptadorItemPedido adaptadorPedidos = new AdaptadorItemPedido(this.getApplicationContext());
        ListView listaPedidos = (ListView) findViewById(R.id.listapedidos);
        listaPedidos.setAdapter(adaptadorPedidos);
    }

}
