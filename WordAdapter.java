package com.example.android.miwok;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int layoutColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> wordArrayList, int color){
        super(context, 0, wordArrayList);
        layoutColorResourceId = color;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        /*
         * Sets the background color to the text_layout.
         */
        LinearLayout textLayout = (LinearLayout)listItemView.findViewById(R.id.text_layout);
        // Finds the color that the resource id maps to.
        int color = ContextCompat.getColor(getContext(), layoutColorResourceId);
        // Sets the color obtained after resolving the ResourceId.
        textLayout.setBackgroundColor(color);

        /*
        * Sets the default translation to the default_text_view.
         */
        TextView defaultText = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultText.setText((currentWord.getmDefaultTranslation()));

        /*
        * Sets the miwok translation to the miwok_text_view.
         */
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getmMiwokTranslation());

        /*
        * Sets the illustration correspoding to the correct TextView.
         */
        ImageView illustration = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            illustration.setImageResource(currentWord.getmImageResourceId());
            illustration.setVisibility(View.VISIBLE);
        }
        else{
            illustration.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
