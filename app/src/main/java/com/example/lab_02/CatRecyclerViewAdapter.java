package com.example.lab_02;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CatRecyclerViewAdapter extends RecyclerView.Adapter<CatRecyclerViewAdapter.CatViewHolder> {
    private List<CatCard> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public CatRecyclerViewAdapter(Context context, List<CatCard> data) {
        this.data = data;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CatRecyclerViewAdapter.CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = layoutInflater.inflate(R.layout.cat_card_layout,parent,false);
        return new CatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CatViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CatViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        CatViewHolder(View itemView) {
            super(itemView);

            // Gets the text and image view
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);


        }

        void bind(final CatCard cat) {
            textView.setText(cat.catName);
            imageView.setImageResource(cat.resID);
        }
    }

}

