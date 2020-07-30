package br.com.etecia.zegotinha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adapter extends BaseAdapter {
    private Context ctx;
    private int[] icons;

    public Adapter(Context ctx, int[] icons){
        this.ctx = ctx;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(ctx);
        iv.setImageResource(icons[position]);
        iv.setAdjustViewBounds(true);

        return iv;
    }
}
