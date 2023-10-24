package com.example.lab_01;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class CountingClass extends BaseObservable {

    Integer countNum = 0;

    @Bindable
    public Integer getCountNum() { return countNum; }

    public void updateCountNum() { setCountNum(countNum+1); }

    public void setCountNum(Integer countNum)
    {
        this.countNum = countNum;
        notifyPropertyChanged(BR.countNum);
    }
}
