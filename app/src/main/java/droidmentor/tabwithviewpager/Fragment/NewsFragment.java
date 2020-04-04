package droidmentor.tabwithviewpager.Fragment;


import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;

import droidmentor.tabwithviewpager.CustomAdapter;
import droidmentor.tabwithviewpager.Model.News;
import droidmentor.tabwithviewpager.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    String title;
    String date;
    String about;
    private DatabaseReference mDatabase;



    boolean test = true;
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_news, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        List<News> list;
        ListView listView = (ListView)view.findViewById(R.id.listview);

        list = new ArrayList<>();
        list.add(new News("iheb","24/07/1996","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));


        CustomAdapter adapter = new CustomAdapter(getActivity(),R.layout.news_items,list);
        listView.setAdapter(adapter);



        return  view;
        }

    }