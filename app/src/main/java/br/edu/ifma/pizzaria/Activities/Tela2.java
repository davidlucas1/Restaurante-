package br.edu.ifma.pizzaria.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Adapters.CategoriaAdpter;
import br.edu.ifma.pizzaria.Adapters.PrincipalAdapter;
import br.edu.ifma.pizzaria.Models.Categoria;
import br.edu.ifma.pizzaria.Models.PratoPrincipal;
import br.edu.ifma.pizzaria.R;

public class Tela2 extends AppCompatActivity {
    private List<PratoPrincipal> pratosPrincipais = new ArrayList<>();

    private RecyclerView.Adapter adapterCat, adapterPP, adapterMistura, adapterBebidas;
    private RecyclerView recyclerViewCatList, recyclerViewPpList, recyclerViewMisturaList, recyclerViewBebidasList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        recyclerViewCategorias();
        recyclerViewPratoPrincipal();

    }

    private void recyclerViewPratoPrincipal() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPpList = findViewById(R.id.recyclerPratoP);
        recyclerViewPpList.setLayoutManager(linearLayoutManager);
        PrincipalAdapter adapter = new PrincipalAdapter(pratosPrincipais);
        recyclerViewPpList.setAdapter(adapter);

        PratoPrincipal prato = new PratoPrincipal("pizza", 35.50, R.drawable.img);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("pizza", 35.50, R.drawable.img);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("pizza", 35.50, R.drawable.img);
        pratosPrincipais.add(prato);
    }

    private void recyclerViewCategorias() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCatList = findViewById(R.id.recyclerCat);
        recyclerViewCatList.setLayoutManager(linearLayoutManager);
        ArrayList<Categoria> categoriasList = new ArrayList<>();
        categoriasList.add(new Categoria("Prato Principal", "cat_1"));
        categoriasList.add(new Categoria("Mistura", "cat_2"));
        categoriasList.add(new Categoria("Bebidas", "cat_3"));
        categoriasList.add(new Categoria("Sobremesas", "cat_4"));
        categoriasList.add(new Categoria("Lanches", "cat_5"));

        adapterCat = new CategoriaAdpter(categoriasList);
        recyclerViewCatList.setAdapter(adapterCat);
    }
}