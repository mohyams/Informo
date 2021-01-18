package com.example.mohit.fb;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mohit on 05-04-2018.
 */

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ImageViewHolder> {

    private Context mcontext;
    private List<Upload> mUploads;

    public imageAdapter(Context context,List<Upload> ACM){
        mcontext = context;
        mUploads = ACM;

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.acmdisp,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
            holder.tvevent.setText(uploadCurrent.getEventName());
            holder.tvcontent.setText(uploadCurrent.getContent());
            holder.tvtime.setText(uploadCurrent.getTime());
            holder.tvdate.setText(uploadCurrent.getDate());
            holder.tvvenue.setText(uploadCurrent.getVenue());
        Picasso.with(mcontext)
                .load(uploadCurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.ivsnap);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView tvevent;
        public TextView tvcontent;
        public TextView tvtime;
        public TextView tvdate;
        public TextView tvvenue;
        public ImageView ivsnap;


        public ImageViewHolder(View itemView) {
            super(itemView);

            tvevent = itemView.findViewById(R.id.tvevent);
            tvcontent = itemView.findViewById(R.id.tvcontent);
            tvtime = itemView.findViewById(R.id.tvtime);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvvenue = itemView.findViewById(R.id.tvvenue);
            ivsnap = itemView.findViewById(R.id.ivviewimage);
        }
    }
}

