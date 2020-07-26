package com.example.quanlinhansu.fragment.nhanvien;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.example.quanlinhansu.R;
import com.example.quanlinhansu.base.BaseFragment;
import com.example.quanlinhansu.databinding.FragNhanvieBinding;

public class NhanVienFramgne extends BaseFragment<FragNhanvieBinding,NhanVienViewModel> {
    @Override
    public Class<NhanVienViewModel> getViewmodel() {
        return NhanVienViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_nhanvie;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        setupSpinner();
    }

    private void setupSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.trinhdo_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                binding.spinnerTrinhdo.setAdapter(adapter);
    }

    @Override
    public void ViewCreated() {
          event();
    }

    private void event() {
        binding.edtNgaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(1);
            }
        });
        binding.edtNgayvaolam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(2);
            }
        });
    }

    public void showDatePickerDialog(final int type){
        DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                  if(type == 1){
                      binding.edtNgaysinh.setText(i2 + "/" +  i1+ "/" + i );
                  }else if(type == 2){
                      binding.edtNgayvaolam.setText(i2 + "/" +  i1+ "/" + i );
                  }
            }
        },2020,7,27);
        dialog.show();
    }
}
