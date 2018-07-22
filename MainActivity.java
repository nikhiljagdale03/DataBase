package com.example.sith3.textinputlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;

    private EditText mFullName, mEmail, mUserName, mPass, mConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Button signup = findViewById(R.id.btn1);
        mFullName = findViewById(R.id.full_name);
        mEmail = findViewById(R.id.EmailId);
        mUserName = findViewById(R.id.user_name);
        mPass = findViewById(R.id.pass);
        mConfirmPass = findViewById(R.id.confirm_pass);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullName = mFullName.getText().toString();
                final String eMail = mEmail.getText().toString();
                final String userName = mUserName.getText().toString();
                final String passWord = mPass.getText().toString();
                if(mPass.getText().equals(mConfirmPass.getText().toString())) {
                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                    UserModel model = new UserModel();
                    model.setName(mFullName.getText().toString());
                    model.setEmail(mEmail.getText().toString());
                    model.setUsername(mUserName.getText().toString());
                    model.setPassword(mPass.getText().toString());
                    boolean status = databaseHelper.insertUser(model);
                    if (status) {
                        if (!fullName.isEmpty() && !eMail.isEmpty() && !userName.isEmpty() && !passWord.isEmpty()) {
                            Intent intent = new Intent(context, ProductActivity.class);
                            intent.putExtra(AppConstant.USER_FULL_NAME, fullName);
                            intent.putExtra(AppConstant.USER_EMAIL, eMail);
                            intent.putExtra(AppConstant.USER_USERNAME, userName);
                            intent.putExtra(AppConstant.USER_PASSWORD, passWord);
                            startActivity(intent);
                        }

                    } else {
                        Toast.makeText(context, "fill up the details", Toast.LENGTH_LONG);
                    }
                }
            }
        });
    }
}
