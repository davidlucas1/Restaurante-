package br.edu.ifma.pizzaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Activities.AdapterOrderRecycleView;
import br.edu.ifma.pizzaria.Activities.Pratos;

public class MainActivity extends AppCompatActivity {
    private RecyclerView OrderRecyclerView;
    private List<Pratos> listaDePratos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OrderRecyclerView = findViewById(R.id.orderRecycleView);

        //listagem de pedidos
        this.criarPedido();

        //Configuração do adapter
        AdapterOrderRecycleView AdapterOrderRecycleView = new AdapterOrderRecycleView();

        //Configuração do recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        OrderRecyclerView.setLayoutManager(layoutManager);
        OrderRecyclerView.setHasFixedSize(true);
        OrderRecyclerView.setAdapter(AdapterOrderRecycleView);
    }
    public void criarPedido(){
        Pratos pratos = new Pratos("coxinha", "1", "R$ 2,00");
        this.listaDePratos.add(pratos);

        pratos = new Pratos("Hamburguer", "2", "R$ 10,00");
        this.listaDePratos.add(pratos);

        pratos = new Pratos("Cuscuz", "1", "R$ 5,00");
        this.listaDePratos.add(pratos);

        pratos = new Pratos("Acarajé", "2", "R$ 13,00");
        this.listaDePratos.add(pratos);
    }
}