package com.example.sith3.textinputlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        tv1 = findViewById(R.id.textv1);
        tv2 = findViewById(R.id.textv2);
        tv3 = findViewById(R.id.textv3);
        tv4 = findViewById(R.id.textv4);
        /*Log.d("TAG"," InsideProductActivity" + intent.getStringExtra(AppConstant.USER_FULL_NAME));*/
        tv1.setText(intent.getStringExtra(AppConstant.USER_FULL_NAME));
        tv2.setText(intent.getStringExtra(AppConstant.USER_EMAIL));
        tv3.setText(intent.getStringExtra(AppConstant.USER_USERNAME));
        tv4.setText(intent.getStringExtra(AppConstant.USER_PASSWORD));

    }
}
