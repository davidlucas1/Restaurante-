package br.edu.ifma.pizzaria.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Adapters.ComandaAdapter;
import br.edu.ifma.pizzaria.Adapters.MisturaAdapter;
import br.edu.ifma.pizzaria.Models.Extrato;
import br.edu.ifma.pizzaria.R;

public class Comanda extends AppCompatActivity {
    private RecyclerView comandaRecycler;
    private TextView total;

    Button buttonConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);

        buttonConfirmarPedido = findViewById(R.id.buttonConfirmarPedido);


        ArrayList<Extrato> listaDeObjetos = (ArrayList<Extrato>) getIntent().getSerializableExtra("pedidos");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        comandaRecycler = findViewById(R.id.comandaRecycler);
        comandaRecycler.setLayoutManager(linearLayoutManager);
        ComandaAdapter adapter = new ComandaAdapter(listaDeObjetos);
        comandaRecycler.setAdapter(adapter);

        total = findViewById(R.id.extratoTotal);
        Double valor = 0.0;
        for(int i = 0; i < listaDeObjetos.size(); i++){
            valor = valor + listaDeObjetos.get(i).getTotal();
        }
        total.setText(String.valueOf(valor));

        createNotificationChannel();

        buttonConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancarNotification();
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });
    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("serviceinfo", "passou no IF createNotificationChannel()");
            CharSequence name = "informatica";
            String description = "notificacao informatica";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("100", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void lancarNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "100")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Pedido Realizado!")
                .setContentText("Pedido feito com sucesso!");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            Log.i("serviceinfo", "sem permissão");
        } else {
            Log.i("serviceinfo", "com permissão");
            notificationManager.notify(1, builder.build());
        }
    }

}