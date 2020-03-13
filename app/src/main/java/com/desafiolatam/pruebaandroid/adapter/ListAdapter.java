package com.desafiolatam.pruebaandroid.adapter;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.desafiolatam.pruebaandroid.model.BreedListResponseApi;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<BreedListResponseApi> BreedList = new ArrayList<>();
    private Context mContext;
    private View.OnClickListener listener;

    public ListAdapter(List<BreedListResponseApi> breedList, Context mContext, View.OnClickListener listener) {
        BreedList = breedList;
        this.mContext = mContext;
        this.listener = listener;
    }


}
