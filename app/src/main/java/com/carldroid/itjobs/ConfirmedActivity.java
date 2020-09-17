package com.carldroid.itjobs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.carldroid.itjobs.adapters.AppliedAdapter;
import com.carldroid.itjobs.adapters.ConfirmedAdapter;
import com.carldroid.itjobs.models.AppliedModel;
import com.carldroid.itjobs.models.ConfirmedModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ConfirmedActivity extends AppCompatActivity {

    private ConfirmedAdapter adapter;

    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    private CollectionReference reference = firestore.collection("Confirmed");

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed);

        firestore = FirebaseFirestore.getInstance();

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
                .whereEqualTo("isApplied", 0);

        FirestoreRecyclerOptions<ConfirmedModel> options = new FirestoreRecyclerOptions.Builder<ConfirmedModel>()
                .setQuery(query, ConfirmedModel.class)
                .build();

        adapter = new ConfirmedAdapter(options, this);


        RecyclerView recyclerView = findViewById(R.id.rec_confirm);
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