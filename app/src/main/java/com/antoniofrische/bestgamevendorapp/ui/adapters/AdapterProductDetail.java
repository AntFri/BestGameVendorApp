package com.antoniofrische.bestgamevendorapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.antoniofrische.bestgamevendorapp.R;
import com.antoniofrische.bestgamevendorapp.models.PlataformasEntity;

import java.util.List;

public class AdapterProductDetail extends BaseAdapter {
    private List<PlataformasEntity> platform;
    LayoutInflater inflater;

    public AdapterProductDetail(List<PlataformasEntity> platform, Context context) {
        this.platform = platform;
        inflater = (LayoutInflater.from(context));
    }

    public void setPlatform(List<PlataformasEntity> platform) {
        this.platform = platform;
    }

    @Override
    public int getCount() {
        return platform.size();
    }

    @Override
    public Object getItem(int position) {
        return platform.get(position);
    }

    @Override
    public long getItemId(int position) {
        return platform.get(position).getIdPlataformas();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_product_detail, null);
        TextView tvNamePlatform = (TextView) convertView.findViewById(R.id.tvNamePlatformDL);

        tvNamePlatform.setText(platform.get(position).getNombre());

        return convertView;
    }
}
