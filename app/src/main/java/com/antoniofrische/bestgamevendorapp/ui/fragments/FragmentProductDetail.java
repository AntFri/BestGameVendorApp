package com.antoniofrische.bestgamevendorapp.ui.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.antoniofrische.bestgamevendorapp.R;
import com.antoniofrische.bestgamevendorapp.interfa.IAPIService;
import com.antoniofrische.bestgamevendorapp.interfa.IOnAttachListener;
import com.antoniofrische.bestgamevendorapp.models.PlataformasEntity;
import com.antoniofrische.bestgamevendorapp.models.ProductosEntity;
import com.antoniofrische.bestgamevendorapp.rest.RestClient;
import com.antoniofrische.bestgamevendorapp.ui.adapters.AdapterProductDetail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProductDetail extends Fragment {
    private ListView lvPlatform;
    private AdapterProductDetail adapterPlatform;
    private ProductosEntity prod;

    private TextView tvNameProductD;
    private TextView tvProdDMinAge;
    private TextView tvProdDReleaseD;
    private TextView tvProdDReleaseP;
    private TextView tvProdDPublisherName;
    private TextView tvProdDGenreName;
    private TextView tvProdDRegionName;
    private TextView tvProdDDescription;
    private ImageView ivProdDIMG;

    private final IAPIService apiService = RestClient.getInstance();

    public FragmentProductDetail(){
        super(R.layout.fragment_product_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<PlataformasEntity> plaformList = new ArrayList<>();

        tvNameProductD = view.findViewById(R.id.tvNameProductD);
        tvProdDMinAge = view.findViewById(R.id.tvProdDMinAge);
        ivProdDIMG = view.findViewById(R.id.ivProdDIMG);
        tvProdDReleaseD = view.findViewById(R.id.tvProdDReleaseDate);
        tvProdDReleaseP= view.findViewById(R.id.tvProdDReleasePrice);
        tvProdDPublisherName= view.findViewById(R.id.tvProdDPublisherName);
        tvProdDGenreName= view.findViewById(R.id.tvProdDGenreName);
        tvProdDRegionName= view.findViewById(R.id.tvProdDRegionName);
        tvProdDDescription = view.findViewById(R.id.tvProdDDescription);
        setData();

        if(prod == null){
            apiService.getProductsID(prod.getIdProductos()).enqueue(new Callback<ProductosEntity>() {
                @Override
                public void onResponse(Call<ProductosEntity> call, Response<ProductosEntity> response) {
                    if(response.isSuccessful()) {
                        assert response.body() != null;
                        prod= response.body();
                        plaformList.addAll(prod.getPlatformList());
                        adapterPlatform.setPlatform(plaformList);
                        adapterPlatform.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<ProductosEntity> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("Product Error",t.getMessage(),t);
                }
            });
        } else {
            plaformList.addAll(prod.getPlatformList());
        }


        adapterPlatform = new AdapterProductDetail(plaformList,getContext());
        lvPlatform = view.findViewById(R.id.lvProdDPlatform);
        lvPlatform.setAdapter(adapterPlatform);
    }

    private void setData(){
        tvNameProductD.setText(prod.getNombre());
        tvProdDMinAge.setText(String.valueOf(prod.getEdadMinima()));
        tvProdDReleaseD.setText(prod.getFechaSalida());
        tvProdDReleaseP.setText(String.valueOf(prod.getPrecioSalida()));
        tvProdDPublisherName.setText(prod.getPublisher().getNombre());
        tvProdDGenreName.setText(prod.getGenre().getNombre());
        tvProdDRegionName.setText(prod.getRegion().getNombre());
        tvProdDDescription.setText(prod.getDescripcion());
        ivProdDIMG.setImageDrawable(loadImageFromWeb(prod.getProductimage().getImgURL()));
    }

    private Drawable loadImageFromWeb(String url){
        final Drawable[] drawable = {null};
        Thread imgThread = new Thread(() -> {
            String baseURL = "http://"+ RestClient.IP_CONNECTION +":"+RestClient.PORT;
            String imgURL = baseURL +  url;
            System.out.println(imgURL);
            try {
                InputStream is = (InputStream) new URL(imgURL).getContent();
                drawable[0] =Drawable.createFromStream(is,"img");
            } catch (IOException e) {
                Log.e("FragmentProductDeteil", e.getMessage());
            }
        });
        imgThread.start();
        try {
            imgThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return drawable[0];
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        prod = attachListener.getProduct();
        System.out.println(prod.getNombre());
    }
}
