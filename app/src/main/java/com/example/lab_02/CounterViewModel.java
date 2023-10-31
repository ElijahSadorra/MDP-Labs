package com.example.lab_02;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    private final MutableLiveData<Integer> counter = new MutableLiveData<>();

    public CounterViewModel() { counter.setValue(0);}

    public MutableLiveData<Integer> getCounter() { return counter; }

    public void incrementCounter()
    {
        if(counter.getValue() != null)
        {
            counter.setValue(counter.getValue() + 1);
        }
    }

}
