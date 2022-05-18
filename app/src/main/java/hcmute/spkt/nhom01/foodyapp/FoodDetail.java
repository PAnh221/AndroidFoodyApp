package hcmute.spkt.nhom01.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDetail extends AppCompatActivity {

    TextView txtTenMon, txtMoTa, txtGia, txtSoLuong;
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
        Float gia = intent.getFloatExtra("gia",0);
        int idMonAn = intent.getIntExtra("idMon", 0);


        AnhXa();

//        Hiển thị thông tin
        txtTenMon.setText(tenmon);
        txtMoTa.setText(mota);
        txtGia.setText(gia.toString());
        shopimgMonAn(idMonAn);

        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FoodDetail.this,"Đặt hàng thành công! "+gia,Toast.LENGTH_SHORT).show();
                Database database = new Database(FoodDetail.this, "foodyappnhom1.sqlite", null, 1);
//                database.QueryData("INSERT INTO Orders VALUES (1, 0, 0, 0,1)");
                database.QueryData("Insert into OrderDetail Values (null,"+ idMonAn+",1,1,"+ gia+")");
//                database.QueryData("Insert into OrderDetail Values (1,1,1,1,55000)");
                database.QueryData("Update Orders set OrderPrice = (Select Sum(UnitPrice) From OrderDetail) ");
                database.QueryData("Update Orders set DeliveryPrice = 20000 Where OrderPrice > 0");
                database.QueryData("Update Orders set TotalPrice = OrderPrice + DeliveryPrice");
                database.notify();

            }
        });
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
        btnDatHang = findViewById(R.id.btnDatHang);
        txtSoLuong = findViewById(R.id.txtSoLuong);
    }
}