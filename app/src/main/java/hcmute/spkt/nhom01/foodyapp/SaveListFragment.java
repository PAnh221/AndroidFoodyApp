package hcmute.spkt.nhom01.foodyapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import hcmute.spkt.nhom01.foodyapp.adapter.DiaDiemAdapter;
import hcmute.spkt.nhom01.foodyapp.adapter.MonAnAdapter;
import hcmute.spkt.nhom01.foodyapp.models.DiaDiem;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;


public class SaveListFragment extends Fragment {

    ListView lvDiaDiem;
    MonAnAdapter monAnAdapter;
    public SaveListFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_list, container, false);
        lvDiaDiem = view.findViewById(R.id.lvDanhSachDaLuu);
        monAnAdapter = new MonAnAdapter(getActivity(),R.layout.item);
        lvDiaDiem.setAdapter(monAnAdapter);
        AddEvents();
        FakeData();
        return view;
    }

    private void FakeData() {
        monAnAdapter.add(new MonAn("Chân gà rút xương", "234 Phạm Văn Đồng, Thủ Đức, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST NhaJun"));
        monAnAdapter.add(new MonAn("Cá lóc hấp bầu", "1 Võ Văn Ngân, Thủ Đức, TP.HCM", R.drawable.caloc, "Đã lưu vào BST NhaJun"));
        monAnAdapter.add(new MonAn("Lươn xào sả ớt", "15 Hàng Xanh, Bình Thạnh, TP.HCM", R.drawable.luonxao, "Đã lưu vào BST PhiAnh"));
        monAnAdapter.add(new MonAn("Đà điểu nướng đá", "234 Phan Văn Trị, Gò Vấp, TP.HCM", R.drawable.dadieu, "Đã lưu vào BST NhaJun"));
        monAnAdapter.add(new MonAn("Cá ngừ mù tạt", "234 Nguyễn Xuyến, Quận 2, TP.HCM", R.drawable.cangu, "Đã lưu vào BST PhiAnh"));

    }
    private void AddEvents() {
    }

}