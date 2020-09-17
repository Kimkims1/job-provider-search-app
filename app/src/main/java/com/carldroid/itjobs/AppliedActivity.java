package com.carldroid.itjobs;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carldroid.itjobs.adapters.AppliedAdapter;
import com.carldroid.itjobs.adapters.JobAdapter;
import com.carldroid.itjobs.models.AppliedModel;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AppliedActivity extends AppCompatActivity {

    private RecyclerView jobRecyclerView;
    private AppliedAdapter adapter;

    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference reference = firestore.collection("Applied");

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applied);

        firestore = FirebaseFirestore.getInstance();
        jobRecyclerView = findViewById(R.id.rec_jobs);

        //init actionbar
        actionBar = getSupportActionBar();

        //title
        actionBar.setTitle("Applied");

        //add back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        loadData();

    }

    private void loadData() {
        Query query = reference
                /*.orderBy("idNumber", Query.Direction.DESCENDING)*/
                .whereEqualTo("isApplied",0);

        FirestoreRecyclerOptions<AppliedModel> options = new FirestoreRecyclerOptions.Builder<AppliedModel>()
                .setQuery(query, AppliedModel.class)
                .build();

        adapter = new AppliedAdapter(options,this);


        RecyclerView recyclerView = findViewById(R.id.rec_applied);
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