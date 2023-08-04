package br.edu.ifma.pizzaria.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            // Celular conectado ao carregador
            Toast.makeText(context, "Carregador conectado", Toast.LENGTH_SHORT).show();


        }
    }

}
