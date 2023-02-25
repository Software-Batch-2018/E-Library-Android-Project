package com.example.elibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elibrary.model.ListData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<ListData> {

    private final Context mContext;
    private final List<ListData> mValues;

    private  Class intent_class;

    public MyListAdapter(Context context, List<ListData> values, Class intent_class) {
        super(context, R.layout.activity_main, values);
        this.mContext = context;
        this.mValues = values;
        this.intent_class = intent_class;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_item, parent, false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);

        ListData listItem = mValues.get(position);

        textView.setText(listItem.getTitle());
        Picasso.get().load(listItem.getImageUrl()).into(imageView);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), intent_class);
                Bundle bundle = new Bundle();
                if(intent_class == MainActivity2.class){
                    bundle.putString("level_id", listItem.getLevelId());
                }
                if(intent_class == ChapterActivity.class){
                    bundle.putString("content_id", listItem.getLevelId());
                }
                intent.putExtras(bundle);
                getContext().startActivity(intent);
            }
        });

        return rowView;
    }
}
