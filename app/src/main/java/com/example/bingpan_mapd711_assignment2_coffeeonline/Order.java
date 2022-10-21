package com.example.bingpan_mapd711_assignment2_coffeeonline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities.CoffeeDrink;
import com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities.CustomerOrder;
import com.example.bingpan_mapd711_assignment2_coffeeonline.Fragments.FragmentToActivity;
import com.example.bingpan_mapd711_assignment2_coffeeonline.Fragments.SelectOneSize;
import com.example.bingpan_mapd711_assignment2_coffeeonline.Fragments.SelectOptions;

public class Order extends AppCompatActivity  implements View.OnClickListener, FragmentToActivity {
    private Button continueBtn;
    private Button americanoBtn;
    private Button cappuccinoBtn;
    private Button latteBtn;
    private Button macchiatoBtn;

    private CustomerOrder newOrder = null;
    private CoffeeDrink newCoffeeDrink = null;

    private static boolean coffeeTypeSelected = false;
    private static boolean coffeeSizeSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        newOrder = new CustomerOrder();
        newCoffeeDrink = new CoffeeDrink();

        americanoBtn = findViewById(R.id.americanoBtn);
        cappuccinoBtn = findViewById(R.id.cappuccinoBtn);
        latteBtn = findViewById(R.id.latteBtn);
        macchiatoBtn = findViewById(R.id.macchiatoBtn);

        americanoBtn.setOnClickListener(this);
        cappuccinoBtn.setOnClickListener(this);
        latteBtn.setOnClickListener(this);
        macchiatoBtn.setOnClickListener(this);


        //The Continue Btn is enabled and a CustomerOrder object is passed as a Serializable via intent to Pay Activity
        continueBtn = findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Pay.class);

                Log.d("size", "prior to Pay page, size: " + newCoffeeDrink.getSize());

                //pass the newOrder as a Serializable
                intent.putExtra("customerOrder", newOrder);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.americanoBtn:
                newCoffeeDrink.setName("Americano");
                coffeeTypeSelected = true;
                break;
            case R.id.cappuccinoBtn:
                newCoffeeDrink.setName("Cappuccino");
                coffeeTypeSelected = true;
                break;
            case R.id.latteBtn:
                newCoffeeDrink.setName("Latte");
                coffeeTypeSelected = true;
                break;
            case R.id.macchiatoBtn:
                newCoffeeDrink.setName("Macchiato");
                coffeeTypeSelected = true;
                break;
            default:
                Log.d("TAG", "No coffee type is selected");
                break;
        }

        if(coffeeTypeSelected == true){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, SelectOneSize.class, null)
                    .commit();
        }

        //Log.d("coffeeSizeSelected", "prior to fragement inflator coffeeSizeSelected: " + Order.coffeeSizeSelected);
        //if(Order.coffeeSizeSelected == true){
            /*getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, SelectOptions.class, null)
                    .commit();*/
        //}
    }

    @Override
    public void communicate(String comm) {
        Log.d("received", comm);
        newCoffeeDrink.setSize(comm);
        Order.coffeeSizeSelected = true;

        if(Order.coffeeSizeSelected == true){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, SelectOptions.class, null)
                    .commit();
        }
    }


}