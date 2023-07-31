package br.edu.ifma.pizzaria.Services;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotificationService extends Service {

        private PowerConnectionReceiver powerConnectionReceiver;
        private WifiReceiver wifiReceiver;

        @Override
        public void onCreate() {
            super.onCreate();
            powerConnectionReceiver = new PowerConnectionReceiver();
            wifiReceiver = new WifiReceiver();
            registerReceiver(powerConnectionReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
            registerReceiver(wifiReceiver, new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION));
        }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    // Implemente os outros métodos da classe Service, se necessário

    /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerConnectionReceiver);
        unregisterReceiver(wifiReceiver);
    }
     */
}
