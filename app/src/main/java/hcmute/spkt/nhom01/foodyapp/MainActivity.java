package hcmute.spkt.nhom01.foodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Database database;
    EditText edtusername, edtpassword;
    Button txtsignup, btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtusername = (EditText) findViewById(R.id.edtusername);
        EditText edtpassword = (EditText) findViewById(R.id.edtpassword);
        TextView txtsignup = (TextView) findViewById(R.id.createaccount);
        Button btnlogin = (Button) findViewById(R.id.loginbtn);

        database = new Database(this, "foody.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS User(username VARCHAR(200) PRIMARY KEY, password VARCHAR(200), role INTEGER)");
//        database.QueryData("INSERT INTO User VALUES ('phianh', 'phianh', 1)");

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrname = edtusername.getText().toString().trim();
                String password = edtpassword.getText().toString().trim();

                Cursor cursor = database.GetData("SELECT * FROM User WHERE username = '" + usrname + "'");
                if (!cursor.moveToFirst()) {
                    Toast.makeText(MainActivity.this, "Sai tài khoản/mật khẩu", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(cursor.getString(1).trim())) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

}