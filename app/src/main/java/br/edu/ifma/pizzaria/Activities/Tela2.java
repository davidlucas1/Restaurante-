package br.edu.ifma.pizzaria.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Adapters.BebidasAdapter;
import br.edu.ifma.pizzaria.Adapters.CategoriaAdpter;
import br.edu.ifma.pizzaria.Adapters.MisturaAdapter;
import br.edu.ifma.pizzaria.Adapters.PrincipalAdapter;
import br.edu.ifma.pizzaria.Models.Bebidas;
import br.edu.ifma.pizzaria.Models.Categoria;
import br.edu.ifma.pizzaria.Models.Mistura;
import br.edu.ifma.pizzaria.Models.PratoPrincipal;
import br.edu.ifma.pizzaria.R;

public class Tela2 extends AppCompatActivity {
    private List<Mistura> misturas = new ArrayList<>();
    private List<Bebidas> bebidas = new ArrayList<>();
    private List<PratoPrincipal> pratosPrincipais = new ArrayList<>();
    private RecyclerView.Adapter adapterCat, adapterPP, adapterMistura, adapterBebidas;
    private RecyclerView recyclerViewCatList, recyclerViewPpList, recyclerViewMisturaList, recyclerViewBebidasList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        recyclerViewCategorias();
        recyclerViewPratoPrincipal();
        setRecyclerViewBebidas();
        setRecyclerViewMistura();

    }

    private void setRecyclerViewMistura() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMisturaList= findViewById(R.id.recyclerMistura);
        recyclerViewMisturaList.setLayoutManager(linearLayoutManager);
        MisturaAdapter adapter = new MisturaAdapter(misturas);
        recyclerViewMisturaList.setAdapter(adapter);

        Mistura mistura = new Mistura("Macaxeira Frita", 7.00, R.drawable.macaxeira_frita);
        misturas.add(mistura);

        mistura = new Mistura("Vatapá", 9.00, R.drawable.vatapa);
        misturas.add(mistura);

        mistura = new Mistura("pizza", 35.50, R.drawable.img);
        misturas.add(mistura);
    }
    private void setRecyclerViewBebidas() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBebidasList = findViewById(R.id.recyclerbabidas);
        recyclerViewBebidasList.setLayoutManager(linearLayoutManager);
        BebidasAdapter adapter = new BebidasAdapter(bebidas);
        recyclerViewBebidasList.setAdapter(adapter);

        Bebidas drink = new Bebidas("Cachaça Dona Banana", 40.00, R.drawable.dona_banana);
        bebidas.add(drink);

        drink = new Bebidas("pizza", 35.50, R.drawable.img);
        bebidas.add(drink);

        drink = new Bebidas("pizza", 35.50, R.drawable.img);
        bebidas.add(drink);
    }

    private void recyclerViewPratoPrincipal() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPpList = findViewById(R.id.recyclerPratoP);
        recyclerViewPpList.setLayoutManager(linearLayoutManager);
        PrincipalAdapter adapter = new PrincipalAdapter(pratosPrincipais);
        recyclerViewPpList.setAdapter(adapter);

        PratoPrincipal prato = new PratoPrincipal("Carne de Sol", 50.00, R.drawable.carne_de_sol);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("Moqueca", 30.00, R.drawable.moqueca);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("Baião", 10.00, R.drawable.baiao);
        pratosPrincipais.add(prato);
    }

    private void recyclerViewCategorias() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCatList = findViewById(R.id.recyclerCat);
        recyclerViewCatList.setLayoutManager(linearLayoutManager);
        ArrayList<Categoria> categoriasList = new ArrayList<>();
        categoriasList.add(new Categoria("Prato Principal", "cat_1"));
        categoriasList.add(new Categoria("Mistura", "cat_2"));
        categoriasList.add(new Categoria("Bebidas", "cat_4"));
        categoriasList.add(new Categoria("Sobremesas", "cat_3"));
        categoriasList.add(new Categoria("Lanches", "cat_5"));
        adapterCat = new CategoriaAdpter(categoriasList);
        recyclerViewCatList.setAdapter(adapterCat);
    }
}