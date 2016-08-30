package com.faprun.zinzanotest.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by Admin on 30/8/2559.
 */
public class BundleSavedState extends View.BaseSavedState {
    private Bundle bundle;



    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
    public BundleSavedState(Parcel source) {
        super(source);
        bundle = source.readBundle();
    }

    public  BundleSavedState(Parcelable superState){
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeBundle(bundle);
    }
}
