package com.example.ptkwallpaper.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {
    private String CategoryName,PhotoURL;

    public CategoryModel(String categoryName, String photoURL) {
        CategoryName = categoryName;
        PhotoURL = photoURL;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.CategoryName);
        dest.writeString(this.PhotoURL);
    }

    protected CategoryModel(Parcel in) {
        this.CategoryName = in.readString();
        this.PhotoURL = in.readString();
    }

    public static final Parcelable.Creator<CategoryModel> CREATOR = new Parcelable.Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel source) {
            return new CategoryModel(source);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
        }
    };
}
