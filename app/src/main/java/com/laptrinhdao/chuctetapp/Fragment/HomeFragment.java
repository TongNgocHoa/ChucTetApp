package com.laptrinhdao.chuctetapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.laptrinhdao.chuctetapp.Adapter.Custom_List;
import com.laptrinhdao.chuctetapp.Model.CauDoi;
import com.laptrinhdao.chuctetapp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    String fill[] = {"Mới Nhất","Yêu Thích Nhiều Nhất"};
    Spinner spinner;
    Custom_List custom_list;
    RecyclerView recyclerView;
    List<CauDoi> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,fill);
        spinner.setAdapter(arrayAdapter);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        custom_list = new Custom_List(getActivity(),list);
        recyclerView.setAdapter(custom_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        getData();
        return view;
    }
    private void getData(){
       list.add(new CauDoi(1,"ABC","dasd","ds","das"));
        list.add(new CauDoi(1,"ABC","dasd","ds","das"));
        list.add(new CauDoi(1,"ABC","dasd","ds","das"));
        list.add(new CauDoi(1,"ABC","dasd","ds","das"));
        list.add(new CauDoi(1,"ABC","dasd","ds","das"));
        list.add(new CauDoi(1,"ABC","dasd","ds","das"));

    }
}
