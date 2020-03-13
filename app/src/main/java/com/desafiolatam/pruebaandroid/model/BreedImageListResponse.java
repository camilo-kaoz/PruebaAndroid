package com.desafiolatam.pruebaandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedImageListResponse {

    @SerializedName("message")
    private List<String> imageURL;

    public List<String> getImageURL() {
        return imageURL;
    }

    public void setImageURL(List<String> imageURL) {
        this.imageURL = imageURL;
    }

}

