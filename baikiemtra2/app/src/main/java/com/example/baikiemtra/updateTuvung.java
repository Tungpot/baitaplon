package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class updateTuvung extends AppCompatActivity {
    EditText txttentu, txtphanloai, txtnghia;
    Button edit,cancel;
    String soid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tuvung);
        Anhxa();
        Intent intent = getIntent();
        Item it = (Item) intent.getSerializableExtra("data");
        soid = it.getTentu();
        txttentu.setText(it.getTentu());
        txtphanloai.setText(it.getPhanloai());
        txtnghia.setText(it.getNghia());
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               update("http://192.168.1.4:8080/adnroid_bai2/sua.php");
            }
        });

    }
    private void update(String s) {
        final String ten  = txttentu.getText().toString();
        final String phanloai = txtphanloai.getText().toString();
        final String nghia = txtnghia.getText().toString();


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, s, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast.makeText(updateTuvung.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error1", String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("tentu",String.valueOf(soid));
                hashMap.put("tentu",ten);
                hashMap.put("phanloai",phanloai);
                hashMap.put("nghia",nghia);

                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void Anhxa() {
        txttentu = findViewById(R.id.suatentu);
        txtphanloai = findViewById(R.id.phanloai);
        txtnghia = findViewById(R.id.nghia);
        edit = findViewById(R.id.btnsua);
        cancel = findViewById(R.id.btncancel);
    }
}
