package com.example.baikiemtra;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Danhsach extends Fragment {


    RecyclerView recyclerView;

    public static ArrayList<Item> arrayList;
    public static tuvungAdapter tuvungAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_danhsach, container, false);
        recyclerView = v.findViewById(R.id.rvItem);
        arrayList = new ArrayList<>() ;
        tuvungAdapter = new tuvungAdapter(arrayList, (MainActivity) getContext());
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(tuvungAdapter);
        ReadJSON("http://192.168.1.37:81/adnroid_bai2/data.php");

        return v;

    }

    private void ReadJSON(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Log.d("kiemtra", String.valueOf(response));
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrayList.add(new Item(
                                jsonObject.getString("tentu"),
                                jsonObject.getString("phanloai"),
                                jsonObject.getString("nghia")
                        ));
                        tuvungAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("kiemtra", String.valueOf(error));
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

}

