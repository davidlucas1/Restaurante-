package br.edu.ifma.pizzaria.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class ChargerStatusReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if (status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL) {
                Toast.makeText(context, "Dispositivo conectado ao carregador", Toast.LENGTH_SHORT).show();
                // Aqui você pode adicionar sua lógica adicional para quando o dispositivo estiver conectado ao carregador.
            } else {
                Toast.makeText(context, "Dispositivo desconectado do carregador", Toast.LENGTH_SHORT).show();
                // Aqui você pode adicionar sua lógica adicional para quando o dispositivo estiver desconectado do carregador.
            }
        }
    }
}