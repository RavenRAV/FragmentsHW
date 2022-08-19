package com.example.fragmentshw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    TextView fullName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getFromSecondFragment();
    }

    private void getFromSecondFragment() {
        assert getArguments() != null;
        String value = getArguments().getString(SecondFragment.KEY_FOR_SECOND_BUNDLE);
        fullName.setText("Вас зовут"+ "\n" +value);
    }

    private void initView(View view) {
        fullName = view.findViewById(R.id.full_name_tv);
    }
}