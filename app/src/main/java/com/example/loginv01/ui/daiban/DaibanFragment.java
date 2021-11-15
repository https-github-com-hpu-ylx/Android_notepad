package com.example.loginv01.ui.daiban;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginv01.R;
import com.example.loginv01.databinding.FragmentDaibanBinding;
import com.example.loginv01.ui.daiban.DaibanViewModel;

public class DaibanFragment extends Fragment {

    private DaibanViewModel daibanViewModel;
    private FragmentDaibanBinding binding;
    private ListView mylistcheck1;
    private ArrayAdapter<String> myAdapter; //定义适配器
    private String[] books = {"test1","test2","test3"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        daibanViewModel =
                new ViewModelProvider(this).get(DaibanViewModel.class);

        binding = FragmentDaibanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textDaiban;
        final ListView mylistercheck = binding.mylistercheck;
        daibanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
                //初始化控件
                mylistcheck1 = mylistercheck.findViewById(R.id.mylistercheck);
                myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_checked,books);
                mylistcheck1.setAdapter(myAdapter);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}