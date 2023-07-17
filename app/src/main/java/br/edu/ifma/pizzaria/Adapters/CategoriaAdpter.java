package br.edu.ifma.pizzaria.Adapters;

import android.opengl.GLUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import br.edu.ifma.pizzaria.Models.Categoria;
import br.edu.ifma.pizzaria.R;

public class CategoriaAdpter extends RecyclerView.Adapter<CategoriaAdpter.ViewHolder> {

    ArrayList<Categoria> categoria;

    public CategoriaAdpter(ArrayList<Categoria> categoria) {
        this.categoria = categoria;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_categoria, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdpter.ViewHolder holder, int position) {
        holder.categoriaNome.setText(categoria.get(position).getTitle());
        String imageUrl;
        switch (position){
            case 0:{
                imageUrl  = "cat_1";
                break;
            }
            case 1:{
                imageUrl  = "cat_2";
                break;
            }
            case 2:{
                imageUrl  = "cat_4";
                break;
            }
            case 3:{
                imageUrl  = "cat_3";
                break;
            }
            case 4:{
                imageUrl  = "cat_5";
                break;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        int drawableId = holder.itemView.getContext().getResources()
                .getIdentifier(imageUrl,"drawable",holder.itemView.getContext()
                        .getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableId).into(holder.categoriaImage);

    }

    @Override
    public int getItemCount() {
        return categoria.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoriaNome;
        ImageView categoriaImage;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoriaNome = itemView.findViewById(R.id.categoriaNome);
            categoriaImage = itemView.findViewById(R.id.categoriaImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
