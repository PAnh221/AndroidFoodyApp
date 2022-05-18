package hcmute.spkt.nhom01.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetail extends AppCompatActivity {

    TextView txtTenMon, txtMoTa, txtGia;
    ImageView imgMon;
    Button btnDatHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.monan_layout);
        //      Nhận dữ liệu từ FavoriteList Fragment
        Intent intent = this.getIntent();
        String tenmon = intent.getStringExtra("tenmon");
        String mota = intent.getStringExtra("mota");
        String gia = intent.getStringExtra("gia");
        int idMonAn = intent.getIntExtra("idMon", 0);


        AnhXa();

//        Hiển thị thông tin
        txtTenMon.setText(tenmon);
        txtMoTa.setText(mota);
        txtGia.setText(gia);
        shopimgMonAn(idMonAn);
    }

    private void shopimgMonAn(int idMonAn) {
        // Lấy hình của cửa hàng
        Database database = new Database(this, "foodyappnhom1.sqlite", null, 1);
        Cursor dataMonAn = database.GetData("SELECT * FROM Product WHERE ProID = " + idMonAn + "");
        if (dataMonAn.moveToFirst()) {
            byte[] img = dataMonAn.getBlob(7);
            imgMon.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.length));
        }
        dataMonAn.close();
    }

    private void AnhXa() {
        txtTenMon = findViewById(R.id.txtTenMon);
        txtMoTa = findViewById(R.id.txtMoTaMonAn);
        txtGia = findViewById(R.id.txtGia);
        imgMon = findViewById(R.id.imgMon);
    }
}