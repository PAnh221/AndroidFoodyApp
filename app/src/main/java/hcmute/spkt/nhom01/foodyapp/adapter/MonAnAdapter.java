package hcmute.spkt.nhom01.foodyapp.adapter;

import android.app.Activity;
import android.graphics.BitmapFactory;
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

public class MonAnAdapter extends ArrayAdapter<MonAn> {
    Activity context;
    int resource;
    public MonAnAdapter(@NonNull Activity context, int resource) {
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
        TextView txtGia = cus.findViewById(R.id.txtGia);


        MonAn monAn = getItem(position);
//        imgMon.setImageResource(R.drawable.caloc);
        imgMon.setImageBitmap(BitmapFactory.decodeByteArray(monAn.getImage(), 0, monAn.getImage().length));

        txtTen.setText(monAn.getName());
        txtGia.setText(monAn.getPrice().toString());

        return cus;
    }
}
