package br.edu.ifma.pizzaria.Services;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.concurrent.Executor;

import br.edu.ifma.pizzaria.Activities.MainActivity;

public class PowerConnectionReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            // Celular conectado ao carregador
            Toast.makeText(context, "Carregador conectado", Toast.LENGTH_SHORT).show();

            creatNot(context);
        }
    }

    private void creatNot(Context context) {
        Executor executor = new Invoker();
        executor.execute(() -> {
            // task to be performed
            final String CHANNEL_ID = "HEADS_UP_NOTIFICATION";
            CharSequence name = "All";
            String description = "Para todos";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            Notification.Builder notification = new Notification.Builder(context, CHANNEL_ID)
                    .setContentTitle("Lembrete!")
                    .setContentText("Verifique os pedidos!")
                    //.setSmallIcon(R.drawable.iconenotificacaoapa)
                    //.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.iconeapa))
                    //.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.iconeapa))
                    //.setContentIntent(resultPendingIntent)
                    .setAutoCancel(true);
            notificationManager.notify(0, notification.build());
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
