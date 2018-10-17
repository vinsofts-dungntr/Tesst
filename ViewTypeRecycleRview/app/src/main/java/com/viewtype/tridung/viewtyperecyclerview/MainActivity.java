package com.viewtype.tridung.viewtyperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.viewtype.tridung.viewtyperecyclerview.Model.ONE_TYPE;
import static com.viewtype.tridung.viewtyperecyclerview.Model.TWO_TYPE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    AdapterModel adapterModel;
    List<Model> modelList;
    EditText edLeft;
    EditText edRight;
    Button btLeft;
    Button btRight;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet();
        recyclerView=findViewById(R.id.recyclerview);
        edLeft=findViewById(R.id.edt_left);
        edRight=findViewById(R.id.edt_right);
        btLeft=findViewById(R.id.btn_left);
        btRight=findViewById(R.id.btn_right);

        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapterModel=new AdapterModel(modelList,this);
        recyclerView.setAdapter(adapterModel);
    }

    public void dataSet(){
        modelList=new ArrayList<>();
        modelList.add(new Model("Hello", ONE_TYPE));
        modelList.add(new Model("good bye",TWO_TYPE));}
//        modelList.add(new Model("Hello", ONE_TYPE));
//        modelList.add(new Model("good bye",TWO_TYPE));
//        modelList.add(new Model("Hello", ONE_TYPE));
//        modelList.add(new Model("good bye",TWO_TYPE));
//        modelList.add(new Model("Hello", ONE_TYPE));
//        modelList.add(new Model("good bye",TWO_TYPE));
//        modelList.add(new Model("Hello", ONE_TYPE));
//        modelList.add(new Model("good bye",TWO_TYPE));
//    }

    @Override
    public void onClick(View view) {
        String left=edLeft.getText().toString();
        String right=edRight.getText().toString();
        modelList=new ArrayList<>();

        switch (view.getId()){
            case R.id.btn_left:{
                modelList.add(new Model(left,ONE_TYPE));
                adapterModel.notifyDataSetChanged();
                //adapterModel.notifyItemInserted(-1);
                break;
            }
            case R.id.btn_right:{
                modelList.add(new Model(right,TWO_TYPE));
                adapterModel.notifyDataSetChanged();
                //adapterModel.notifyItemInserted(-1);
                break;
            }
        }

    }

}
