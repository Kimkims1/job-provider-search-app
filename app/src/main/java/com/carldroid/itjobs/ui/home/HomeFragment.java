package com.carldroid.itjobs.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.carldroid.itjobs.AppliedActivity;
import com.carldroid.itjobs.ConfirmedActivity;
import com.carldroid.itjobs.JobsActivity;
import com.carldroid.itjobs.OthersActivity;
import com.carldroid.itjobs.R;

public class HomeFragment extends Fragment {

    private CardView jobs, applied, confirmed, others;

    public HomeFragment() {
        //Required Empty constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jobs = view.findViewById(R.id.jobs);
        applied = view.findViewById(R.id.applied);
        confirmed = view.findViewById(R.id.confirmed);
        others = view.findViewById(R.id.others);

        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), JobsActivity.class);
                startActivity(intent);
            }
        });

        applied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AppliedActivity.class);
                startActivity(intent);
            }
        });

        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ConfirmedActivity.class);
                startActivity(intent);
            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OthersActivity.class);
                startActivity(intent);
            }
        });

    }
}
