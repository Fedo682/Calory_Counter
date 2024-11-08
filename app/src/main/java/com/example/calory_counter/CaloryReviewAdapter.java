package com.example.calory_counter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CaloryReviewAdapter extends RecyclerView.Adapter<CaloryReviewAdapter.ViewHolder> {
    private List<Recipe> cardItems;
    private OnItemClickListener onClickListener;

    public CaloryReviewAdapter(List<Recipe> cardItems) {
        this.cardItems = cardItems;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calorycard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe cardItem = cardItems.get(position);
        holder.imageView.setImageResource(cardItem.getImageResource());
        holder.titleTextView.setText(cardItem.getName());
        holder.discreption.setText(cardItem.printingredients());

        // Set up the ingredients list
        ArrayAdapter<String> ingredientsAdapter = new ArrayAdapter<>(holder.itemView.getContext(),
                android.R.layout.simple_list_item_1, cardItem.getIngredients());
        holder.examples.setAdapter(ingredientsAdapter);

        // Set up the click listener for each item
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    onClickListener.onItemClick(currentPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        ListView examples;
        TextView discreption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardimageid);
            titleTextView = itemView.findViewById(R.id.CardTextId);
            examples = itemView.findViewById(R.id.cardNoteId);
            discreption = itemView.findViewById(R.id.discreption);
        }
    }
}
