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

        database = new Database(this, "foodyapp.sqlite", null, 1);
//        database.QueryData("DROP TABLE user");



        // tạo DB
        database.QueryData("CREATE TABLE IF NOT EXISTS Account(Username VARCHAR(200) PRIMARY KEY, Password VARCHAR(200) NOT NULL, Name VARCHAR(200) NOT NULL, Phone VARCHAR(12), Email VARCHAR(200) NOT NULL,Address NVARCHAR(200), Role VARCHAR(30) NOT NULL)");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Cart(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName NVARCHAR(200) NOT NULL REFERENCES Account(Username), ProductId INTEGER NOT NULL REFERENCES Product(Id), Quantity INTEGER NOT NULL DEFAULT 1)");
        database.QueryData("CREATE TABLE IF NOT EXISTS FavoriteLocation(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName NVARCHAR(200) NOT NULL REFERENCES Account(Username), ShopName NVARCHAR(200) NOT NULL REFERENCES Shop(Name))");
        database.QueryData("CREATE TABLE IF NOT EXISTS FavoriteFood(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName NVARCHAR(200) NOT NULL REFERENCES Account(Username), ProductID INTEGER NOT NULL REFERENCES Product(Id))");
//        database.QueryData("CREATE TABLE IF NOT EXISTS OrderDetail(Id INTEGER PRIMARY KEY AUTOINCREMENT,ProductId INTEGER NOT NULL REFERENCES Product(Id), OrderId INTEGER NOT NULL REFERENCES Orders(Id),Quantity INTEGER NOT NULL, UnitPrice FLOAT)");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Orders(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName NVARCHAR(200) NOT NULL REFERENCES Account(Username), OrderPrice FLOAT,DeliveryPrice FLOAT, TotalPrice FLOAT)");
        database.QueryData("CREATE TABLE IF NOT EXISTS Product(ProID INTEGER PRIMARY KEY AUTOINCREMENT,Name NVARCHAR(200) NOT NULL ,Description NVARCHAR(200), Price FLOAT NOT NULL, Quantity INTEGER NOT NULL, Category VARCHAR(20), ShopName NVARCHAR(200) REFERENCES Shop(Name))");
        database.QueryData("CREATE TABLE IF NOT EXISTS Shop(ShopID INTEGER PRIMARY KEY AUTOINCREMENT, Name NVARCHAR(200), Address NVARCHAR(200), Phone VARCHAR(12))");


//        database.QueryData("INSERT INTO Account VALUES ('phianh', 'phianh', 'Pham Phi Anh', '0909090909', 'pa12asd3@gmail.com', '1 VVN', 'user')");
//        database.QueryData("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200) NOT NULL, username VARCHAR(200), password VARCHAR(200),address VARCHAR(200), role INTEGER)");
//        database.QueryData("INSERT INTO user VALUES ('phianh', 'phianh', 'phianh', '1 vo van ngan', 1)");
//        database.QueryData("INSERT INTO user VALUES (null, 'thanhnha', 'thanhnha', '1', '1 vo van ngan', 1)");

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
    private void AnhXa() {
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
    }
}