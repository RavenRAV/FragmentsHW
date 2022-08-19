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

public class FirstFragment extends Fragment {
    Button firstNextBtn;
    EditText nameET;
    public static String KEY_FOR_FIRST_BUNDLE = "key_first";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        firstNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameET.getText().toString().trim().equals("")) {
                    Toast.makeText(requireContext(), "Введите имя", Toast.LENGTH_SHORT).show();
                } else {
                    nextFragment();
                }

            }
        });
    }

    private void nextFragment() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_FIRST_BUNDLE, nameET.getText().toString());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, secondFragment).addToBackStack(null).commit();
    }

    private void initView(View view) {
        firstNextBtn = view.findViewById(R.id.f_next_btn);
        nameET = view.findViewById(R.id.name_et);
    }
}