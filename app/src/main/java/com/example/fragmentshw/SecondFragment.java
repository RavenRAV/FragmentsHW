package com.example.fragmentshw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondFragment extends Fragment {
    Button secondNameBtn;
    EditText secondNameET;
    String value;
    public static String KEY_FOR_SECOND_BUNDLE = "key_second";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getFromFirstFragment();
        secondNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondNameET.getText().toString().trim().equals("")) {
                    Toast.makeText(requireContext(), "Введите фамилию", Toast.LENGTH_SHORT).show();
                } else {
                    nextFragment();
                }
            }
        });
    }

    private void getFromFirstFragment() {
        assert getArguments() != null;
        value = getArguments().getString(FirstFragment.KEY_FOR_FIRST_BUNDLE);
    }

    private void nextFragment() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_SECOND_BUNDLE, value + " " + secondNameET.getText().toString());
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, thirdFragment).addToBackStack(null).commit();
    }

    private void initView(View view) {
        secondNameBtn = view.findViewById(R.id.s_next_btn);
        secondNameET = view.findViewById(R.id.s_name_et);
    }
}