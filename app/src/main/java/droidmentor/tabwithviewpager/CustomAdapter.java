package droidmentor.tabwithviewpager;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import droidmentor.tabwithviewpager.Model.News;


/**
 * Created by Titou on 13/04/2018.
 */

public class CustomAdapter extends ArrayAdapter<News>{
    Context context;
    int layoutResourceId;
    List<News> listnews=null;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
        this.layoutResourceId=resource;
        this.context=context;
        this.listnews=objects;

    }


    static class DataHolder{
        TextView news;
        TextView date;
        TextView about;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataHolder holder=null;
        if (convertView==null)
        {
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView=inflater.inflate(layoutResourceId,parent,false);
            holder =new DataHolder();
            holder.news=(TextView)convertView.findViewById(R.id.title);
            holder.date=(TextView)convertView.findViewById(R.id.date);
            holder.about=(TextView)convertView.findViewById(R.id.tabout);
            convertView.setTag(holder);
        }
        else {
            holder=(DataHolder)convertView.getTag();
        }
        News news=listnews.get(position);
        holder.news.setText(news.getTitle());
        holder.date.setText(news.getDate());
        holder.about.setText(news.getAbout());
        return convertView;

    }

}
