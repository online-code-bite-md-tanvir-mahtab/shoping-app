package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytask.adapter.CustomAdapter;
import com.example.mytask.network.ProductClientInstance;
import com.example.mytask.util.ProductEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDataService service = ProductClientInstance.getRetrofit().create(GetDataService.class);
        Call<List<ProductEntity>> call =  service.getAllProducts();
        call.enqueue(new Callback<List<ProductEntity>>() {
            @Override
            public void onResponse(Call<List<ProductEntity>> call, Response<List<ProductEntity>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductEntity>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void generateDataList(List<ProductEntity> productList){
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new CustomAdapter(this,productList);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}