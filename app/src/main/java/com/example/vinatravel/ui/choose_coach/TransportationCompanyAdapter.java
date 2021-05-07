package com.example.vinatravel.ui.choose_coach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.tranportation_company.TranportationCompany;

import java.util.ArrayList;

public class TransportationCompanyAdapter extends RecyclerView.Adapter<TransportationCompanyAdapter.ViewHolder> {

    private ArrayList<TranportationCompany> tranportationCompanies;
    private Context context;

    public TransportationCompanyAdapter(ArrayList<TranportationCompany> tranportationCompanies, Context context) {
        this.tranportationCompanies = tranportationCompanies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row_choose_coach_recyclerview,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(tranportationCompanies.get(position).getName());
        holder.imvLogo.setImageResource(tranportationCompanies.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return tranportationCompanies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvLogo;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvLogo = (ImageView) itemView.findViewById(R.id.imvLogo);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
