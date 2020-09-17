package com.carldroid.itjobs;

import androidx.appcompat.app.ActionBar;
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

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        firestore = FirebaseFirestore.getInstance();
        jobRecyclerView = findViewById(R.id.rec_jobs);

        //init actionbar
        actionBar = getSupportActionBar();

        //title
        actionBar.setTitle("Jobs");

        //add back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        loadData();

    }

    private void loadData() {
        Query query = reference.
                whereEqualTo("isApplied", true)
                .orderBy("idNumber", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<JobModel> options = new FirestoreRecyclerOptions.Builder<JobModel>()
                .setQuery(query, JobModel.class)
                .build();

        adapter = new JobAdapter(options, this);

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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //takes you back to previous activity
        return super.onSupportNavigateUp();
    }
}