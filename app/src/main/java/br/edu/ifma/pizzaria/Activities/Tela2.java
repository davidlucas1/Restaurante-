package br.edu.ifma.pizzaria.Activities;

import static java.security.AccessController.getContext;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Adapters.BebidasAdapter;
import br.edu.ifma.pizzaria.Adapters.CategoriaAdpter;
import br.edu.ifma.pizzaria.Adapters.MisturaAdapter;
import br.edu.ifma.pizzaria.Adapters.PrincipalAdapter;
import br.edu.ifma.pizzaria.Models.Bebidas;
import br.edu.ifma.pizzaria.Models.Categoria;
import br.edu.ifma.pizzaria.Models.Extrato;
import br.edu.ifma.pizzaria.Models.Mistura;
import br.edu.ifma.pizzaria.Models.PratoPrincipal;
import br.edu.ifma.pizzaria.R;
import br.edu.ifma.pizzaria.Services.NotificationService;

public class Tela2 extends AppCompatActivity {
    private ArrayList<Extrato> extratoList = new ArrayList<>();
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

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < pratosPrincipais.size(); i++) {
                    if (pratosPrincipais.get(i).getQuantidade() > 0) {
                        Log.i("quantidade de pratos", "prato: " + pratosPrincipais.get(i).getName() + " quantidade: " + pratosPrincipais.get(i).getQuantidade());
                        Extrato extrato = new Extrato(pratosPrincipais.get(i).getName(), pratosPrincipais.get(i).getQuantidade(), pratosPrincipais.get(i).getPrice() * pratosPrincipais.get(i).getQuantidade());
                        extratoList.add(extrato);
                    }
                }

                for (int i = 0; i < bebidas.size(); i++) {
                    if (bebidas.get(i).getQuantidade() > 0) {
                        Log.i("quantidade de pratos", "prato: " + bebidas.get(i).getName() + " quantidade: " + bebidas.get(i).getQuantidade());
                        Extrato extrato = new Extrato(bebidas.get(i).getName(), bebidas.get(i).getQuantidade(), bebidas.get(i).getPrice() * bebidas.get(i).getQuantidade());
                        extratoList.add(extrato);
                    }
                }

                for (int i = 0; i < misturas.size(); i++) {
                    if (misturas.get(i).getQuantidade() > 0) {
                        Log.i("quantidade de pratos", "prato: " + misturas.get(i).getName() + " quantidade: " + misturas.get(i).getQuantidade());
                        Extrato extrato = new Extrato(misturas.get(i).getName(), misturas.get(i).getQuantidade(), misturas.get(i).getPrice() * misturas.get(i).getQuantidade());
                        extratoList.add(extrato);
                    }
                }

                Intent intent = new Intent(Tela2.this, Comanda.class);
                intent.putExtra("pedidos", (extratoList));

                Log.i("array", String.valueOf(extratoList.size()));

                startActivity(intent);

            }
        });

        startService(new Intent(getBaseContext(), NotificationService.class));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            askNotificationPermission();
        }

    }

    private void setRecyclerViewMistura() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMisturaList = findViewById(R.id.recyclerMistura);
        recyclerViewMisturaList.setLayoutManager(linearLayoutManager);
        MisturaAdapter adapter = new MisturaAdapter(misturas);
        recyclerViewMisturaList.setAdapter(adapter);

        Mistura mistura = new Mistura("Macaxeira Frita", "Serve 4 pessoas", 7.00, R.drawable.macaxeira_frita);
        misturas.add(mistura);

        mistura = new Mistura("Vatapá", "Serve 5 pessoas", 9.00, R.drawable.vatapa);
        misturas.add(mistura);

        mistura = new Mistura("Carangueijo", "Serve 3 pessoas", 30.00, R.drawable.caranguejo);
        misturas.add(mistura);
    }

    private void setRecyclerViewBebidas() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBebidasList = findViewById(R.id.recyclerbabidas);
        recyclerViewBebidasList.setLayoutManager(linearLayoutManager);
        BebidasAdapter adapter = new BebidasAdapter(bebidas);
        recyclerViewBebidasList.setAdapter(adapter);

        Bebidas drink = new Bebidas("Cachaça Dona Banana", "980ml", 20.00, R.drawable.dona_banana);
        bebidas.add(drink);

        drink = new Bebidas("Guaraná Jesus", "350ml", 2.00, R.drawable.guarana_jesus);
        bebidas.add(drink);

        drink = new Bebidas("Cajuina", "500ml", 7.00, R.drawable.cajuina);
        bebidas.add(drink);
    }

    private void recyclerViewPratoPrincipal() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPpList = findViewById(R.id.recyclerPratoP);
        recyclerViewPpList.setLayoutManager(linearLayoutManager);
        PrincipalAdapter adapter = new PrincipalAdapter(pratosPrincipais);
        recyclerViewPpList.setAdapter(adapter);

        PratoPrincipal prato = new PratoPrincipal("Carne de Sol", "Serve 2 pessoas", 20.00, R.drawable.carne_de_sol);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("Moqueca", "Serve 4 pessoas", 30.00, R.drawable.moqueca);
        pratosPrincipais.add(prato);

        prato = new PratoPrincipal("Baião", "Serve 8 pessoas", 10.00, R.drawable.baiao);
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

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // TODO
                } else {
                    // TODO: Inform user that that your app will not show notifications.
                }
            });

    private void askNotificationPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED) {
            // FCM SDK (and your app) can post notifications.
        } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {

        } else {
            // Directly ask for the permission
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
        }
    }
}