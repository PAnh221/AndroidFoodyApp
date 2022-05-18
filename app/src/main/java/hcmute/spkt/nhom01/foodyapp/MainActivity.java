package hcmute.spkt.nhom01.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Database database;
    EditText edtUsername, edtPassword;
    Button btnCreateAccount, btnLogin;
    CheckBox cbRemember;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        edtUsername.setText(sharedPreferences.getString("taikhoan", ""));
        edtPassword.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        createData();



        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrname = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                Cursor cursor = database.GetData("SELECT * FROM Account WHERE Username = '" + usrname + "'");
                if (!cursor.moveToFirst()) {
                    Toast.makeText(MainActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(cursor.getString(1).trim())) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("tennguoidung", cursor.getString(2).trim());
                        editor.putString("emailnguoidung", cursor.getString(4).trim());
                        editor.putString("diachinguoidung", cursor.getString(5).trim());


                        if(cbRemember.isChecked()) {
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("taikhoan", usrname);
                            editor.putString("matkhau", password);
                            editor.putBoolean("checked", true);
                            editor.commit();
                        }
                        else {
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove("taikhoan");
                            editor.remove("matkhau");
                            editor.remove("checked");
                            editor.commit();
                        }

                        Intent intent = new Intent(MainActivity.this, MainLayoutActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void createData() {
        database = new Database(this, "foodyappnhom1.sqlite", null, 1);
//        database.QueryData("INSERT INTO Cart VALUES (1, 'phianh')");
//        database.QueryData("Delete From OrderDetail");
//        database.QueryData("Drop table Cart");
//        database.QueryData("Drop table Orders");
//        database.QueryData("Drop table OrderDetail");
//        database.QueryData("CREATE TABLE Cart(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName NVARCHAR(200) NOT NULL REFERENCES Account(Username))");
//        database.QueryData("CREATE TABLE OrderDetail(Id INTEGER PRIMARY KEY AUTOINCREMENT,ProductId INTEGER NOT NULL REFERENCES Product(ProId), OrderId INTEGER NOT NULL REFERENCES Orders(Id),Quantity INTEGER NOT NULL, UnitPrice FLOAT)");
//        database.QueryData("CREATE TABLE Orders(Id INTEGER PRIMARY KEY AUTOINCREMENT, OrderPrice FLOAT, DeliveryPrice FLOAT, TotalPrice FLOAT, CarID INTEGER NOT NULL REFERENCES Cart(Id))");
    }

    private void AnhXa() {
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
    }
}