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

import br.edu.ifma.pizzaria.Models.Bebidas;
import br.edu.ifma.pizzaria.Models.Extrato;
import br.edu.ifma.pizzaria.R;

public class ComandaAdapter extends RecyclerView.Adapter<ComandaAdapter.ComandaViewHolder> {
    private Context context;

    private List<Extrato> extratoes = new ArrayList<>();

    public ComandaAdapter(List<Extrato> extrato) {
        this.extratoes = extrato;
    }


    @NonNull
    @Override
    public ComandaAdapter.ComandaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itens_comanda
                        , parent
                        , false);
        return new ComandaAdapter.ComandaViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ComandaAdapter.ComandaViewHolder holder, int position) {
        Extrato extrato = extratoes.get(position);
        holder.name.setText(extrato.getNome());
        holder.quantidade.setText(String.valueOf(extrato.getQuantidade()));
        holder.price.setText("R$: " + String.valueOf(extrato.getTotal()));
    }

    @Override
    public int getItemCount() {
        return extratoes.size();
    }

    public class ComandaViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, quantidade;

        public ComandaViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView
                    .findViewById(R.id.extratoNome);
            price = itemView
                    .findViewById(R.id.extratoValor);
            quantidade = itemView.findViewById(R.id.extratoQtd);
        }
    }

}

