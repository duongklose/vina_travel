package com.example.vinatravel.ui.home.manage_ticket;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.ticket.Ticket;
import com.example.vinatravel.ui.ItemClickListener;
import com.example.vinatravel.ui.book_ticket.choose_seat.ChooseSeatActivity;

import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {

    private ArrayList<Ticket> tickets;
    private Context context;

    public TicketAdapter(ArrayList<Ticket> tickets, Context context) {
        this.tickets = tickets;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_ticket,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position) {
        holder.tvNameTransportationCompany.setText(tickets.get(position).getNameTransportationCompany());
        holder.tvLicensePlate.setText(tickets.get(position).getLicensePlate());
        holder.tvPrice.setText(tickets.get(position).getPrice() + "đ");
        holder.tvDefaultStartLocation.setText(tickets.get(position).getDefaultStartLocation());
        holder.tvDefaultEndLocation.setText(tickets.get(position).getDefaultEndLocation());
        holder.tvDate.setText(tickets.get(position).getDate());
        holder.tvStartTime.setText(tickets.get(position).getStartTime());
        holder.tvEndTime.setText(tickets.get(position).getEndTime());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
//                Intent intent = new Intent(context, ChooseSeatActivity.class);
//                intent.putExtra("idTrip", trips.get(position).getId());
//                intent.putExtra("price", trips.get(position).getPrice());
//                intent.putExtra("departureLocation", trips.get(position).getStartLocation());
//                intent.putExtra("arrivalLocation", trips.get(position).getEndLocation());
//                context.startActivity(intent);
                Log.v("AAA", "position " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ItemClickListener itemClickListener;
        TextView tvStartTime, tvEndTime, tvDate, tvDefaultStartLocation, tvDefaultEndLocation, tvNameTransportationCompany, tvLicensePlate, tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvStartTime = itemView.findViewById(R.id.tv_start_time);
            tvEndTime = itemView.findViewById(R.id.tv_end_time);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvDefaultStartLocation = itemView.findViewById(R.id.tv_default_departure_location);
            tvDefaultEndLocation = itemView.findViewById(R.id.tv_default_arrival_location);
            tvNameTransportationCompany = itemView.findViewById(R.id.tv_name_transportation_company);
            tvLicensePlate = itemView.findViewById(R.id.tv_license_plate);
            tvPrice = itemView.findViewById(R.id.tv_price_ticket);

            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}
