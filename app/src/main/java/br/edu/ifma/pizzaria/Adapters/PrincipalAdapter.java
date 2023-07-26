package br.edu.ifma.pizzaria.Adapters;

import android.content.Context;
import android.util.Log;
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
        holder.description.setText(String.valueOf(prato.getDescription()));

        holder.mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clic", "esta funcionando " + prato.getName());
                int temp;
                switch (prato.getName()) {
                    case "Carne de Sol":
                        temp = prato.getQuantidade();
                        if (prato.getQuantidade() >= 0) {
                            temp++;
                            prato.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Moqueca":
                        temp = prato.getQuantidade();
                        if (temp >= 0) {
                            temp++;
                            prato.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Baião":
                        temp = prato.getQuantidade();
                        if (temp >= 0) {
                            temp++;
                            prato.setQuantidade(temp);
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
                Log.i("Clic", "esta funcionando " + prato.getName());
                int temp;
                switch (prato.getName()) {
                    case "Carne de Sol":
                        temp = prato.getQuantidade();
                        if (temp > 0) {
                            temp--;
                            prato.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Moqueca":
                        temp = prato.getQuantidade();
                        if (temp > 0) {
                            temp--;
                            prato.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Baião":
                        temp = prato.getQuantidade();
                        if (temp > 0) {
                            temp--;
                            prato.setQuantidade(temp);
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
        return pratos.size();
    }


    public class PratoViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, description, mais, menos, valor;
        ImageView image;

        public PratoViewHolder(@NonNull View itemView) {
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
