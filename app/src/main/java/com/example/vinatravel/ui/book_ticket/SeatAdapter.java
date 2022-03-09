package com.example.vinatravel.ui.book_ticket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinatravel.R;
import com.example.vinatravel.data.model.seat.Seat;
import com.example.vinatravel.ui.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.ViewHolder> {
    private List<Seat> seats;
    private Callback callback;

    public SeatAdapter(Callback listener) {
        this.seats = new ArrayList<>();
        this.callback = listener;
    }

    public interface Callback {
        void toggleSeat(boolean checked, Seat seat);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Seat> datas) {
        seats.clear();
        seats.addAll(datas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seat, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Seat seat = seats.get(position);
        holder.tbSeat.setTextOff(seat.getName());
        holder.tbSeat.setTextOn(seat.getName());

        if (seat.getState() == 1) {
            holder.tbSeat.setVisibility(View.VISIBLE);
            holder.tbSeat.setBackgroundColor(Color.WHITE);
            holder.tbSeat.setChecked(false);
        } else if (seat.getState() == 2) {
            holder.tbSeat.setVisibility(View.VISIBLE);
            holder.tbSeat.setBackgroundColor(Color.GRAY);
            holder.tbSeat.setChecked(true);
            holder.tbSeat.setEnabled(false);
        } else {
            holder.tbSeat.setVisibility(View.GONE);
        }

        holder.tbSeat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                holder.tbSeat.setBackgroundColor(Color.YELLOW);
                callback.toggleSeat(true, seat);
            } else {
                callback.toggleSeat(false, seat);
                holder.tbSeat.setBackgroundColor(Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ToggleButton tbSeat;
        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tbSeat = itemView.findViewById(R.id.btnSeat);
        }

//        public void setItemClickListener(ItemClickListener itemClickListener)
//        {
//            this.itemClickListener = itemClickListener;
//        }
//
//        @Override
//        public void onClick(View v) {
//            itemClickListener.onClick(v,getAdapterPosition(),false);
//        }
    }
}
