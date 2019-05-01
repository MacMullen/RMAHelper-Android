package com.macmullen.rmahelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<ProductCardView> mProductList;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mModelLine;
        public TextView mBrandLine;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iconView);
            mModelLine = itemView.findViewById(R.id.modelText);
            mBrandLine = itemView.findViewById(R.id.brandText);
        }
    }

    public RecyclerViewAdapter(List<ProductCardView> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view, parent, false);
        RecyclerViewHolder evh = new RecyclerViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        ProductCardView currentItem = mProductList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mModelLine.setText(currentItem.getModel());
        holder.mBrandLine.setText(currentItem.getBrand());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }


}
