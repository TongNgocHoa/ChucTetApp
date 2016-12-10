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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.laptrinhdao.chuctetapp.Adapter.Custom_List;
import com.laptrinhdao.chuctetapp.Controller.AppConfig;
import com.laptrinhdao.chuctetapp.Model.CauDoi;
import com.laptrinhdao.chuctetapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    String fill[] = {"Mới Nhất","Yêu Thích Nhiều Nhất"};
    Spinner spinner;
    Custom_List custom_list;
    RecyclerView recyclerView;
    List<CauDoi> list = new ArrayList<>();
    RequestQueue requestQueue ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,fill);
        spinner.setAdapter(arrayAdapter);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        requestQueue = Volley.newRequestQueue(getActivity());
        custom_list = new Custom_List(getActivity(),list);
        recyclerView.setAdapter(custom_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        getdata();
        return view;
    }

    private JsonArrayRequest GetData(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ParseData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return jsonArrayRequest;
    }
    private void getdata(){
        requestQueue.add(GetData(AppConfig.URL_GET));
    }
    private void ParseData(JSONArray jsonArray){
        for(int i = 0; i < jsonArray.length();i++){
            CauDoi s = new CauDoi();
            JSONObject jsonObject = null;
            try {
                jsonObject = jsonArray.getJSONObject(i);
                s.setIdcaudoi(jsonObject.getInt("idcaudoi"));
                s.setTieude(jsonObject.getString("tieude"));
                s.setMotangan(jsonObject.getString("motangan"));
                s.setNgaydang(jsonObject.getString("ngaydang"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            list.add(s);
        }
        custom_list.notifyDataSetChanged();

    }

}
