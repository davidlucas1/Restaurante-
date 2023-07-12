package br.edu.ifma.pizzaria.Activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ifma.pizzaria.R;

public class AdapterOrderRecycleView extends RecyclerView.Adapter<AdapterOrderRecycleView.MyViewHolder> {
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaper_listaorderrecycleview, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nomePrato.setText("Galinha caipira");
        holder.quantidadePrato.setText("0");
        holder.valorPrato.setText("R$ 25,00");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomePrato;
        TextView quantidadePrato;
        TextView valorPrato;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomePrato = itemView.findViewById(R.id.textView);
            quantidadePrato = itemView.findViewById(R.id.textView2);
            valorPrato = itemView.findViewById(R.id.textView3);

        }
    }
}
