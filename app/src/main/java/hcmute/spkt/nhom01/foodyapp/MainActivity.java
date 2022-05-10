package hcmute.spkt.nhom01.foodyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    Database database;
    EditText edtUsername, edtPassword;
    Button btnCreateAccount, btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtUsername = (EditText) findViewById(R.id.edtUsername);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        Button btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);


        database = new Database(this, "foody.sqlite", null, 1);
//        database.QueryData("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200) NOT NULL, username VARCHAR(200), password VARCHAR(200),address VARCHAR(200), role INTEGER)");
//        database.QueryData("INSERT INTO user VALUES (null, 'phianh', 'phianh', 'phianh', '1 vo van ngan', 1)");

        //        database.QueryData("INSERT INTO user VALUES ('phianh', 'phianh', 'phianh', '1 vo van ngan', 1)");
//        database.QueryData("INSERT INTO user VALUES ('nha', 'nha', '1', '1 vo van ngan', 1)");

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

                Cursor cursor = database.GetData("SELECT * FROM user WHERE username = '" + usrname + "'");
                if (!cursor.moveToFirst()) {
                    Toast.makeText(MainActivity.this, "Tài khoản không tồn tại ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(cursor.getString(3).trim())) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
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

}