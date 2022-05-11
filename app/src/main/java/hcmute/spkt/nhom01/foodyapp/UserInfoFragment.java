package hcmute.spkt.nhom01.foodyapp;

import android.content.Intent;
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

//        Tạo user và ánh xạ thông tin lên Fragment
        ThongTinNguoiDung user = new ThongTinNguoiDung("Mai Thanh Nhã", "maithanhnha12345pyl@gmail.com", "1020 Phạm Văn Đồng, Hiệp Bình Chánh", "0965163425", R.drawable.avatar);
        txtTen.setText(user.getTenNguoiDung());
        txtDiaChi.setText(user.getDiaChiNguoiDung());
        txtSDT.setText(user.getSoDienThoaiNguoiDung());
        imgUser.setImageResource(user.getImgNguoiDung());

//        Xử lý sự kiện button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}