package com.carldroid.itjobs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.R;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;


public
class JobAdapter extends FirestorePagingAdapter<JobModel, JobAdapter.jobViewHolder> {

    public JobAdapter(@NonNull FirestorePagingOptions<JobModel> options, Context context) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull jobViewHolder holder, int position, @NonNull JobModel model) {
        holder.jobTitle.setText(model.getJobTitle());
        holder.jobDuration.setText(model.getJobDuration());
        holder.jobDescription.setText(model.getJobDescription());
        holder.jobBudget.setText(model.getJobBudget());
        holder.payMethod.setText(model.getPayMethod());
    }

    @NonNull
    @Override
    public jobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_myjobs, parent, false);
        return new jobViewHolder(view);
    }

    public class jobViewHolder extends RecyclerView.ViewHolder {

        private TextView jobTitle;
        private TextView jobDescription;
        private TextView jobDuration;
        private TextView payMethod;
        private Button btnApply;
        private TextView jobBudget;

        public jobViewHolder(@NonNull View itemView) {
            super(itemView);

            jobBudget = itemView.findViewById(R.id.budget);
            jobDescription = itemView.findViewById(R.id.jobDescription);
            jobDuration = itemView.findViewById(R.id.jobDuration);
            payMethod = itemView.findViewById(R.id.payMethod);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            btnApply = itemView.findViewById(R.id.btnApply);
        }
    }
}
