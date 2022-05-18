package hcmute.spkt.nhom01.foodyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import hcmute.spkt.nhom01.foodyapp.adapter.MonAnAdapter;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;

public class ShopActivity extends AppCompatActivity {
    TextView txtShopName, txtAddress, txtPhone;
    ListView lvMonAn;
    MonAnAdapter monAnAdapter;
    ImageView imgMon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuhang_layout);


//      Nhận dữ liệu từ FavoriteList Fragment
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("tencuahang");
        String address = intent.getStringExtra("diachicuahang");
        String phone = intent.getStringExtra("sdtcuahang");
        int idCuahang = intent.getIntExtra("idCuaHang", 0);

//        Ánh xạ thông tin
        txtShopName = findViewById(R.id.txtTenMon);
        txtAddress = findViewById(R.id.txtDiaChiAnhXa);
        txtPhone = findViewById(R.id.txtSoDienThoai);
        lvMonAn = findViewById(R.id.lvDanhSachMonAnCuaHang);
        imgMon = findViewById(R.id.imgMon);

        monAnAdapter = new MonAnAdapter(this, R.layout.monan_item);
        lvMonAn.setAdapter(monAnAdapter);


        getFoodData(idCuahang);
//        Dùng fakedata();
//        monAnAdapter.add(new MonAn(1,"Cá lóc hấp bầu","Thơm ngon mời bạn ăn nha!","Caloc","HuongBien", 129000F,1,null));
//        monAnAdapter.add(new MonAn(2,"Bún riêu cua","Thơm ngon mời bạn ăn nha!","Caloc","HuongBien", 129000F,1,null));

//        Hiển thị thông tin
        txtShopName.setText(name);
        txtPhone.setText(phone);
        txtAddress.setText(address);

        showShopImage(idCuahang);

        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               Xử lý sự kiện khi lick vào món ăn
                Intent intent1 = new Intent(ShopActivity.this, FoodDetail.class);
//                Lấy món ăn
                MonAn monAn = monAnAdapter.getItem(i);
                intent1.putExtra("tenmon", monAn.getName());
                intent1.putExtra("mota", monAn.getDescription());
                intent1.putExtra("gia", monAn.getPrice());
                intent1.putExtra("idMon", monAn.getProID());

                startActivity(intent1);
            }
        });
    }

    private void showShopImage(int idCuahang) {
        // Lấy hình của cửa hàng
        Database database = new Database(this, "foodyappnhom1.sqlite", null, 1);
        Cursor dataMonAn = database.GetData("SELECT * FROM Shop WHERE ShopID = " + idCuahang + "");
        if (dataMonAn.moveToFirst()) {
            byte[] img = dataMonAn.getBlob(4);
            imgMon.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.length));
        }
        dataMonAn.close();
    }

    private void getFoodData(int idCuahang) {
        //        Đọc database để lấy ra danh sách món ăn của cửa hàng
        Database database = new Database(this, "foodyappnhom1.sqlite", null, 1);
        Cursor dataMonAn = database.GetData("SELECT * FROM Product WHERE ShopID = " + idCuahang + "");
        while (dataMonAn.moveToNext()) {
            int ProID = dataMonAn.getInt(0);
            String Name = dataMonAn.getString(1).trim();
            String Des = dataMonAn.getString(2).trim();
            Float Price = dataMonAn.getFloat(3);
            int Quantity = dataMonAn.getInt(4);
            String Cat = dataMonAn.getString(5).trim();
            int ShopID = dataMonAn.getInt(6);
            byte[] image = dataMonAn.getBlob(7);

            monAnAdapter.add(new MonAn(ProID, Name, Des, Price, Quantity, Cat, image, ShopID));
        }
        dataMonAn.close();
        monAnAdapter.notifyDataSetChanged();
    }
}