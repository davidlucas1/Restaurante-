package br.edu.ifma.pizzaria.Adapters;

import android.content.Context;
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

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView image;

        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView
                    .findViewById(R.id.name);
            price = itemView
                    .findViewById(R.id.price);
            image = itemView
                    .findViewById(R.id.image);
        }
    }

}
