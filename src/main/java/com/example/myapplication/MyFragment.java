package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFragment extends Fragment {

    @BindView(R.id.frg)
    TextView tv_show;


    private static final String FRG_PARAM = "param";
    private String mParam;


    public MyFragment() {
    }

    public static MyFragment newInstance(String param) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(FRG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(FRG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        tv_show.setText(mParam);
        return view;
    }
}
