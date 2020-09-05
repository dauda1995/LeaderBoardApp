package com.example.leaderboardapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboardapp.R;
import com.example.leaderboardapp.model.LeaderInfo;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.Holder> {



    List<LeaderInfo> mItems = new ArrayList<>();
    private Context mContext;


    public LeaderAdapter(Context context) {
        mContext = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setInfo(mItems.get(position));


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<LeaderInfo> items) {
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView details;
        TextView country;
        View mView;


        public Holder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.fullname);
            details = itemView.findViewById(R.id.scoreboard);
           // country = itemView.findViewById(R.id.country);

        }
        public void setInfo(LeaderInfo model){
            name.setText(model.name);
            details.setText(model.getScore());
          //  country.setText(model.country);
            Picasso.Builder builder = new Picasso.Builder(mContext);
            builder.downloader(new OkHttp3Downloader(mContext));
            builder.build().load(model.imageUri)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(image);

        }
    }
}
