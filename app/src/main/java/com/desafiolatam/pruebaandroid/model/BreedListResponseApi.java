package com.desafiolatam.pruebaandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedListResponseApi {

    @SerializedName("message")
    private List<String> breedList;


    public List<String> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<String> breedList) {
        this.breedList = breedList;
    }


}
