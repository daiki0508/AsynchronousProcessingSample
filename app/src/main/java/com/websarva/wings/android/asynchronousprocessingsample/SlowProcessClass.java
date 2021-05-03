package com.websarva.wings.android.asynchronousprocessingsample;

import android.content.Context;

public class SlowProcessClass extends MainActivity{
    private final Context con;

    SlowProcessClass(Context context){
        this.con = context;
    }

    String ViewText(){
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "This process was slow...";
    }
}
