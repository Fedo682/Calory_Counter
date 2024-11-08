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
        ViewHolder.OnItemClickListener OnClicklistener;
    private List<Recipe> cardItems;
    ArrayAdapter<Recipe> adapter;
    public CaloryReviewAdapter(List<Recipe> cardItems) {
        this.cardItems = cardItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         adapter = new ArrayAdapter<>(parent.getContext(), android.R.layout.simple_list_item_1, cardItems);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calorycard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe cardItem = cardItems.get(position);
        holder.imageView.setImageResource(cardItem.getImageResource());
        holder.titleTextView.setText(cardItem.getName());
        holder.discreption.setText(cardItem.printingredients());
        ArrayAdapter<String> ingredientsAdapter = new ArrayAdapter<>( holder.itemView.getContext(), android.R.layout.simple_list_item_1, cardItem.getIngredients());
        holder.examples.setAdapter(ingredientsAdapter);
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

      static class ViewHolder extends RecyclerView.ViewHolder {
        private OnItemClickListener OnClicklisten;
        ImageView imageView;
        TextView titleTextView;
        ListView examples;
        TextView discreption ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cardimageid);
            titleTextView = itemView.findViewById(R.id.CardTextId);
            examples = itemView.findViewById(R.id.cardNoteId);
            discreption = itemView.findViewById(R.id.discreption);

            itemView.setOnClickListener(v -> {
                if (OnClicklisten != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        OnClicklisten.onItemClick(position);
                    }
                }
            });

                    }
           interface OnItemClickListener {
              void onItemClick(int position);
          }


          public void setOnItemClickListener(OnItemClickListener listener) {
              this.OnClicklisten = listener;
          }
      }

      public void set(ViewHolder.OnItemClickListener listener) {
          this.OnClicklistener = listener;
      }

    }


