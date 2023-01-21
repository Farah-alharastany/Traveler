package com.example.project12;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class Packages_viewholder extends RecyclerView.ViewHolder {
        //Textviews.
        private TextView txt_pkgName, txt_pkgPrice, txt_pkgCountry, txt_pkgDur;

        //Constructor that links textviews in row file with the variables.
        public Packages_viewholder(View itemView){
            super(itemView);
            txt_pkgName=itemView.findViewById(R.id.txt_pkg_name);
            txt_pkgPrice=itemView.findViewById(R.id.txt_pkg_price);
            txt_pkgCountry=itemView.findViewById(R.id.txt_pkg_country);
            txt_pkgDur=itemView.findViewById(R.id.txt_pkg_dur);
        }

        //take the course name as an argument and change the text in the textview.
        public void setTxt_pkgName(String pkgName){
            this.txt_pkgName.setText(pkgName);
        }
        public void setTxt_pkgPrice(String pkgPrice){
            this.txt_pkgPrice.setText(pkgPrice);
        }
        public void setTxt_pkgCountry(String pkgCountry){this.txt_pkgCountry.setText(pkgCountry);}
        public void setTxt_pkgDur(String pkgDur){
            this.txt_pkgDur.setText(pkgDur);
        }
    }
