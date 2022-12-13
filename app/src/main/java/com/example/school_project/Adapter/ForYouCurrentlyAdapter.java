package com.example.school_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.school_project.Model.Pojo;
import com.example.school_project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class ForYouCurrentlyAdapter extends RecyclerView.Adapter<ForYouCurrentlyAdapter.ViewHolder> {
   public Context context;
   public List<Pojo> pojoList;
    public ForYouCurrentlyAdapter(Context context, List<Pojo> pojoList) {
        this.context = context;
        this.pojoList = pojoList;
    }
    @NonNull
    @Override
    public ForYouCurrentlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForYouCurrentlyAdapter.ViewHolder holder, int position) {
holder.title.setText(pojoList.get(position).getTitle());
holder.subject.setText(pojoList.get(position).getSubject());
        Glide.with(context).load(pojoList.get(position).getImageRes()).into(holder.imageView);

if(pojoList.get(position).getCompleted_levels()==6 ){
    holder.getCompletedStatus.setText(pojoList.get(position).getCompleted_status());
    holder.view1.setBackgroundResource(R.drawable.completed_bg);
    holder.getCompletedStatus.setBackgroundResource(R.drawable.completed_text_bg);
    holder.levelText.setVisibility(View.INVISIBLE);
}
else if(pojoList.get(position).getCompleted_levels()>3 && pojoList.get(position).getCompleted_levels()!=6){
    holder.getCompletedStatus.setText("Level "+pojoList.get(position).getCompleted_levels()+"/"+pojoList.get(position).getGame_levels());
    holder.getCompletedStatus.setBackgroundResource(R.drawable.img_text_bg);
holder.view1.setBackgroundResource(R.drawable.img_bg);
holder.levelText.setVisibility(View.INVISIBLE);
}
else {
    holder.view1.getBackground().setAlpha(0);
    holder.levelText.setText("Level-"+pojoList.get(position).getCompleted_levels());
    holder.levelText.setBackgroundResource(R.drawable.leveltext2_bg);
    holder.rankText.setVisibility(View.INVISIBLE);
    holder.rankIv.setVisibility(View.INVISIBLE);
    holder.bgIv.setVisibility(View.INVISIBLE);
}
if (pojoList.get(position).getRank()==1){
    holder.rankIv.setImageResource(R.drawable.pos1r);
}
        else if (pojoList.get(position).getRank()==2){
            holder.rankIv.setImageResource(R.drawable.pos2r);
        }
        else if (pojoList.get(position).getRank()==3){
            holder.rankIv.setImageResource(R.drawable.pos3r);
        }
        else {
           holder.rankIv.setVisibility(View.INVISIBLE);
            holder.rankText.setText("Rank "+"\n"+pojoList.get(position).getRank());
        }
                }
    @Override
    public int getItemCount() {
        if (pojoList != null) {
            return pojoList.size();
        } else {
return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       public ImageView imageView,rankIv,bgIv;
        public  TextView title,subject,getCompletedStatus,rankText,levelText;
        public View view1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imageForYouC);
            title=itemView.findViewById(R.id.titleForYouC);
            subject=itemView.findViewById(R.id.subjectForYouC);
view1=itemView.findViewById(R.id.view1);
getCompletedStatus=itemView.findViewById(R.id.completedText);
rankIv=itemView.findViewById(R.id.rankIV);
            rankText=itemView.findViewById(R.id.rankText);
            levelText=itemView.findViewById(R.id.levelText);
            bgIv=itemView.findViewById(R.id.bgIv);
        }
    }
}
