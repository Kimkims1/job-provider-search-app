package com.carldroid.itjobs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class AndroidDevAdapter extends FirestoreRecyclerAdapter<AndroidDevModel, AndroidDevAdapter.AndroidDevHolder> {
    private OnItemClickListener listener;

    public AndroidDevAdapter(@NonNull FirestoreRecyclerOptions<AndroidDevModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AndroidDevHolder holder, int position, @NonNull AndroidDevModel model) {
        holder.jobtitle.setText(model.getJobtitle());
        holder.jobdescription.setText(model.getJobdescription());
        holder.jobbudget.setText(String.valueOf(model.getJobbudget()));
        holder.joblocation.setText(model.getJoblocation());
        holder.jobtime.setText(model.getJobtime());

    }

    @NonNull
    @Override
    public AndroidDevHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_job_list, parent, false);

        return new AndroidDevHolder(view);
    }

    public class AndroidDevHolder extends RecyclerView.ViewHolder {

        TextView jobtitle;
        TextView jobdescription;
        TextView jobtime;
        TextView joblocation;
        TextView jobbudget;

        public AndroidDevHolder(@NonNull View itemView) {
            super(itemView);

            jobtime = itemView.findViewById(R.id.item_job_time);
            jobdescription = itemView.findViewById(R.id.item_job_description);
            jobtitle = itemView.findViewById(R.id.item_job_title);
            jobbudget = itemView.findViewById(R.id.item_job_budget);
            joblocation = itemView.findViewById(R.id.item_job_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
