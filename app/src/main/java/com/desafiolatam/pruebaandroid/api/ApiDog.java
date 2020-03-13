package com.desafiolatam.pruebaandroid.api;

import com.desafiolatam.pruebaandroid.model.BreedImageListResponse;
import com.desafiolatam.pruebaandroid.model.BreedListResponseApi;
import com.desafiolatam.pruebaandroid.view.BreedImageListFragment;
import com.desafiolatam.pruebaandroid.view.BreedListFragment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDog {
    @GET("api/breeds/list")
    Call<BreedListResponseApi> getBreedList();

    @GET("api/breed/{breed}/images/")
    Call<BreedImageListResponse> getBreedImageList(@Path("breed")String breed);
}
