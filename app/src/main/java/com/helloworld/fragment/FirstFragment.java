package com.helloworld.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.helloworld.R;
import com.helloworld.activity.PlayerActivity;

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ImageView artistImageView;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        artistImageView = view.findViewById(R.id.artistImageView);

        artistImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("mirasantika"); // Ganti dengan nama file video yang diinginkan
            }
        });

        return view;
    }

    private void playVideo(String videoName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), PlayerActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }
}
