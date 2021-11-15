package com.example.loginv01.ui.daiban;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DaibanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DaibanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("这是待办页面，正在建设中");
    }

    public LiveData<String> getText() {
        return mText;
    }
}