package hcmute.spkt.nhom01.foodyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
    TextView txtShopName, txtAddress, txtPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuhang_layout);

        Intent intent = this.getIntent();
        String name = intent.getStringExtra("tencuahang");
        String address = intent.getStringExtra("diachicuahang");
        String phone = intent.getStringExtra("sdtcuahang");

        txtShopName = findViewById(R.id.txtTenMon);
        txtAddress = findViewById(R.id.txtDiaChiAnhXa);
        txtPhone = findViewById(R.id.txtDanhGiaAnhXa);

        txtShopName.setText(name);
        txtPhone.setText(phone);
        txtAddress.setText(address);
    }
}