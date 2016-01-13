package com.roundarch.codetest.part2;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.roundarch.codetest.R;

public class EditActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit);

        // TODO - you will need to obtain the model object provided to this activity and provide it to the EditFragment
//        DataModel dm = (DataModel)getIntent().getParcelableExtra("model");
//        Bundle b = new Bundle();
//        b.putParcelable("model", intent.getExtras());
//        edif.setArguments(b);
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.edit_fragment, EditFragment.newInstance(p));
//        fragmentTransaction.commit();
        // TODO - this probably isn't the best way to start the EditActivty, try to fix it
//        Bundle b = new Bundle();
//        b.putParcelable("model", dm);
//        FragmentManager fm = getSupportFragmentManager();
//        EditFragment edif= (EditFragment) getSupportFragmentManager().findFragmentById(R.id.edit_fragment);
////        fm.beginTransaction().remove(edif);
//        edif.setArguments(b);
//        fm.beginTransaction().add(R.id.edit_fragment, edif);

//        f.newInstance(p);


    }
}
