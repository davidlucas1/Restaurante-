package br.edu.ifma.pizzaria.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                Toast.makeText(context, "Internet conectada", Toast.LENGTH_SHORT).show();
                // Aqui você pode adicionar sua lógica adicional para quando a internet estiver conectada.
            } else {
                Toast.makeText(context, "Sem conexão com a internet", Toast.LENGTH_SHORT).show();
                // Aqui você pode adicionar sua lógica adicional para quando a internet estiver desconectada.
            }
        }
    }
}