package com.studyjam.restaurant.userInterface.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.studyjam.restaurant.R;
import com.studyjam.restaurant.appModel.NavigationItem;
import com.studyjam.restaurant.userInterface.activity.KFCActivity;
import com.studyjam.restaurant.userInterface.activity.LotteriaActivity;
import com.studyjam.restaurant.userInterface.activity.SharJoonPyanActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nyan Lin Tun on 3/9/16.
 */
public class NavRecyclerAdapter extends RecyclerView.Adapter<NavRecyclerAdapter.NavViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<NavigationItem> data = Collections.emptyList();
    public NavRecyclerAdapter(Context context, List<NavigationItem> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public NavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View nview = inflater.inflate(R.layout.drawer_list_item, parent, false);
        NavViewHolder holder = new NavViewHolder(nview);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavViewHolder holder, final int position) {
        NavigationItem item = data.get(position);
        holder.icon.setImageResource(item.getIconId());
        holder.text.setText(item.getText());
        holder.rvLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        context.startActivity(new Intent(context, SharJoonPyanActivity.class));
                        break;
                    case 1:
                        context.startActivity(new Intent(context, KFCActivity.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context, LotteriaActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() { return data.size();}

    public class NavViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout rvLayout;
        private ImageView icon;
        private TextView text;

        public NavViewHolder(View itemView) {
            super(itemView);
            rvLayout = (LinearLayout) itemView.findViewById(R.id.rvLayout);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
