package com.carldroid.itjobs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.R;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class JobAdapter extends FirestoreRecyclerAdapter<JobModel, JobAdapter.jobViewHolder> {

    private Context context;
    private CollectionReference reference;
    private FirebaseFirestore firestore;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public JobAdapter(@NonNull FirestoreRecyclerOptions<JobModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final jobViewHolder holder, int position, @NonNull final JobModel model) {
        holder.jobBudget.setText("Budget: " + model.getJobBudget());
        holder.jobDescription.setText("Description: " + "\n" + model.getJobDescription());
        holder.jobDuration.setText("Time: " + model.getJobDuration());
        holder.payMethod.setText("Payment: " + model.getPayMethod());
        holder.jobTitle.setText("Title: " + model.getJobTitle());
        holder.idNumber.setText("Order id: " + model.getIdNumber());

        holder.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                final CollectionReference collectionReference;

                firestore = FirebaseFirestore.getInstance();

                if (user != null) {

                    String email = user.getEmail();

                    assert email != null;
                    collectionReference = firestore.collection("Applied").document("Users").collection(email);

                    String jobBudget = model.getJobBudget();
                    String jobDescription = model.getJobDescription();
                    String jobDuration = model.getJobDuration();
                    long idNumber = model.getIdNumber();
                    String payMethod = model.getPayMethod();
                    String jobTitle = model.getJobTitle();
                    int isApplied = model.getIsApplied();

                    final JobModel jobModel = new JobModel(jobTitle, jobDescription, jobBudget, jobDuration, payMethod, idNumber, isApplied);

                    collectionReference.add(jobModel)
                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    if (task.isSuccessful()) {

                                        collectionReference
                                                .get()
                                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                        for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots) {

                                                            JobModel modelJob = snapshot.toObject(JobModel.class);
                                                            modelJob.setDocumentId(snapshot.getId());

                                                            String documentId = modelJob.getDocumentId();

                                                            firestore.collection("Notebook").document(documentId)
                                                                    .update("isApplied", 1);

                                                            Toast.makeText(context, "Job Applied Successfully", Toast.LENGTH_LONG).show();

                                                        }
                                                    }
                                                });

                                    } else {
                                        Toast.makeText(context, "Application failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
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
        private RelativeLayout mainLayout;

        public jobViewHolder(@NonNull View itemView) {
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
