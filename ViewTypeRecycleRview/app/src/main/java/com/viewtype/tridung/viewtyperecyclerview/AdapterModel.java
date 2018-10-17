package com.viewtype.tridung.viewtyperecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.viewtype.tridung.viewtyperecyclerview.Model.ONE_TYPE;
import static com.viewtype.tridung.viewtyperecyclerview.Model.TWO_TYPE;

public class AdapterModel extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Model> lists;
    Context context;

    public AdapterModel(List<Model> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType){
            case ONE_TYPE:{
                view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item1,
                        viewGroup,false);
                return new OneViewHolder(view);
            }
            case TWO_TYPE:
                view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item2,
                        viewGroup,false);
                return new TwoViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Model model=lists.get(i);

        switch (getItemViewType(i)){
            case ONE_TYPE:{
                OneViewHolder oneViewHolder= (OneViewHolder) viewHolder;
                oneViewHolder.tv1.setText(model.getTittle());
                break;
            }
            case TWO_TYPE:
                TwoViewHolder twoViewHolder= (TwoViewHolder) viewHolder;
                twoViewHolder.tv2.setText(model.getTittle());
                break;
        }

    }

    @Override
    public int getItemCount() {
        if(lists==null){
            return 0;
        }
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(lists!=null){
            Model model=lists.get(position);
            if(model!=null){
                return model.getType();
            }
        }
        return 0;
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        protected TextView tv1;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{
        protected TextView tv2;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
