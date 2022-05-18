package hcmute.spkt.nhom01.foodyapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import hcmute.spkt.nhom01.foodyapp.adapter.DiaDiemAdapter;
import hcmute.spkt.nhom01.foodyapp.adapter.MonAnAdapter;
import hcmute.spkt.nhom01.foodyapp.adapter.ThanhToanAdapter;
import hcmute.spkt.nhom01.foodyapp.models.DiaDiem;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;
import hcmute.spkt.nhom01.foodyapp.models.OrderInfo;
import hcmute.spkt.nhom01.foodyapp.models.ThongTinNguoiDung;


public class SaveListFragment extends Fragment {

    TextView tongGioHangAnhXa, txtPhiGiaoHangAnhXa,txtTongCongAnhXa, txtDiaChi, txtTen, txtSoDienThoai;
    ListView lvMonAn;
    ThanhToanAdapter thanhToanAdapter;
    OrderInfo orderInfo;
    Button btnThanhToan;
    public SaveListFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_layout, container, false);
        btnThanhToan = view.findViewById(R.id.btnThanhToan);
        txtPhiGiaoHangAnhXa = view.findViewById(R.id.txtPhiGiaoHangAnhXa);
        txtTongCongAnhXa = view.findViewById(R.id.txtTongCongAnhXa);
        tongGioHangAnhXa = view.findViewById(R.id.txtTongGioHangAnhXa);
        txtDiaChi = view.findViewById(R.id.txtDiaChiAnhXa);
        txtTen = view.findViewById(R.id.txtTenKhachHang);
        txtSoDienThoai = view.findViewById(R.id.txtSoDienThoai);


        lvMonAn = view.findViewById(R.id.lvDanhSachThanhToan);
        thanhToanAdapter = new ThanhToanAdapter(getActivity(),R.layout.thanhtoan_item);
        lvMonAn.setAdapter(thanhToanAdapter);
        AddData();
//        btnDatHang.setOnClickListener(this);

//        Hiện thông tin
        SharedPreferences sharedPreferences;
        sharedPreferences = getActivity().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);

        // Lấy thông tin user hiện tại từ shared
        String name = sharedPreferences.getString("tennguoidung", "");
        String email = sharedPreferences.getString("emailnguoidung", "");
        String diachi = sharedPreferences.getString("diachinguoidung", "");

//        Tạo user và ánh xạ thông tin lên Fragment
        ThongTinNguoiDung user = new ThongTinNguoiDung(name, email, diachi, "0965163425", R.drawable.avatar);
        txtDiaChi.setText(user.getDiaChiNguoiDung());
        txtTen.setText(user.getTenNguoiDung());
        txtSoDienThoai.setText(user.getSoDienThoaiNguoiDung());
        Database database = new Database(getActivity(), "foodyappnhom1.sqlite", null, 1);
        Cursor dataShop = database.GetData("Select Orders.OrderPrice, Orders.DeliveryPrice, Orders.TotalPrice From Orders, Cart, Account Where Orders.CarID = Cart.Id and Cart.UserName = Account.Username");
        while (dataShop.moveToNext()) {
            Float orderprice = dataShop.getFloat(0);
            Float diliveryprice = dataShop.getFloat(1);
            Float totalprice = dataShop.getFloat(2);
            orderInfo = new OrderInfo(orderprice, diliveryprice, totalprice);
        }
        dataShop.close();

        tongGioHangAnhXa.setText(orderInfo.getOrderPrice().toString());
        txtPhiGiaoHangAnhXa.setText(orderInfo.getDeliveryPrice().toString());
        txtTongCongAnhXa.setText(orderInfo.getTotalPrice().toString());


//        Xử lý sự kiện thanh toán:
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database database = new Database(getActivity(), "foodyappnhom1.sqlite", null, 1);
                database.QueryData("Delete From OrderDetail");
                database.QueryData("UPDATE Orders set TotalPrice = 0, OrderPrice = 0, DeliveryPrice = 0");
                Toast.makeText(getActivity(),"Đặt hàng thanh công!",Toast.LENGTH_SHORT).show();
                database.notifyAll();
            }
        });

        return view;
    }

    private void AddEvent() {

    }

    private void AddData() {
        // Lấy dữ liệu từ db
        Database database = new Database(getActivity(), "foodyappnhom1.sqlite", null, 1);
        Cursor dataShop = database.GetData("Select Product.Image, Product.Name, OrderDetail.UnitPrice, OrderDetail.Quantity, Product.ProID, Product.Description, Product.Category, Product.ShopID From Cart, Orders, OrderDetail, Product, Account Where OrderDetail.ProductID = Product.ProID and OrderDetail.OrderId = Orders.Id and Orders.CarID = Cart.Id and Account.Username = Cart.UserName");
        while (dataShop.moveToNext()) {
            byte[] image = dataShop.getBlob(0);
            String ten = dataShop.getString(1).trim();
            Float gia = dataShop.getFloat(2);
            int soluong = dataShop.getInt(3);
            int proID = dataShop.getInt(4);
            String mota = dataShop.getString(5);
            String danhmuc = dataShop.getString(6);
            int shopID = dataShop.getInt(7);
            thanhToanAdapter.add(new MonAn(proID, ten, mota, gia,soluong,danhmuc,image,shopID));
        }
        dataShop.close();
        thanhToanAdapter.notifyDataSetChanged();
    }


}