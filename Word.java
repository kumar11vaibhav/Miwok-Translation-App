package com.example.android.miwok;

import android.widget.ImageView;

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_SET;

    private int mAudioResourceId;

    private  static final int NO_IMAGE_SET = -1;


    public Word(String defaultTranslation, String miwokTranslation, int AudioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = AudioResourceId;
    }

    /*public Word(String defaultTranslation, String miwokTranslation, int ImageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
    }*/

    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceId, int AudioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return  mMiwokTranslation;
    }

    public int getmImageResourceId() { return mImageResourceId; }

    public int getmAudioResourceId() {return mAudioResourceId; }

    public boolean hasImage(){
        return  mImageResourceId != NO_IMAGE_SET;
    }
}
