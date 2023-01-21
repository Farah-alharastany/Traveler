package com.example.project12;

import androidx.appcompat.app.AppCompatActivity;

public class Packages_data extends AppCompatActivity {
    private String pkg_name, pkg_price, pkg_country,pkg_dur;
    public Packages_data(String pkg_name, String pkg_price, String pkg_country, String pkg_dur){
        this.pkg_name=pkg_name;
        this.pkg_price=pkg_price;
        this.pkg_country=pkg_country;
        this.pkg_dur=pkg_dur;
    }
    //package variables getterss.
    public String getPkg_name(){
        return pkg_name;
    }
    public String getPkg_price(){
        return pkg_price;
    }
    public String getPkg_country(){return pkg_country;}
    public String getPkg_dur(){return pkg_dur;}
}
