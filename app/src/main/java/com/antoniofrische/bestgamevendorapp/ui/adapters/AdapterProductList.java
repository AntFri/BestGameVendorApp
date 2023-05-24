package com.antoniofrische.bestgamevendorapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antoniofrische.bestgamevendorapp.R;
import com.antoniofrische.bestgamevendorapp.interfa.IOnClickListener;
import com.antoniofrische.bestgamevendorapp.models.ProductosEntity;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterProductList extends RecyclerView.Adapter<AdapterProductList.ProductViewHolder> {
    private List<ProductosEntity> products;
    private final IOnClickListener listener;

    public AdapterProductList(List<ProductosEntity> products, IOnClickListener listener) {

        this.products = products;
        this.listener = listener;
    }

    public void setDataProd(List<ProductosEntity> prod){
        this.products = prod;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, parent, false);
        return new ProductViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        ProductosEntity prod = products.get(position);
        holder.bindProduct(prod);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvProdName;
        private final TextView tvProdMinAge;
        private final TextView tvProdGenreName;
        private final TextView tvProdPublisherName;

        private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        private final IOnClickListener listener;

        public ProductViewHolder(View itemView, IOnClickListener listener) {
            super(itemView);

            tvProdName = itemView.findViewById(R.id.tvProdLName);
            tvProdMinAge = itemView.findViewById(R.id.tvProdLMinAge);
            tvProdGenreName = itemView.findViewById(R.id.tvProdLGenre);
            tvProdPublisherName = itemView.findViewById(R.id.tvProdLPublisher);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindProduct(ProductosEntity prod) {

            tvProdName.setText(prod.getNombre());

            tvProdMinAge.setText(String.valueOf(prod.getEdadMinima()));

            tvProdGenreName.setText(prod.getGenre().getNombre());

            tvProdPublisherName.setText(prod.getPublisher().getNombre());
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onClickProd(getAdapterPosition());
            }
        }
    }
}