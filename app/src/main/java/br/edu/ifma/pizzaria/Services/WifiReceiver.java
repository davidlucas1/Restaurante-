package br.edu.ifma.pizzaria.Services;

import static android.content.Context.MODE_PRIVATE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.concurrent.Executor;

import br.edu.ifma.pizzaria.Activities.Tela2;

public class WifiReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (networkInfo.isConnected()) {
                // Celular conectado à rede Wi-fi
                Toast.makeText(context, "WifiConectado", Toast.LENGTH_SHORT).show();
                creatNot(context);
            }
        }
    }

    private void creatNot(Context context) {
        Executor executor = new Invoker();
        executor.execute(() -> {
            // task to be performed
            //Para criar notificação
        });
    }

    private class Invoker implements Executor {
        @Override
        public void execute(Runnable r) {
            r.run();
        }
    }

    private void execute() {
        Executor executor = new Invoker();
        executor.execute(() -> {
            // task to be performed
        });
    }
}