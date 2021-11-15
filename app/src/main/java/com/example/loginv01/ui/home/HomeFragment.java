package com.example.loginv01.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginv01.MainActivity;
import com.example.loginv01.R;
import com.example.loginv01.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private ListView mylistview1;
    private ListView lv;
    private ArrayAdapter<String> myAdapter; //定义适配器
    private String[] books = {"test1","test2","test3"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final ListView mylistview = binding.mylistview;
        //final TextView textView = binding.textHome;
        mylistview1 = mylistview.findViewById(R.id.mylistview);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
                //初始化控件
                //mylistview1 = mylistview.findViewById(R.id.mylistview);
                myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,books);
                mylistview.setAdapter(myAdapter);   //加载适配器

            }

        });
        //点击监听
        mylistview1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView tv = (TextView)view;
                Toast.makeText(getActivity(), tv.getText()+"", Toast.LENGTH_SHORT).show();
                //弹窗
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