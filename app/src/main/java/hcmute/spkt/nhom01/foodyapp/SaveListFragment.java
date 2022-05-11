package hcmute.spkt.nhom01.foodyapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import hcmute.spkt.nhom01.foodyapp.adapter.DiaDiemAdapter;
import hcmute.spkt.nhom01.foodyapp.models.DiaDiem;


public class SaveListFragment extends Fragment {

    ListView lvDiaDiem;
    DiaDiemAdapter diaDiemAdapter;
    public SaveListFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_list, container, false);
        lvDiaDiem = view.findViewById(R.id.lvDanhSachDaLuu);
        diaDiemAdapter = new DiaDiemAdapter(getActivity(),R.layout.item);
        lvDiaDiem.setAdapter(diaDiemAdapter);
        AddEvents();
        FakeData();
        return view;
    }

    private void FakeData() {
        diaDiemAdapter.add(new DiaDiem("Chân gà rút xương", "234 Phạm Văn Đồng, Thủ Đức, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST NhaJun"));
        diaDiemAdapter.add(new DiaDiem("Cá lóc hấp bầu", "1 Võ Văn Ngân, Thủ Đức, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST NhaJun"));
        diaDiemAdapter.add(new DiaDiem("Lươn xào xả ớt", "15 Hàng Xanh, Bình Thạnh, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST PhiAnh"));
        diaDiemAdapter.add(new DiaDiem("Đà điểu nướng đá", "234 Phan Văn Trị, Gò Vấp, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST NhaJun"));
        diaDiemAdapter.add(new DiaDiem("Cá ngừ mù tạt", "234 Nguyễn Xuyến, Quận 2, TP.HCM", R.drawable.thanhmap_changa, "Đã lưu vào BST PhiAnh"));

    }
    private void AddEvents() {
    }

}