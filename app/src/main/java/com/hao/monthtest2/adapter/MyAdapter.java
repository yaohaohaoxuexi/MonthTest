package com.hao.monthtest2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hao.monthtest2.MyApp.MyApp;
import com.hao.monthtest2.R;
import com.hao.monthtest2.bean.Bean3;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-27.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Bean3> list;
    public MyAdapter(Context context, ArrayList<Bean3> list) {
        //super();
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            holder = new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_view2, null);
            holder.courseName=(TextView) convertView.findViewById(R.id.courseName);
            holder.grade=(TextView) convertView.findViewById(R.id.grade);
            holder.onlineTime=(TextView) convertView.findViewById(R.id.onlineTime);
            holder.teacherName=(TextView) convertView.findViewById(R.id.teacherName);
            holder.teacherAvatar=(ImageView) convertView.findViewById(R.id.teacherAvatar);
            holder.registerStudentNum=(TextView) convertView.findViewById(R.id.registerStudentNum);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }

        holder.courseName.setText(list.get(position).getCourseName());
        holder.grade.setText(list.get(position).getGrade());
        holder.onlineTime.setText(list.get(position).getOnlineTime());
        holder.teacherName.setText(list.get(position).getTeacherName());
        holder.registerStudentNum.setText(list.get(position).getRegisterStudentNum()+"");

        ImageLoader imageLoader = ImageLoader.getInstance();
        //imageLoader.displayImage(result.get(position).getTeacherAvatar(), holder.teacherAvatar);

        DisplayImageOptions imageOptions = MyApp.diOptions();
        imageLoader.displayImage(list.get(position).getTeacherAvatar(), holder.teacherAvatar, imageOptions);

        return convertView;

    }

   static class ViewHolder{
        TextView courseName;
        TextView grade;
        TextView onlineTime;
        TextView teacherName;
        ImageView teacherAvatar;
        TextView registerStudentNum;
    }
}
