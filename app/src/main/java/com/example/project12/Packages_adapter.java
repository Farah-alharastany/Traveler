package com.example.project12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Packages_adapter extends RecyclerView.Adapter<Packages_viewholder> {
    private Context context;
    private ArrayList<Packages_data> pkgList;

    //constructor
    public Packages_adapter(Context context, ArrayList<Packages_data> pkgList){
        this.context=context;
        this.pkgList=pkgList;
    }

    @NonNull
    @Override
    //creation of a  new viewholder.
    public Packages_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw, parent, false);
        return new Packages_viewholder(view);
    }

    @Override
    //use setters from the holder object.
    public void onBindViewHolder(@NonNull Packages_viewholder holder, int position) {
        Packages_data pkg=pkgList.get(position);
        holder.setTxt_pkgName(pkg.getPkg_name());
        holder.setTxt_pkgPrice(pkg.getPkg_price());
        holder.setTxt_pkgCountry(pkg.getPkg_country());
        holder.setTxt_pkgDur(pkg.getPkg_dur());
    }

    @Override
    //get the size of the arraylist.
    public int getItemCount() {
        return pkgList.size();
    }
}
