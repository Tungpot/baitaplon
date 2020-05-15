package com.example.baikiemtra;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tuvungAdapter extends RecyclerView.Adapter<tuvungAdapter.ViewHolder> {
    ArrayList<Item> arrayList;
    MainActivity context;

    public tuvungAdapter(ArrayList<Item> arrayList, MainActivity context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item, parent, false);
        return (new ViewHolder(itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item it = arrayList.get(position);
        holder.Tentu.setText(it.getTentu());
        holder.Phanloai.setText(it.getPhanloai());
        holder.Nghia.setText(it.getNghia());
        holder.imgxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xoa(it.getTentu(), Integer.parseInt(it.getTentu()));
                notifyDataSetChanged();
            }
        });
        holder.imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), updateTuvung.class);
                intent.putExtra("data", it);
                context.startActivity(intent);
            }
        });
    }

    private void Xoa(String ten, final int id) {
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(context);
        dialogxoa.setMessage("Bạn có chắc muốn xoa " + ten + " không?");
        dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.delete(id);
                notifyDataSetChanged();
            }
        });
        dialogxoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Tentu, Phanloai, Nghia;
        ImageView imgsua, imgxoa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Tentu = (TextView) itemView.findViewById(R.id.txttentu);
            Phanloai = (TextView) itemView.findViewById(R.id.txtphanloai);
            Nghia = (TextView) itemView.findViewById(R.id.txtnghia);
            imgsua = (ImageView) itemView.findViewById(R.id.imgedit);
            imgxoa = (ImageView) itemView.findViewById(R.id.imgxoa);

        }
    }
}