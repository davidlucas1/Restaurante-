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
        holder.description.setText(String.valueOf(mistura.getDescription()));

        holder.mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clic","esta funcionando " + mistura.getName());
                int temp;
                switch (mistura.getName()){
                    case "Macaxeira Frita":
                        temp = mistura.getQuantidade();
                        if (mistura.getQuantidade()>=0){
                            temp++;
                            mistura.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Vatapá":
                        temp = mistura.getQuantidade();
                        if (temp>=0){
                            temp++;
                            mistura.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Carangueijo":
                        temp = mistura.getQuantidade();
                        if (temp>=0){
                            temp++;
                            mistura.setQuantidade(temp);
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
                Log.i("Clic","esta funcionando " + mistura.getName());
                int temp;
                switch (mistura.getName()){
                    case "Macaxeira Frita":
                        temp = mistura.getQuantidade();
                        if (temp>0){
                            temp--;
                            mistura.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Vatapá":
                        temp = mistura.getQuantidade();
                        if (temp>0){
                            temp--;
                            mistura.setQuantidade(temp);
                            holder.valor.setText(String.valueOf(temp));
                            Log.i("quantidade", String.valueOf(temp));
                        }
                        break;
                    case "Carangueijo":
                        temp = mistura.getQuantidade();
                        if (temp>0){
                            temp--;
                            mistura.setQuantidade(temp);
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
        return acompanhamento.size();
    }

    public class AcompanhamentoViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, description,mais,menos,valor;
        ImageView image;

        public AcompanhamentoViewHolder(@NonNull View itemView) {
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
