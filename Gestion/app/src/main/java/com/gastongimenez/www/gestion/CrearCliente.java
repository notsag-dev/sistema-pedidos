package com.gastongimenez.www.gestion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tonga on 14/04/2015.
 */
public class CrearCliente extends ActionBarActivity{
    SQLiteDatabase bd;
    EditText nombreCliente;
    EditText rutCliente;
    EditText tel1Cliente;
    EditText tel2Cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_cliente);

        // Obtengo referencias a controles
        nombreCliente = (EditText) findViewById(R.id.nombreClienteIngreso);
        rutCliente = (EditText) findViewById(R.id.rutClienteIngreso);
        tel1Cliente = (EditText) findViewById(R.id.tel1ClienteIngreso);
        tel2Cliente = (EditText) findViewById(R.id.tel2ClienteIngreso);

        // Abro base
        BaseDeDatos baseLocal = new BaseDeDatos(this);
        bd = baseLocal.getReadableDatabase();
    }

    public void guardarCliente(View v){
        if (!nombreCliente.getText().toString().isEmpty()){
            try {
                bd.execSQL("INSERT INTO clientes VALUES (null,'" +
                        nombreCliente.getText().toString() +
                        "','" +
                        rutCliente.getText().toString() +
                        "','" +
                        tel1Cliente.getText().toString() +
                        "','" +
                        tel2Cliente.getText().toString() +
                        "')");
                Intent intent = new Intent(getApplicationContext(), MenuClientes.class);
                startActivity(intent);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuClientes.class);
        startActivity(intent);
    }
}
