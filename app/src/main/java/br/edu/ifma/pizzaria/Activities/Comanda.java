package br.edu.ifma.pizzaria.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);

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

    }

}