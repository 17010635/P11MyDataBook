package sg.edu.rp.c347.p12_mydatabook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Drawer> alDrawer;

    public DrawerAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource,  objects);
        parent_context = context;
        layout_id = resource;
        alDrawer = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row,parent,false);

        ImageView ivIcon = rowView.findViewById(R.id.ivIcon);
        TextView tvName = rowView.findViewById(R.id.tvName);

        Drawer drawer = alDrawer.get(position);

        ivIcon.setImageResource(drawer.getIvIcon());
        tvName.setText(drawer.getName());

        return rowView;
    }

}
