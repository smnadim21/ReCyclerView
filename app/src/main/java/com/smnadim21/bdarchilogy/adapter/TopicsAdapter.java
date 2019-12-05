package com.smnadim21.bdarchilogy.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smnadim21.bdarchilogy.CatItem;
import com.smnadim21.bdarchilogy.ItemActivity;
import com.smnadim21.bdarchilogy.R;

import java.util.List;

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.MyViewHolder> {
    private List<CatItem> mDataset;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public TopicsAdapter(Context context, List<CatItem> myDataset) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);

        MyViewHolder vh = new MyViewHolder(v);

    /*    v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mDataset.get())
            }
        });*/

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tv_title.setText(mDataset.get(position).getTitle());
        holder.tv_desc.setText(mDataset.get(position).getDesc().substring(0,255)+".... ");
        holder.tv_loc.setText(mDataset.get(position).getLoc());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.imageView.setClipToOutline(true);
        }

        Glide.with(context)
                .load(mDataset.get(position).getImage())
                .placeholder(R.drawable.image_8)
                .into(holder.imageView);

        holder.ll_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, ItemActivity.class)
                        .putExtra("title", mDataset.get(holder.getAdapterPosition()).getTitle())
                        .putExtra("desc",mDataset.get(holder.getAdapterPosition()).getDesc())
                        .putExtra("img",mDataset.get(holder.getAdapterPosition()).getImage())
                        .putExtra("loc",mDataset.get(holder.getAdapterPosition()).getLoc()));
                ;
                //Toast.makeText(context,mDataset.get(position).getCatName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_title, tv_desc, tv_loc;
        ImageView imageView;
        LinearLayout ll_card;

        public MyViewHolder(View v) {
            super(v);
            tv_title = (TextView) v.findViewById(R.id.item_title);
            tv_desc = (TextView) v.findViewById(R.id.item_desc);
            tv_loc = (TextView) v.findViewById(R.id.item_loc);
            ll_card = v.findViewById(R.id.ll_card);
            imageView = v.findViewById(R.id.image1);
        }
    }
}