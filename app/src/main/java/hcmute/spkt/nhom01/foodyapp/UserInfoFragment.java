package hcmute.spkt.nhom01.foodyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import de.hdodenhof.circleimageview.CircleImageView;
import hcmute.spkt.nhom01.foodyapp.models.ThongTinNguoiDung;


public class UserInfoFragment extends Fragment {
    TextView txtTen, txtDiaChi, txtSDT;
    CircleImageView imgUser;
    Button btnChangeInfo, btnShare, btnContribution, btnLogout;
    public UserInfoFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Ánh xạ để lấy thông tin
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        txtTen = view.findViewById(R.id.txtTenUser);
        txtSDT = view.findViewById(R.id.txtSoDienThoaiUser);
        txtDiaChi = view.findViewById(R.id.txtDiaChiUser);
        imgUser = view.findViewById(R.id.imgUser);
        btnChangeInfo = view.findViewById(R.id.btnDoiThongTin);
        btnShare = view.findViewById(R.id.btnMoiBanBe);
        btnLogout = view.findViewById(R.id.btnDangXuat);
        btnContribution = view.findViewById(R.id.btnGopY);

        SharedPreferences sharedPreferences;
        sharedPreferences = getActivity().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);

        // Lấy thông tin user hiện tại từ shared
        String name = sharedPreferences.getString("tennguoidung", "");
        String username = sharedPreferences.getString("tendangnhapnguoidung", "");
        String diachi = sharedPreferences.getString("diachinguoidung", "");

//        Tạo user và ánh xạ thông tin lên Fragment
        ThongTinNguoiDung user = new ThongTinNguoiDung(name, username, diachi, "0965163425", R.drawable.avatar);
        txtTen.setText(user.getTenNguoiDung());
        txtDiaChi.setText(user.getDiaChiNguoiDung());
        txtSDT.setText(user.getEmailNguoiDung());
        imgUser.setImageResource(user.getImgNguoiDung());

//        Xử lý sự kiện đăng xuất
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Xóa thông tin người dùng vừa đăng xuất khỏi shared
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("tennguoidung");
                editor.remove("tendangnhapnguoidung");
                editor.remove("diachinguoidung");
                editor.commit();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}