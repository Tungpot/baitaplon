package com.example.baikiemtra;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class themtuvungFragment extends Fragment {


    EditText edittentu,editphanloai,editnghia;
    Button adđ,huy;
    String urlInsert = "http://192.168.1.4:81/adnroid_bai2/them.php";
    public themtuvungFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_themtuvung, container, false);
        edittentu = v.findViewById(R.id.edittentu);
        editphanloai = v.findViewById(R.id.editphanloai);
        editnghia = v.findViewById(R.id.editnghia);
        adđ = v.findViewById(R.id.btnadd);
        huy = v.findViewById(R.id.btnhuy);
        adđ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edname = edittentu.getText().toString().trim();
                String edpl = editphanloai.getText().toString().trim();
                String ednghia = editnghia.getText().toString().trim();
                if(edname.isEmpty() || edpl.isEmpty() || ednghia.isEmpty() ){
                    Toast.makeText(getContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();

                }
                else {
                    ADDUser(urlInsert);
                }
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;

    }
    private void ADDUser(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(), "Lỗi tùm lum khi thêm", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Lỗi nặng", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>  params = new HashMap<>();
                params.put("tentu", edittentu.getText().toString().trim());
                params.put("phanloai", editphanloai.getText().toString().trim());
                params.put("nghia", editnghia.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
