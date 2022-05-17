package hcmute.spkt.nhom01.foodyapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hcmute.spkt.nhom01.foodyapp.R;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;

public class ChiTietMonAnAdapter extends ArrayAdapter<MonAn> {
    Activity context;
    int resource;
    public ChiTietMonAnAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View cus = inflater.inflate(this.resource, null);

        ImageView imgMon = cus.findViewById(R.id.imgMon);
        TextView txtTen = cus.findViewById(R.id.txtTenMon);
        TextView txtMoTaMonAn = cus.findViewById(R.id.txtMoTaMonAn);
        TextView txtGia = cus.findViewById(R.id.txtGia);
        EditText edtLoiNhan = cus.findViewById(R.id.edtLoiNhanChoCuaHang);
        Button btnTang = cus.findViewById(R.id.btnTangSoLuong);
        TextView txtSoLuong = cus.findViewById(R.id.txtSoLuong);
        Button btnGiam = cus.findViewById(R.id.btnGiamSoLuong);
        Button btnDatHang = cus.findViewById(R.id.btnDatHang);

        MonAn monAn = getItem(position);
        imgMon.setImageResource(R.drawable.caloc);
        txtTen.setText(monAn.getName());
        txtMoTaMonAn.setText(monAn.getDescription());
        txtGia.setText(monAn.getPrice().toString());

        return cus;
    }
}
