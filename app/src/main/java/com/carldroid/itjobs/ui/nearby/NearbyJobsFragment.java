package com.carldroid.itjobs.ui.nearby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.carldroid.itjobs.R;

public class NearbyJobsFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_nearby_jobs, container, false);

        return root;
    }
}
