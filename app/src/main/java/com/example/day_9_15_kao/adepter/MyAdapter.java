package com.example.day_9_15_kao.adepter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day_9_15_kao.R;
import com.example.day_9_15_kao.beans.Json;

import java.util.List;

/**
 * Created by 赵辉 on 2017/9/14.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Json.ResultBean.ListBean> list;

    public MyAdapter(Context context, List<Json.ResultBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getFirstImg()).into(holder.iv_firstImg);
        holder.tv_title.setText(list.get(position).getTitle());
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView tv_title;
        public ImageView iv_firstImg;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_firstImg = (ImageView) rootView.findViewById(R.id.iv_firstImg);
        }
    }
}
