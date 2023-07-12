package br.edu.ifma.pizzaria.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifma.pizzaria.Models.PratoPrincipal;
import br.edu.ifma.pizzaria.R;

public class PrincipalAdapter extends RecyclerView.Adapter<PrincipalAdapter.PratoViewHolder> {
    private Context context;
    private List<PratoPrincipal> pratos = new ArrayList<>();

    public PrincipalAdapter(List<PratoPrincipal> pratos) {
        this.pratos = pratos;
    }

    @NonNull
    @Override
    public PrincipalAdapter.PratoViewHolder onCreateViewHolder(@NonNull ViewGroup parent
            , int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_card
                        , parent
                        , false);
        return new PratoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PratoViewHolder holder
            , int position) {
        PratoPrincipal prato = pratos.get(position);
        holder.image.setImageResource(prato.getImage());
        holder.name.setText(prato.getName());
        holder.price.setText(String.valueOf(prato.getPrice()));

    }

    @Override
    public int getItemCount() {
        return pratos.size();
    }


    public class PratoViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;

        public PratoViewHolder(@NonNull View itemView) {
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
