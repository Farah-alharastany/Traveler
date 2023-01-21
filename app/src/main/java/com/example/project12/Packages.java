package com.example.project12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project12.Packages_adapter;
import com.example.project12.Packages_data;
import com.example.project12.R;

import java.util.ArrayList;

public class Packages extends AppCompatActivity {
    private ArrayList<Packages_data> pkgList;
    private RecyclerView rvPkg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.packages);
        init();
        generateDate();
        setData();
    }
    //create package arrayList, amd linking with the layout file.
    private void init() {
        pkgList = new ArrayList<>();
        rvPkg = findViewById(R.id.rv_pkg);
    }
    //adding packages details to our Araaylist (pkgList).
    private void generateDate(){
        pkgList.add(new Packages_data("Diamond Package", "30,000 SR", "Switzerland-Germany","20 Jan - 15 Feb"));
        pkgList.add(new Packages_data("Golden Package", "25,000 SR", "Boland-Armenia","21 Jan - 30 Jan"));
        pkgList.add(new Packages_data("Silver Package", "20,000 SR", "Germany-Bosnia","22 Jan - 2 Feb"));
        pkgList.add(new Packages_data("Bronze Package", "15,000 SR", "Netherlands-Armenia","25 Jan - 12 Feb"));
        pkgList.add(new Packages_data("Buisness Package", "10,000 SR", "Switzerland-Azerbaijan","25 Jan - 10 Feb"));
        pkgList.add(new Packages_data("Family Package", "7,000 SR", "Armeina-Boland","2 Feb - 8 Feb"));
        pkgList.add(new Packages_data("Economic Package", "3,000 SR", "Bosnia-Azerbaijan","20 Jan - 26 Jan"));
    }
    //set the layout manager and the adapter.
    private void setData(){
        rvPkg.setLayoutManager(new LinearLayoutManager(this));
        rvPkg.setAdapter(new Packages_adapter(this, pkgList));
    }
}