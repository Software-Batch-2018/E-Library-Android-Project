package com.example.elibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<ListData> {

    private final Context mContext;
    private final List<ListData> mValues;

    public MyListAdapter(Context context, List<ListData> values) {
        super(context, R.layout.activity_main, values);
        this.mContext = context;
        this.mValues = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_item, parent, false);

        // get references to views in the custom layout
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);

        // get the data for this row
        ListData listItem = mValues.get(position);

        // set the text and image for this row
        textView.setText(listItem.getTitle());
        Picasso.get().load(listItem.getImageUrl()).into(imageView);

        return rowView;
    }
}
