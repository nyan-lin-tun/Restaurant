package com.studyjam.restaurant.userInterface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studyjam.restaurant.R;
import com.studyjam.restaurant.appModel.Drink;
import com.studyjam.restaurant.userInterface.adapter.DrinkAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethical on 3/9/16.
 */
public class DrinkFragment extends Fragment{
    private RecyclerView rvDrink;
    private DrinkAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_drink,container,false);
        rvDrink = (RecyclerView)v.findViewById(R.id.drink_list);
        adapter = new DrinkAdapter(getActivity(),getDrinkList());
        rvDrink.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDrink.setAdapter(adapter);
        return v;
    }
    private List<Drink> getDrinkList(){
        String[] drinkName = {"Cola","Pepsi"};
        String[] drinkPrice = {"600","700"};
        List<Drink> drinkList = new ArrayList<>();

        for (int i = 0; i < drinkName.length; i++) {

            Drink item = new Drink();
            item.setDrinkName(drinkName[i]);
            item.setDrinkPrice(drinkPrice[i]);
            drinkList.add(item);

        }

        return drinkList;
    }

}
