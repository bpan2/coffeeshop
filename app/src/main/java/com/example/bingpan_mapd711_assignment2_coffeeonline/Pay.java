package com.example.bingpan_mapd711_assignment2_coffeeonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities.CustomerOrder;

public class Pay extends AppCompatActivity {
    private CustomerOrder newOrder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        //Retrieve Serializable object customerOrder from Order Activity
        newOrder =  (CustomerOrder) getIntent().getSerializableExtra("customerOrder");



    }
}