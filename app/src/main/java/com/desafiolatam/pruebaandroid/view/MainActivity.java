package com.desafiolatam.pruebaandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.desafiolatam.pruebaandroid.R;
import com.desafiolatam.pruebaandroid.adapter.ListAdapter;
import com.desafiolatam.pruebaandroid.api.ApiDog;
import com.desafiolatam.pruebaandroid.api.RetrofitClient;
import com.desafiolatam.pruebaandroid.model.BreedImageListResponse;
import com.desafiolatam.pruebaandroid.model.BreedListResponseApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    private String dog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ApiDog service = RetrofitClient.getRetrofit().create(ApiDog.class);
        Call<BreedListResponseApi> call = service.getBreedList();
        call.enqueue(new Callback<BreedListResponseApi>() {

            @Override
            public void onResponse(Call<BreedListResponseApi> call, Response<BreedListResponseApi> response) {
                List<String> perritos = null;
                if (response.body() != null) {
                    perritos = response.body().getBreedList();
                    dog1 = perritos.get(0);
                    Log.e("PERRITOS", String.valueOf(perritos));


                } else {
                    Log.e("PERRITOS", "ES NULO");
                }

                if (!dog1.equals("")) {
                    whoLetTheDogOut();

                }
            }

            @Override
            public void onFailure(Call<BreedListResponseApi> call, Throwable t) {
                Toast.makeText(MainActivity.this, "FALLO, intentelo otra vez", Toast.LENGTH_SHORT).show();
                Log.e("PERRITOS", String.valueOf(t));


            }
        });


    }

    private void whoLetTheDogOut() {
        ApiDog service = RetrofitClient.getRetrofit().create(ApiDog.class);
        Call<BreedImageListResponse> callImage = service.getBreedImageList(dog1);
        callImage.enqueue(new Callback<BreedImageListResponse>() {
            @Override
            public void onResponse(Call<BreedImageListResponse> call, Response<BreedImageListResponse> response) {
                List<String> imagesURL = response.body().getImageURL();
                Log.e("IMAGESDOGS", String.valueOf(imagesURL));

            }

            @Override
            public void onFailure(Call<BreedImageListResponse> call, Throwable t) {
                Log.e("FALLO", String.valueOf(t));
            }
        });
    }
}
