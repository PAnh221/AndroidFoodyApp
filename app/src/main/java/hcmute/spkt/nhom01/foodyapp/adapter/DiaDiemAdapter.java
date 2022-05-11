package hcmute.spkt.nhom01.foodyapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hcmute.spkt.nhom01.foodyapp.R;
import hcmute.spkt.nhom01.foodyapp.models.DiaDiem;

public class DiaDiemAdapter extends ArrayAdapter<DiaDiem> {
    Activity context;
    int resource;
    public DiaDiemAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View cus = inflater.inflate(this.resource, null);

        ImageView img = cus.findViewById(R.id.imgQuan);
        TextView txtTen = cus.findViewById(R.id.txtTenQuan);
        TextView txtBST = cus.findViewById(R.id.txtBoSuuTap);
        TextView txtDC = cus.findViewById(R.id.txtDiaChi);

        DiaDiem  dc = getItem(position);
        img.setImageResource(dc.getImgDiaDiem());
        txtTen.setText(dc.getTenDiaDiem());
        txtDC.setText(dc.getDiaChi());
        txtBST.setText(dc.getTenBoSuuTap());
        return cus;
    }
}
