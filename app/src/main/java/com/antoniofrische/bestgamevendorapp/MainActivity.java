package com.antoniofrische.bestgamevendorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import com.antoniofrische.bestgamevendorapp.interfa.IAPIService;
import com.antoniofrische.bestgamevendorapp.interfa.IOnAttachListener;
import com.antoniofrische.bestgamevendorapp.interfa.IOnClickListener;
import com.antoniofrische.bestgamevendorapp.models.ProductosEntity;
import com.antoniofrische.bestgamevendorapp.rest.RestClient;
import com.antoniofrische.bestgamevendorapp.ui.fragments.FragmentProductDetail;
import com.antoniofrische.bestgamevendorapp.ui.fragments.FragmentProductList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IOnClickListener, IOnAttachListener {

    private ProductosEntity selectedProd;
    private List<ProductosEntity> productList;

    private final IAPIService apiService = RestClient.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");
        productList = new ArrayList<>();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        ImageButton imgBtn = findViewById(R.id.ibHome);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .replace(R.id.fcvMain, FragmentProductList.class, null)
                        .commit();
            }
        });

        loadData();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch(item.getItemId()) {
            case R.id.mUserPref:
                Toast.makeText(getApplicationContext(),"User Option",Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }


    private void loadData(){
        if(productList == null){
            apiService.getProducts().enqueue(new Callback<List<ProductosEntity>>() {
                @Override
                public void onResponse(@NonNull Call<List<ProductosEntity>> call, @NonNull Response<List<ProductosEntity>> response) {
                    if(response.isSuccessful()) {
                        assert response.body() != null;
                        productList.addAll(response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<ProductosEntity>> call, @NonNull Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Product Error",t.getMessage(),t);
                }
            });
        }
    }

    @Override
    public void onClickProd(int position) {
        System.out.println("listenen!");
        if(productList.size() < 1){
            System.out.println("Null Listen!");
            apiService.getProducts().enqueue(new Callback<List<ProductosEntity>>() {
                @Override
                public void onResponse(@NonNull Call<List<ProductosEntity>> call, @NonNull Response<List<ProductosEntity>> response) {
                    if(response.isSuccessful()) {
                        assert response.body() != null;
                        productList.addAll(response.body());
                        selectedProd = productList.get(position);
                        FragmentManager manager = getSupportFragmentManager();
                        manager.beginTransaction()
                                .setReorderingAllowed(true)
                                .addToBackStack(null)
                                .replace(R.id.fcvMain, FragmentProductDetail.class, null)
                                .commit();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<ProductosEntity>> call, @NonNull Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Product Error",t.getMessage(),t);
                }
            });
        } else {
            System.out.println(position + productList.size());
            selectedProd = productList.get(position);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.fcvMain, FragmentProductDetail.class, null)
                    .commit();
        }
    }

    @Override
    public void onClickCategoria(int position) {
        Toast.makeText(getApplicationContext(),"Click cat",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickAdminB(int recievID) {
        Toast.makeText(getApplicationContext(),"Click admin",Toast.LENGTH_LONG).show();
    }

    @Override
    public ProductosEntity getProduct() {
        if(productList == null){
            loadData();
        }
        if(selectedProd == null){
            selectedProd = productList.get(0);
        }
        return selectedProd;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setTitle("");
    }
}