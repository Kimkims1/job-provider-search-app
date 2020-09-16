package com.carldroid.itjobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.carldroid.itjobs.adapters.JobAdapter;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class JobsActivity extends AppCompatActivity {

    private RecyclerView jobRecyclerView;
    private JobAdapter adapter;

    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference reference = firestore.collection("Jobs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        firestore = FirebaseFirestore.getInstance();

        jobRecyclerView = findViewById(R.id.rec_jobs);

        loadData();

    }

    private void loadData() {
        Query query = reference.orderBy("jobBudget", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<JobModel> options = new FirestoreRecyclerOptions.Builder<JobModel>()
                .setQuery(query, JobModel.class)
                .build();

        adapter = new JobAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.rec_jobs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}