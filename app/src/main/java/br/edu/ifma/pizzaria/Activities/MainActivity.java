package br.edu.ifma.pizzaria.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.ifma.pizzaria.R;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnMais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMais = findViewById(R.id.btnMais);
       btnMais.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent myIntent = new Intent(getApplicationContext(), Tela2.class);
               startActivity(myIntent);
               finish();
           }
       });



    }
}