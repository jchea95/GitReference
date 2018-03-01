package com.example.juliechea.gitreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juliechea on 3/1/18.
 */

public class GitReferenceAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<GitReference> gitReferenceArray;

    public GitReferenceAdapter(Context context, ArrayList<GitReference> references){
        mContext = context;
        gitReferenceArray = references;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gitReferenceArray.size();
    }

    @Override
    public Object getItem(int i) {
        return gitReferenceArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = mInflater.inflate(R.layout.custom_list, viewGroup, false);


        TextView commandView = rowView.findViewById(R.id.command);
        TextView exampleView = rowView.findViewById(R.id.example);
        TextView explanationView = rowView.findViewById(R.id.explanation);
        TextView sectionView = rowView.findViewById(R.id.section);

        GitReference gitReference = (GitReference) getItem(i);

        commandView.setText(gitReference.getCommand());
        exampleView.setText(gitReference.getExample());
        explanationView.setText(gitReference.getExplanations());
        sectionView.setText(gitReference.getSections());

        return rowView;
    }

}
