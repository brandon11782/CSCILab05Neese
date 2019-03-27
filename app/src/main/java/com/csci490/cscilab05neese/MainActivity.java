package com.csci490.cscilab05neese;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText pass;
    EditText email;
    Button save;
    String Name;
    String Pass;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        email = (EditText)findViewById(R.id.editText3);

        save = (Button)findViewById(R.id.button);

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        name.setText(sharedPreferences.getString(Name, ""));
        name.setText(sharedPreferences.getString(Pass, ""));
        name.setText(sharedPreferences.getString(Email, ""));

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String n = name.getText().toString();
                String p = pass.getText().toString();
                String m = email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, n);
                editor.putString(Pass, p);
                editor.putString(Email, m);
                editor.commit();

            }
        });

    }
}
