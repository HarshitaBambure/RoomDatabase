package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        txtShow=findViewById(R.id.txt_show);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        viewModel.getAllEntries().observe(this, new Observer<List<EntryDetails>>() {
            @Override
            public void onChanged(List<EntryDetails> entryDetails) {

                if(entryDetails.size()>0){
                    txtShow.setText(entryDetails.size()+entryDetails.get(0).getName());
                }
            }
        });
    }
    private void insertData()
    {
        EntryDetails model=new EntryDetails("rv","rv@db.com","7485965478","India","xdgd");
        viewModel.insertData(model);
        Toast.makeText(this,"data insert",Toast.LENGTH_LONG).show();
    }

}