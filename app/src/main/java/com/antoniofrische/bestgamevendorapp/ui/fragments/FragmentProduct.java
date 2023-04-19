package com.antoniofrische.bestgamevendorapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.antoniofrische.bestgamevendorapp.R;
import com.antoniofrische.bestgamevendorapp.interfa.IAPIService;
import com.antoniofrische.bestgamevendorapp.interfa.IOnAttachListener;
import com.antoniofrische.bestgamevendorapp.interfa.IOnClickListener;
import com.antoniofrische.bestgamevendorapp.models.ProductosEntity;
import com.antoniofrische.bestgamevendorapp.rest.RestClient;
import com.antoniofrische.bestgamevendorapp.ui.adapters.AdapterProducts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProduct extends Fragment {

    private IOnClickListener clickListener;
    private List<ProductosEntity> productList;
    private AdapterProducts adapterProducts;
    private final IAPIService apiService = RestClient.getInstance();

    public FragmentProduct(){
        super(R.layout.fragment_products);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productList = new ArrayList<>();

        apiService.getProducts().enqueue(new Callback<List<ProductosEntity>>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductosEntity>> call, @NonNull Response<List<ProductosEntity>> response) {
                if(response.isSuccessful()) {
                    assert response.body() != null;
                    productList.addAll(response.body());
                    adapterProducts.setDataProd(productList);
                    adapterProducts.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductosEntity>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        adapterProducts = new AdapterProducts(productList, clickListener);
        RecyclerView recyclerView = view.findViewById(R.id.rcvProducts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (IOnClickListener) context;
    }
}
