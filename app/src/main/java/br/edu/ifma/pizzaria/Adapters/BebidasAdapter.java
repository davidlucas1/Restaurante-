package br.edu.ifma.pizzaria.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Models.Bebidas;
import br.edu.ifma.pizzaria.Models.PratoPrincipal;
import br.edu.ifma.pizzaria.R;

public class BebidasAdapter extends RecyclerView.Adapter<BebidasAdapter.DrinksViewHolder> {
    private Context context;

    private List<Bebidas> drinks = new ArrayList<>();

    public BebidasAdapter(List<Bebidas> drinks) {
        this.drinks = drinks;
    }


    @NonNull
    @Override
    public BebidasAdapter.DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_card
                        , parent
                        , false);
        return new BebidasAdapter.DrinksViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidasAdapter.DrinksViewHolder holder, int position) {
        Bebidas drink = drinks.get(position);
        holder.image.setImageResource(drink.getImage());
        holder.name.setText(drink.getName());
        holder.price.setText(String.valueOf(drink.getPrice()));
        holder.description.setText(String.valueOf(drink.getDescription()));

        holder.mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clic","esta funcionando " + drink.getName());
                int temp;
                switch (drink.getName()){
                    case "Cachaça Dona Banana":
                        temp = drink.getQuantidade();
                        if (drink.getQuantidade()>=0){
                            temp++;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Guaraná Jesus":
                        temp = drink.getQuantidade();
                        if (temp>=0){
                            temp++;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Cajuina":
                        temp = drink.getQuantidade();
                        if (temp>=0){
                            temp++;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                }
            }
        });

        holder.menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clic","esta funcionando " + drink.getName());
                int temp;
                switch (drink.getName()){
                    case "Cachaça Dona Banana":
                        temp = drink.getQuantidade();
                        if (temp>0){
                            temp--;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Guaraná Jesus":
                        temp = drink.getQuantidade();
                        if (temp>0){
                            temp--;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Cajuina":
                        temp = drink.getQuantidade();
                        if (temp>0){
                            temp--;
                            drink.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, description, mais, menos, valor;
        ImageView image;

        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView
                    .findViewById(R.id.name);
            price = itemView
                    .findViewById(R.id.price);
            image = itemView
                    .findViewById(R.id.image);
            description = itemView
                    .findViewById(R.id.description);
            mais = itemView.findViewById(R.id.mais);
            menos = itemView.findViewById(R.id.menos);
            valor = itemView.findViewById(R.id.quantidade);
        }
    }

}
