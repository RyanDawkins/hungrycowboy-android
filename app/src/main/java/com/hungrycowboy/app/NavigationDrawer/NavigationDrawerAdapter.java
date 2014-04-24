package com.hungrycowboy.app.NavigationDrawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungrycowboy.app.R;

import java.util.ArrayList;

/**
 * Created by kylealanr on 4/10/14.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavigationDrawerItem> navigationDrawerItems;

    public NavigationDrawerAdapter(Context context, ArrayList<NavigationDrawerItem> navigationDrawerItems){
        this.context = context;
        this.navigationDrawerItems = navigationDrawerItems;
    }

    @Override
    public int getCount() {
        return navigationDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navigationDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater myInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = myInflater.inflate(R.layout.drawer_item, null);
        }

        ImageView myIcon = (ImageView) convertView.findViewById(R.id.drawer_icon);
        TextView myText = (TextView) convertView.findViewById(R.id.drawer_list_text);

        myIcon.setImageResource(navigationDrawerItems.get(position).getIcon());
        myText.setText(navigationDrawerItems.get(position).getTitle());

        return convertView;
    }
}
