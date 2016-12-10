package com.laptrinhdao.chuctetapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.laptrinhdao.chuctetapp.Model.CauDoi;
import com.laptrinhdao.chuctetapp.R;

import java.util.List;


public class Custom_List extends RecyclerView.Adapter<Custom_List.ViewHolder> {
    Context context;
    List<CauDoi> list;
    public Custom_List(Context context,List<CauDoi> list){
            this.context = context;
            this.list = list;
    }

    @Override
    public Custom_List.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Custom_List.ViewHolder holder, int position) {
        CauDoi c = list.get(position);
        holder.txtTitle.setText(c.getTieude());
        holder.txtTen.setText(c.getTaikhoan());
        holder.txtNgay.setText(c.getNgaydang());
        holder.txtMotangan.setText(c.getMotangan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle,txtMotangan,txtTen,txtNgay;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            txtMotangan = (TextView) itemView.findViewById(R.id.txtContent);
            txtTen = (TextView) itemView.findViewById(R.id.txtName);
            txtNgay = (TextView) itemView.findViewById(R.id.txtDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CauDoi c = list.get(getAdapterPosition());
                    Toast.makeText(context,c.getIdcaudoi()+"",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
