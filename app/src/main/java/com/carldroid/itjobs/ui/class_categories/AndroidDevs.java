package com.carldroid.itjobs.ui.class_categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.carldroid.itjobs.AndroidDevAdapter;
import com.carldroid.itjobs.AndroidDevModel;
import com.carldroid.itjobs.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AndroidDevs extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference androidjobsRef = db.collection("androidjobs");

    private AndroidDevAdapter androidDevAdapter;

    ProgressDialog pd;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_devs);

         ActionBar actionBar = getSupportActionBar();
         actionBar.setTitle("Android Jobs");

        setUpRecyclerview();
    }

    private void setUpRecyclerview() {
        Query query = androidjobsRef.orderBy("priority", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<AndroidDevModel> options = new FirestoreRecyclerOptions.Builder<AndroidDevModel>()
                .setQuery(query, AndroidDevModel.class)
                .build();

        androidDevAdapter = new AndroidDevAdapter(options);

        recyclerView = findViewById(R.id.recyclerview_android_devs);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void searchData(String query) {

        db.collection("androidjobs").whereEqualTo("jobtitle", query.toLowerCase())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                              //Perform query operations here

                            }


                        }

                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(AndroidDevs.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }
}
