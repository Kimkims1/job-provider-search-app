package com.carldroid.itjobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.carldroid.itjobs.adapters.JobAdapter;
import com.carldroid.itjobs.models.JobModel;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class JobsActivity extends AppCompatActivity {

    private RecyclerView jobRecyclerView;
    private FirebaseFirestore firestore;
    private JobAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        firestore = FirebaseFirestore.getInstance();

        jobRecyclerView = findViewById(R.id.jobRecyclerView);
        Query query = firestore.collection("Jobs");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(3)
                .build();

        //Firestore Recycler Options
        FirestorePagingOptions<JobModel> options = new FirestorePagingOptions.Builder<JobModel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, JobModel.class)
                .build();

        adapter = new JobAdapter(options, this);


        jobRecyclerView.setHasFixedSize(true);
        jobRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        jobRecyclerView.setAdapter(adapter);
    }
}