package com.example.mytask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask.R;
import com.example.mytask.util.ProductEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<ProductEntity> dataList;
    private Context context;

    public CustomAdapter(Context context, List<ProductEntity> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        ProductEntity productEntity = dataList.get(position);
        holder.mTitle.setText(productEntity.getpTitle());
        holder.mCategory.setText(productEntity.getpCategory());
        holder.mCurrentPrice.setText(productEntity.getpPrice());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mCurrentPrice;
        private TextView mCategory;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.product_title);
            mCurrentPrice =(TextView) itemView.findViewById(R.id.real_price);
            mCategory = (TextView) itemView.findViewById(R.id.product_category);
        }
    }
}
