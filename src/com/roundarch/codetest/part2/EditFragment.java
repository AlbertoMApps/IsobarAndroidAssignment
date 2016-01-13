package com.roundarch.codetest.part2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.roundarch.codetest.ProgressDialogFragment;
import com.roundarch.codetest.R;

public class EditFragment extends Fragment {
    public static final int RESULT_SAVE = 1;
    public static final String EXTRA_MODEL = "extra_model";

    private DataModel mModel; // TODO - needs to be provided from original Activity/Fragment
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;

    // TODO - This fragment should allow you to edit the fields of DataModel. Then when you click the save button, it should get the DataModel back to the prior activity so it's up to date
    public  EditFragment (){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = getActivity().getIntent().getParcelableExtra("model");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        view.findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                mModel = getArguments().getParcelable("model");
                onClick_save();
            }
        });

        edit1 = (EditText)view.findViewById(R.id.editText1);
        edit2 = (EditText)view.findViewById(R.id.editText2);
        edit3 = (EditText)view.findViewById(R.id.editText3);

        setRetainInstance(true);

        return view;
    }
    public void onClick_save() {
        modifyModelOperation(mModel);
    }
//method when you click the save button
    private void modifyModelOperation(final DataModel model) {
        showLoadingDialog();
        refreshModelFromViews();

        // TODO - you need to implement swapText
        swapText(model);

        // TODO - the BlackBox simulates a slow operation, so you will need to update this code to prevent it from blocking the main thread
        double newValue = BlackBox.doMagic(model.getText3());
        model.setText3(newValue);
        //set the model for this class
        this.setModel(model);

        // TODO - once the model has been updated, you need to find a good way to to provide it back to Part2Fragment in the MainActivity
        getActivity().finish();
    }

    private void showLoadingDialog() {
        FragmentManager fm = getActivity().getFragmentManager();
        ProgressDialogFragment editNameDialog = new ProgressDialogFragment();
        editNameDialog.show(fm, "progress_dialog_fragment");
    }

    private void refreshModelFromViews() {
        // TODO - update our model from the views in our layout
        mModel.setText1(this.edit1.getText().toString());
        mModel.setText2(this.edit2.getText().toString());
        mModel.setText3(Double.parseDouble(this.edit3.getText().toString()));

    }

    // Modifies the data model to swap the values in text1 and text2
    private void swapText(DataModel model) {
        // TODO - swap the text1 and text2 fields on the data model
        model.setText1(this.edit2.getText().toString());
        model.setText2(this.edit1.getText().toString());
    }

    // TODO - use this method from the Activity to set the model and update the views in the layout.
    // You will need to implement the refreshViewsFromModel() method as well

    public void setModel(DataModel model) {
        mModel = model;
        refreshViewsFromModel();
    }

    private void refreshViewsFromModel() {
        // TODO - update our views based on the model's state
//        mModel.setText1(this.edit1.getText().toString());
//        mModel.setText2(this.edit2.getText().toString());
//        //mModel.setText3(Integer.parseInt( this.edit3.getText().toString()));
//        //get the text from the model and send it to setResult

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result1",mModel.getText1());
        returnIntent.putExtra("result2", mModel.getText2());
        returnIntent.putExtra("result3", mModel.getText3());
        getActivity().setResult(Activity.RESULT_OK, returnIntent);
    }
}
