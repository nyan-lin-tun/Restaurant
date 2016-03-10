package com.studyjam.restaurant.userInterface.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studyjam.restaurant.R;
import com.studyjam.restaurant.appModel.Drink;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ethical on 3/9/16.
 */
public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>{
    LayoutInflater inflater;
    Context context;
    List<Drink> pList = Collections.emptyList();

    public DrinkAdapter(Context context,List<Drink> pList){
        this.context = context;
        this.pList = pList;
        notifyDataSetChanged();
        inflater = LayoutInflater.from(context);
    }


    @Override
    public DrinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_item, parent, false);
        DrinkViewHolder viewHolder = new DrinkViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DrinkViewHolder holder, int position) {
        Drink item = pList.get(position);
        holder.dName.setText(item.getDrinkName());
        holder.dPrice.setText(item.getDrinkPrice());
    }




    @Override
    public int getItemCount() {return pList.size();}

    public class DrinkViewHolder extends RecyclerView.ViewHolder{
        private TextView dName,dPrice;
        public DrinkViewHolder(View itemView){
            super(itemView);

            dName = (TextView)itemView.findViewById(R.id.item_data);
            dPrice = (TextView)itemView.findViewById(R.id.price);

        }
    }

}
