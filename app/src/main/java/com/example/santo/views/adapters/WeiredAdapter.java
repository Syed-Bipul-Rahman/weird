package com.example.santo.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.santo.databinding.CardItemsBinding;
import com.example.santo.services.models.WeiredData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeiredAdapter extends RecyclerView.Adapter<WeiredAdapter.WeiredViewHolder> {
    Context context;
    List<WeiredData> weiredDataList;

    public WeiredAdapter(Context context, List<WeiredData> weiredDataList) {
        this.context = context;
        this.weiredDataList = weiredDataList;
    }

    @NonNull
    @Override
    public WeiredAdapter.WeiredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardItemsBinding cardItemsBinding = CardItemsBinding.inflate(layoutInflater, parent, false);
        return new WeiredViewHolder(cardItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WeiredAdapter.WeiredViewHolder holder, int position) {

        String imageUrl=weiredDataList.get(position).getImageUrl();
        //set data to view
        //set image using picasso
        Picasso.get().load(imageUrl).into(holder.cardItemsBinding.weiredImage);
        //set name
        holder.cardItemsBinding.weiredName.setText(weiredDataList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return weiredDataList.size();
    }

    public class WeiredViewHolder extends RecyclerView.ViewHolder {
        CardItemsBinding cardItemsBinding;
        public WeiredViewHolder(CardItemsBinding cardItemsBinding) {
            super(cardItemsBinding.getRoot());
            this.cardItemsBinding=cardItemsBinding;
        }
    }
}
