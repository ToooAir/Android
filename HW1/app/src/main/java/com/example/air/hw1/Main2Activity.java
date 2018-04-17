package com.example.air.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        String out = bundle.getString("GOGO");
        TextView output = (TextView)findViewById(R.id.textView);
        output.setText("B10509011:"+out);
    }
}
