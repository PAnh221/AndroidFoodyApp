package hcmute.spkt.nhom01.foodyapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    Database database;
    Button btnBackToLogin, btnSignUp;
    EditText edtUsernameSignUp,
            edtPasswordSignUp,
            edtConfirmPassword,
            edtnameSignUp,
            edtaddressSignUp,
            edtemailSignUp,
            edtPhoneSignUp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBackToLogin = (Button) findViewById(R.id.btnBackToLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        edtUsernameSignUp = (EditText) findViewById(R.id.edtUsernameSignUp);
        edtPasswordSignUp = (EditText) findViewById(R.id.edtPasswordSignUp);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);
        edtnameSignUp = (EditText) findViewById(R.id.edtnameSignUp);
        edtaddressSignUp = (EditText) findViewById(R.id.edtaddressSignUp);
        edtemailSignUp = (EditText) findViewById(R.id.edtemailSignUp);
        edtPhoneSignUp = (EditText) findViewById(R.id.edtphoneSignUp);

        database = new Database(this, "foodyapp.sqlite", null, 1);

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edtUsernameSignUp.getText().toString().trim();
                String password = edtPasswordSignUp.getText().toString().trim();
                String password_confirm = edtConfirmPassword.getText().toString().trim();
                String name = edtnameSignUp.getText().toString().trim();
                String address = edtaddressSignUp.getText().toString().trim();
                String email = edtemailSignUp.getText().toString().trim();
                String phone = edtPhoneSignUp.getText().toString().trim();
                String role = "user";

                if (username.equals("")) return;
                Cursor cursor = database.GetData("SELECT * FROM Account WHERE Username = '" + username + "'");
                if (((cursor != null) && (cursor.getCount() > 0))) {
                    Toast.makeText(SignUpActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    edtUsernameSignUp.setText("");
                }
                else {
                    if (password.equals(password_confirm) && !password.equals("")) {
                        database.QueryData("INSERT INTO Account VALUES('" + username + "', '" + password + "', '" + name + "', '" + phone + "','"+ email +"', '"+ address +"', '"+ role +"')");
                        Toast.makeText(SignUpActivity.this, "Đã đăng kí thành công với username " + username, Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
