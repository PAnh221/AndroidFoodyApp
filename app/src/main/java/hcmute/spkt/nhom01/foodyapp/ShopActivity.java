package hcmute.spkt.nhom01.foodyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import hcmute.spkt.nhom01.foodyapp.adapter.MonAnAdapter;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;

public class ShopActivity extends AppCompatActivity {
    TextView txtShopName, txtAddress, txtPhone;
    ListView lvMonAn;
    MonAnAdapter monAnAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuhang_layout);

//      Nhận dữ liệu từ FavoriteList Fragment
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("tencuahang");
        String address = intent.getStringExtra("diachicuahang");
        String phone = intent.getStringExtra("sdtcuahang");
        String idCuahang = intent.getStringExtra("idCuaHang");

//        Ánh xạ thông tin
        txtShopName = findViewById(R.id.txtTenMon);
        txtAddress = findViewById(R.id.txtDiaChiAnhXa);
        txtPhone = findViewById(R.id.txtDanhGiaAnhXa);
        lvMonAn = findViewById(R.id.lvDanhSachMonAnCuaHang);
        monAnAdapter = new MonAnAdapter(this, R.layout.monan_item);
        lvMonAn.setAdapter(monAnAdapter);

//        Đọc database để lấy ra danh sách món ăn của cửa hàng
//        Database database = new Database(this, "foodyappnhom1.sqlite", null, 1);
//        Cursor dataMonAn = database.GetData("SELECT * FROM Product WHERE ShopID = " + Integer.parseInt(idCuahang) + "");
//        if (dataMonAn.moveToFirst()) {
//            int ProID = dataMonAn.getInt(0);
//            String Name = dataMonAn.getString(1).trim();
//            String Des = dataMonAn.getString(2).trim();
//            String Cat = dataMonAn.getString(3).trim();
//            String ShopName = dataMonAn.getString(4).trim();
//            float Price = dataMonAn.getFloat(5);
//            int Quantity = dataMonAn.getInt(6);
//            monAnAdapter.add(new MonAn(ProID, Name, Des, Cat, ShopName, Price, Quantity, null));
//        }
//        dataMonAn.close();
//        monAnAdapter.notifyDataSetChanged();
//        Dùng fakedata();
        monAnAdapter.add(new MonAn(1,"Cá lóc hấp bầu","Thơm ngon mời bạn ăn nha!","Caloc","HuongBien", 129000F,1,null));
        monAnAdapter.add(new MonAn(2,"Bún riêu cua","Thơm ngon mời bạn ăn nha!","Caloc","HuongBien", 129000F,1,null));

//        Hiển thị thông tin
        txtShopName.setText(name);
        txtPhone.setText(phone);
        txtAddress.setText(address);
    }
}