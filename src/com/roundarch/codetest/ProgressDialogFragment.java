package com.roundarch.codetest;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

/**
        dialog.setCancelable(false);
        * Created by mdigiovanni on 8/22/13.
                */
        public class ProgressDialogFragment extends DialogFragment {
            public static ProgressDialogFragment newInstance() {
                ProgressDialogFragment frag = new ProgressDialogFragment ();
                return frag;
            }

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {

                final ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setMessage("Loading");
                dialog.setIndeterminate(true);

        // Disable the back button
        DialogInterface.OnKeyListener keyListener = new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {

                if( keyCode == KeyEvent.KEYCODE_BACK){
                    return true;
                }
                return false;
            }


        };
        dialog.setOnKeyListener(keyListener);
        return dialog;
    }

}
