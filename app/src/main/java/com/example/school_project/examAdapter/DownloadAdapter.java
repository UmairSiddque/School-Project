package com.example.school_project.examAdapter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.school_project.R;
import com.example.school_project.examModel.ExamModel;
import java.util.List;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.ViewHolder> {
    private Context context;
    private List<ExamModel> examModelList;
    private DownloadManager downloadManager;

    public DownloadAdapter(Context context, List<ExamModel> examModelList) {
        this.context = context;
        this.examModelList = examModelList;
    }

    @NonNull
    @Override
    public DownloadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.exam_download_layout,parent,false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DownloadAdapter.ViewHolder holder, int position) {
ExamModel examModel=examModelList.get(position);
holder.downloadTV.setText(examModel.getDownloadResults());
        Glide.with(context).load(examModel.getDownloadResultsIV()).into(holder.downloadIV);
        holder.downloadIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadManager=(DownloadManager) view.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri=Uri.parse("https://www.computernetworkingnotes.com/linux-tutorials/network-configuration-files-in-linux-explained.html");
                DownloadManager.Request request=new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference=downloadManager.enqueue(request);
            }
        });
    }

    @Override
    public int getItemCount() {
        return examModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView downloadTV;
        private ImageView downloadIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            downloadTV=itemView.findViewById(R.id.examDownloadTV);
            downloadIV=itemView.findViewById(R.id.examDownloadIV);
        }
    }
}
