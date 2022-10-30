package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyBroadcastReceiver MyReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Listener objetListener = new Listener();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(objetListener,filter); */
        MyReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.pkg.perform.Ruby");
        if(intentFilter != null)
        {
            registerReceiver(MyReceiver, intentFilter);
        }

    }
/*
    private void  cambiarMensaje(Boolean bool){
        Button button = (Button) findViewById(R.id.button2);
        TextView mensajeCambiante = (TextView) findViewById(R.id.mensajePantalla);
        EditText mensaje = (EditText) findViewById(R.id.editTextTextPersonName2);
        if(bool){
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String mensajeStr = mensaje.getText().toString();
                    mensajeCambiante.setText(mensajeStr);
                }
            });
        }else{
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    mensajeCambiante.setText("No se puede enviar mensaje interno, conecte el cargador");
                }
            });
        }
    }
 */
    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            /*String action  = intent.getAction();
            boolean Cargando = action.equals(Intent.ACTION_POWER_CONNECTED);
            cambiarMensaje(Cargando); */
            String data = intent.getStringExtra("Este es un mensaje de App2");
            Log.i("msg" ,"Mensaje recibido:  " + data);
            Toast.makeText(MainActivity.this, "Mensaje Recibido de App2", Toast.LENGTH_SHORT).show();

        }
    }

}




