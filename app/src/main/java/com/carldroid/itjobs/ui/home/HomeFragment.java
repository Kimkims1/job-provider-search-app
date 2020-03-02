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

import com.carldroid.itjobs.AndroidDevs;
import com.carldroid.itjobs.R;

public class HomeFragment extends Fragment {

    CardView android, ios, angular, node, frontend, graphics;

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

        android = view.findViewById(R.id.android_dev);
        ios = view.findViewById(R.id.ios_dev);
        angular = view.findViewById(R.id.angular_dev);
        node = view.findViewById(R.id.node_dev);
        frontend = view.findViewById(R.id.frontend_dev);
        graphics = view.findViewById(R.id.graphics_dev);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent android = new Intent(getActivity(), AndroidDevs.class);
                startActivity(android);
            }
        });
    }
}
