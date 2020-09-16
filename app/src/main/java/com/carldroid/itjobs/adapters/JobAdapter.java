package com.carldroid.itjobs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.R;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class JobAdapter extends FirestoreRecyclerAdapter<JobModel, JobAdapter.jobViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public JobAdapter(@NonNull FirestoreRecyclerOptions<JobModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull jobViewHolder holder, int position, @NonNull JobModel model) {
        holder.jobBudget.setText("Budget: " + model.getJobBudget());
        holder.jobDescription.setText("Description: " + model.getJobDescription());
        holder.jobDuration.setText("Time: " + model.getJobDuration());
        holder.payMethod.setText("Payment: " + model.getPayMethod());
        holder.jobTitle.setText("Title: " + model.getJobTitle());
        holder.idNumber.setText("Order id: " + model.getIdNumber());
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
        private TextView idNumber;

        public jobViewHolder(@NonNull View itemView) {
            super(itemView);

            jobBudget = itemView.findViewById(R.id.budget);
            jobDescription = itemView.findViewById(R.id.jobDescription);
            jobDuration = itemView.findViewById(R.id.jobDuration);
            payMethod = itemView.findViewById(R.id.payMethod);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            btnApply = itemView.findViewById(R.id.btnApply);
            idNumber = itemView.findViewById(R.id.idNumber);
        }
    }

}
