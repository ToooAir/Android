package com.air.hw2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> datalist = new ArrayList<>();
    Adapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 1; i<101;i++){
            Item item = new Item();
            item.setText(i+"");
            datalist.add(item);
        }
        adapter = new Adapter(datalist);
        RecyclerView list = (RecyclerView)findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        ArrayList<Integer> select = new ArrayList<>();
        for(int i=0; i<adapter.mData.size();i++){
            if(adapter.mData.get(i).isCheck() == true)
                select.add(i+1);
        }
        String string = new String();
        string = select.toString();
        string = string.replace("[","");
        string = string.replace("]","");
        Toast toast = Toast.makeText(this,"你選擇了 "+string,Toast.LENGTH_LONG);
        toast.show();
        return true;
    }


}
