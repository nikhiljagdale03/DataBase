package com.example.sith3.textinputlayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Context context;

    private EditText mFullName,mEmail,mUserName,mPass,mConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Button signup = findViewById(R.id.btn1);
        mFullName = findViewById(R.id.full_name);
        mEmail= findViewById(R.id.EmailId);
        mUserName=findViewById(R.id.user_name);
        mPass=findViewById(R.id.pass);
        mConfirmPass=findViewById(R.id.confirm_pass);

        signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String fullName= mFullName.getText().toString();
                        if(!fullName.isEmpty()) {
                            Intent intent = new Intent(context, ProductActivity.class);
                            intent.putExtra(AppConstant.USER_FULL_NAME, fullName);
                            startActivity(intent);
                        }
                if(mPass.getText().equals(mConfirmPass.getText().toString())) {
                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                    UserModel model = new UserModel();
                    model.setName(mFullName.getText().toString());
                    model.setEmail(mEmail.getText().toString());
                    model.setUsername(mUserName.getText().toString());
                    model.setPassword(mPass.getText().toString());
                    databaseHelper.insertUser(model);
                }

            }
        });


    }
}
