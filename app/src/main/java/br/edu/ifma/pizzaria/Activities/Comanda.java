package br.edu.ifma.pizzaria.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Adapters.ComandaAdapter;
import br.edu.ifma.pizzaria.Models.Extrato;
import br.edu.ifma.pizzaria.R;

public class Comanda extends AppCompatActivity {
    private List<Extrato> comandaList = new ArrayList<>();
    private RecyclerView comandaRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);

        comandaRecycler = findViewById(R.id.comandaRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        comandaRecycler.setLayoutManager(linearLayoutManager);
        ComandaAdapter adapter = new ComandaAdapter(comandaList);
        comandaRecycler.setAdapter(adapter);
    }

    public void addToComanda(Extrato extrato) {
        comandaList.add(extrato);
        Log.i("comanda", "item adicionado: " + comandaList.get(0).getNome());
    }

}