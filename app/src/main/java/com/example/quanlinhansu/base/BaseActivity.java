package com.example.covid19.base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;


public abstract class BaseActivity<B extends ViewDataBinding,VM extends com.example.covid19.base.BaseViewmodel> extends AppCompatActivity {
    protected B binding;
    protected VM viewmodel;
    public abstract Class<VM> getViewmodel();
    public abstract int getLayoutID();
    public abstract void setBindingViewmodel();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,getLayoutID());
        viewmodel = ViewModelProviders.of(this).get(getViewmodel());
        setBindingViewmodel();
    }

}
