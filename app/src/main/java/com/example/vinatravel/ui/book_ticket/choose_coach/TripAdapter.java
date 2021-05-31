package com.example.vinatravel.ui.book_ticket.choose_coach;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.trip.Trip;
import com.example.vinatravel.ui.ItemClickListener;
import com.example.vinatravel.ui.book_ticket.choose_seat.ChooseSeatActivity;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private ArrayList<Trip> trips;
    private Context context;

    public TripAdapter(ArrayList<Trip> trips, Context context) {
        this.trips = trips;
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
        holder.tvName.setText(trips.get(position).getName());
        holder.tvPrice.setText(String.valueOf(trips.get(position).getPrice()/1000) + ".000đ");
        holder.tvArrivalLocation.setText(trips.get(position).getEndLocation());
        holder.tvDepartureLocation.setText(trips.get(position).getStartLocation());
        holder.tvDepartureTime.setText(trips.get(position).getDepartureTime());
        holder.tvArrivalTime.setText(trips.get(position).getArrivalTime());
        holder.tvDescription.setText(trips.get(position).getTypename());
        holder.tvRate.setText(String.valueOf(trips.get(position).getRatePoint()));

        holder.imvLogo.setImageResource(R.drawable.hoanglong);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ChooseSeatActivity.class);
                intent.putExtra("idTrip", trips.get(position).getId());
                intent.putExtra("price", trips.get(position).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        ImageView imvLogo;
        TextView tvName, tvPrice, tvDepartureTime, tvArrivalTime, tvTimeMove, tvDepartureLocation, tvArrivalLocation, tvDescription, tvRate;
        private ItemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imvLogo = (ImageView) itemView.findViewById(R.id.imvLogo);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDepartureTime = itemView.findViewById(R.id.tv_departure_time);
            tvArrivalTime = itemView.findViewById(R.id.tv_arrival_time);
            tvTimeMove = itemView.findViewById(R.id.tv_time_move);
            tvDepartureLocation = itemView.findViewById(R.id.tv_departure_location);
            tvArrivalLocation = itemView.findViewById(R.id.tv_arrival_location);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvRate = itemView.findViewById(R.id.tvRate);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}
