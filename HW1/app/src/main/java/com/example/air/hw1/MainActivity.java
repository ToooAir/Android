package com.example.air.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.et1);
        Button but = (Button)findViewById(R.id.but);

        toast = Toast.makeText(this,"沒有輸入安捏母湯",Toast.LENGTH_LONG);
        View toastv = toast.getView();

        LinearLayout lineL = (LinearLayout)getLayoutInflater().inflate(R.layout.toast,null);
        lineL.addView(toastv);

        toast.setView(lineL);

        but.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if("".equals(input.getText().toString()))
                    toast.show();
                else{
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("GOGO",input.getText().toString());
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });
    }
}
