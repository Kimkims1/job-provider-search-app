package com.carldroid.itjobs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.R;
import com.carldroid.itjobs.models.AppliedModel;
import com.carldroid.itjobs.models.ConfirmedModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConfirmedAdapter extends FirestoreRecyclerAdapter<ConfirmedModel, ConfirmedAdapter.confirmViewHolder> {

    private Context context;
    private CollectionReference reference;
    private FirebaseFirestore firestore;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options

     */
    public ConfirmedAdapter(@NonNull FirestoreRecyclerOptions<ConfirmedModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull final confirmViewHolder holder, int position, @NonNull final ConfirmedModel model) {
        holder.jobBudget.setText("Budget: " + model.getJobBudget());
        holder.jobDescription.setText("Description: " + "\n" + model.getJobDescription());
        holder.jobDuration.setText("Time: " + model.getJobDuration());
        holder.payMethod.setText("Payment: " + model.getPayMethod());
        holder.jobTitle.setText("Title: " + model.getJobTitle());
        holder.idNumber.setText("Order id: " + model.getIdNumber());

        holder.btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnComplete.setText("Congratulations!");
            }
        });

    }

    @NonNull
    @Override
    public confirmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_confirmed, parent, false);

        return new confirmViewHolder(view);
    }

    public class confirmViewHolder extends RecyclerView.ViewHolder {

        private TextView jobTitle;
        private TextView jobDescription;
        private TextView jobDuration;
        private TextView payMethod;
        private Button btnComplete;
        private TextView jobBudget;
        private TextView idNumber;
        private RelativeLayout mainLayout;

        public confirmViewHolder(@NonNull View itemView) {
            super(itemView);

            jobBudget = itemView.findViewById(R.id.budget);
            jobDescription = itemView.findViewById(R.id.jobDescription);
            jobDuration = itemView.findViewById(R.id.jobDuration);
            payMethod = itemView.findViewById(R.id.payMethod);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            btnComplete = itemView.findViewById(R.id.btnComplete);
            idNumber = itemView.findViewById(R.id.idNumber);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}
