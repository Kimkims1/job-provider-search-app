package com.carldroid.itjobs.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.AppliedActivity;
import com.carldroid.itjobs.R;
import com.carldroid.itjobs.models.AppliedModel;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AppliedAdapter extends FirestoreRecyclerAdapter<AppliedModel, AppliedAdapter.applyViewHolder> {

    private Context context;
    private CollectionReference reference;
    private FirebaseFirestore firestore;



    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options

     */
    public AppliedAdapter(@NonNull FirestoreRecyclerOptions<AppliedModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final applyViewHolder holder, int position, @NonNull final AppliedModel model) {
        holder.jobBudget.setText("Budget: " + model.getJobBudget());
        holder.jobDescription.setText("Description: " + "\n" + model.getJobDescription());
        holder.jobDuration.setText("Time: " + model.getJobDuration());
        holder.payMethod.setText("Payment: " + model.getPayMethod());
        holder.jobTitle.setText("Title: " + model.getJobTitle());
        holder.idNumber.setText("Order id: " + model.getIdNumber());

    }

    @NonNull
    @Override
    public applyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_applied, parent, false);

        return new applyViewHolder(view);
    }

    public class applyViewHolder extends RecyclerView.ViewHolder {

        private TextView jobTitle;
        private TextView jobDescription;
        private TextView jobDuration;
        private TextView payMethod;
        private Button btnApply;
        private TextView jobBudget;
        private TextView idNumber;
        private RelativeLayout mainLayout;

        public applyViewHolder(@NonNull View itemView) {
            super(itemView);

            jobBudget = itemView.findViewById(R.id.budget);
            jobDescription = itemView.findViewById(R.id.jobDescription);
            jobDuration = itemView.findViewById(R.id.jobDuration);
            payMethod = itemView.findViewById(R.id.payMethod);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            btnApply = itemView.findViewById(R.id.btnApply);
            idNumber = itemView.findViewById(R.id.idNumber);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
