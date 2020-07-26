package com.example.quanlinhansu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.quanlinhansu.base.BaseActivity;
import com.example.quanlinhansu.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    @Override
    public Class<MainViewModel> getViewmodel() {
        return MainViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);
          binding.navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                  switch (menuItem.getItemId()){
                      case R.id.menuphongban:
                          Toast.makeText(MainActivity.this, "Phòng ban", Toast.LENGTH_SHORT).show();
                          binding.drawler.closeDrawers();
                          break;
                      case R.id.menunhanvien:
                          Toast.makeText(MainActivity.this, "Nhân viên", Toast.LENGTH_SHORT).show();
                          binding.drawler.closeDrawers();
                          break;
                      case R.id.menuchucvu:
                          Toast.makeText(MainActivity.this, "Chức vụ", Toast.LENGTH_SHORT).show();
                          binding.drawler.closeDrawers();
                          break;
                      case R.id.menulogout:
                          Toast.makeText(MainActivity.this, "Đăng xuất", Toast.LENGTH_SHORT).show();
                          binding.drawler.closeDrawers();
                          break;
                  }
                  return false;
              }
          });
          binding.iconMenuToggle.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  binding.drawler.openDrawer(Gravity.LEFT);
              }
          });
    }
}