package com.carldroid.itjobs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AndroidDevs extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference freeGamesRef = db.collection("androidjobs");

    private AndroidDevAdapter androidDevAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_devs);

       // Toolbar toolbar = getActionBar();

        setUpRecyclerview();
    }

    private void setUpRecyclerview() {
        Query query = freeGamesRef.orderBy("priority", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<AndroidDevModel> options = new FirestoreRecyclerOptions.Builder<AndroidDevModel>()
                .setQuery(query, AndroidDevModel.class)
                .build();

        androidDevAdapter = new AndroidDevAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_android_devs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(androidDevAdapter);

        androidDevAdapter.setOnItemClickListener(new AndroidDevAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                AndroidDevModel note = documentSnapshot.toObject(AndroidDevModel.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                Toast.makeText(AndroidDevs.this,
                        "Position: " + position + " ID: " + id, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AndroidDevs.this, AndroidJobsDetailed.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        androidDevAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        androidDevAdapter.stopListening();
    }
}
