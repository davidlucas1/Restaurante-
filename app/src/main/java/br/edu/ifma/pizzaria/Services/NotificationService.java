package br.edu.ifma.pizzaria.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NotificationService extends Service {
        @Override
        public void onCreate() {
            super.onCreate();
            Log.i("Server","server init");

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
            unregistermAllowRebindReceiver(powerConnectionReceiver);
            unregisterReceiver(wifiReceiver);
            sTaskExecutor.shutdown();
            Toast.makeText(this, "Serviço finalizado!!", Toast.LENGTH_SHORT).show();
        }
         */
}
