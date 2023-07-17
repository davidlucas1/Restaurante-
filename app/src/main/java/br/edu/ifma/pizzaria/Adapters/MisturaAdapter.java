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

import br.edu.ifma.pizzaria.Models.Bebidas;
import br.edu.ifma.pizzaria.Models.Mistura;
import br.edu.ifma.pizzaria.R;

public class MisturaAdapter extends RecyclerView.Adapter<MisturaAdapter.AcompanhamentoViewHolder> {

    private Context context;

    private List<Mistura> acompanhamento = new ArrayList<>();

    public MisturaAdapter(List<Mistura> acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    @NonNull
    @Override
    public MisturaAdapter.AcompanhamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_card
                        , parent
                        , false);
        return new MisturaAdapter.AcompanhamentoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AcompanhamentoViewHolder holder, int position) {
        Mistura mistura = acompanhamento.get(position);
        holder.image.setImageResource(mistura.getImage());
        holder.name.setText(mistura.getName());
        holder.price.setText(String.valueOf(mistura.getPrice()));

    }

    @Override
    public int getItemCount() {
        return acompanhamento.size();
    }

    public class AcompanhamentoViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;

        public AcompanhamentoViewHolder(@NonNull View itemView) {
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
