package hcmute.spkt.nhom01.foodyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import hcmute.spkt.nhom01.foodyapp.adapter.DiaDiemAdapter;
import hcmute.spkt.nhom01.foodyapp.adapter.MonAnAdapter;
import hcmute.spkt.nhom01.foodyapp.models.DiaDiem;
import hcmute.spkt.nhom01.foodyapp.models.MonAn;


public class FavoriteListFragment extends Fragment {

    ListView lvDiaDiem;
    DiaDiemAdapter diaDiemAdapter;
    public FavoriteListFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        lvDiaDiem = view.findViewById(R.id.lvDiemDiemDaLuu);
        diaDiemAdapter = new DiaDiemAdapter(getActivity(),R.layout.item);
        lvDiaDiem.setAdapter(diaDiemAdapter);
        AddEvents();
        FakeData();
        return view;
    }
    private void FakeData() {
        diaDiemAdapter.add(new DiaDiem("Lẩu chay Hằng Thiện", "234 Phạm Văn Đồng, Thủ Đức, TP.HCM", R.drawable.hangthien, null));
        diaDiemAdapter.add(new DiaDiem("Nướng ngói Ngọc Sơn", "1 Võ Văn Ngân, Thủ Đức, TP.HCM", R.drawable.ngocson, null));
        diaDiemAdapter.add(new DiaDiem("Cơm tấm Ngô Quyền", "15 Hàng Xanh, Bình Thạnh, TP.HCM", R.drawable.ngoquyen, null));
        diaDiemAdapter.add(new DiaDiem("Ẩm thực Làng Sen", "234 Phan Văn Trị, Gò Vấp, TP.HCM", R.drawable.langsen, null));
        diaDiemAdapter.add(new DiaDiem("Nhà hàng Hương Biển", "234 Nguyễn Xuyến, Quận 2, TP.HCM", R.drawable.huongbien, null));

    }
    private void AddEvents() {
        lvDiaDiem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DiaDiem diadiem = diaDiemAdapter.getItem(i);
                Toast.makeText(getActivity(),"Bạn đã chọn "+ diadiem.getTenDiaDiem(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}