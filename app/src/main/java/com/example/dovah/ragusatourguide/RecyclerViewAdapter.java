package com.example.dovah.ragusatourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Sight> mData;
    int fragmentId;

    public RecyclerViewAdapter(Context mContext, List<Sight> mData,int fragmentId) {
        this.mContext = mContext;
        this.mData = mData;
        this.fragmentId=fragmentId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        /*View itemView= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(itemView);*/

        //Call the correct Activity
        if(fragmentId!=2&&fragmentId!=3) {
            View itemView= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
            final MyViewHolder viewHolder=new MyViewHolder(itemView);

            viewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    Intent infoIntent = new Intent(mContext, InfoActivity.class);
                    infoIntent.putExtra("sight_name", mData.get(position).getSightName());
                    infoIntent.putExtra("sight_description", mData.get(position).getSightDescription());
                    infoIntent.putExtra("sight_address", mData.get(position).getSightAddress());
                    infoIntent.putExtra("sight_photo", mData.get(position).getSightResourceId());
                    mContext.startActivity(infoIntent);
                }
            });return viewHolder;
        } else if (fragmentId==2){
            View itemView= LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
            final MyViewHolder viewHolder=new MyViewHolder(itemView);
            viewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    Intent infoIntent = new Intent(mContext, InfoFoodActivity.class);
                    infoIntent.putExtra("sight_name", mData.get(position).getSightName());
                    infoIntent.putExtra("sight_description", mData.get(position).getSightDescription());
                    infoIntent.putExtra("sight_address", mData.get(position).getSightAddress());
                    infoIntent.putExtra("sight_photo", mData.get(position).getSightResourceId());
                    infoIntent.putExtra("sight_number",mData.get(position).getSightTelephone());
                    infoIntent.putExtra("sight_site",mData.get(position).getSightSite());
                    mContext.startActivity(infoIntent);

                }
            });return viewHolder;
        } else{
            View itemView= LayoutInflater.from(mContext).inflate(R.layout.card_item,parent,false);
            final MyViewHolder viewHolder=new MyViewHolder(itemView);

            viewHolder.photoImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   if(viewHolder.cardView.getVisibility()==View.GONE){
                       viewHolder.cardView.setVisibility(View.VISIBLE);
                   } else{
                       viewHolder.cardView.setVisibility(View.GONE);
                   }
                }
            });
            viewHolder.buttonCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    Intent webIntent=new Intent(Intent.ACTION_VIEW);
                    String site=mData.get(position).getSightAddress();
                    Uri website=Uri.parse(site);
                    webIntent.setData(website);
                    if (webIntent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(webIntent);}
                }
            });return viewHolder;

        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (fragmentId==3){
            holder.photoImageView.setImageResource(mData.get(position).getSightResourceId());
            holder.descriptionCardView.setText(mData.get(position).getSightDescription());
            holder.nameTextView.setText(mData.get(position).getSightName());
        }else{
            holder.nameTextView.setText(mData.get(position).getSightName());
            holder.photoImageView.setImageResource(mData.get(position).getSightResourceId());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private ImageView photoImageView;
        private TextView descriptionCardView;
        private RelativeLayout itemLayout;
        private Button buttonCard;
        private LinearLayout cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            photoImageView = itemView.findViewById(R.id.photo);
            itemLayout= itemView.findViewById(R.id.item_layout);
            descriptionCardView=itemView.findViewById(R.id.description);
            buttonCard=itemView.findViewById(R.id.card_button);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }
}
