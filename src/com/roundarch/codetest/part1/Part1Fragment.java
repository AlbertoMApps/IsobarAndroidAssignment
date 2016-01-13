package com.roundarch.codetest.part1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.roundarch.codetest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdigiovanni on 8/15/13.
 */
public class Part1Fragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    // TODO - any member variables you need to store?

    private SeekBar seekBar1, seekBar2; // declare seekbar object variable
    // declare text label objects
    private TextView textDifference;
    private ToggleButton tb;
    private int diff, progressNumber1, progressNumber2;

    //FIXME: Improve something! Anything
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_part1, null);

        // TODO - obtain references to your views from the layout
        seekBar1 =(SeekBar)view.findViewById(R.id.seekBarID1);
        seekBar2 =(SeekBar)view.findViewById(R.id.seekBarID2);
        textDifference = (TextView) view.findViewById(R.id.textDifferenceID);
        tb = (ToggleButton) view.findViewById(R.id.toggleButton1);

        // TODO - hook up any event listeners that make sense for the task
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        //seekBar1
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressNumber1 = progress;
                diff=progressNumber1-progressNumber2;
                syncronised(seekBar,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //seekBar2
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressNumber2 = progress;
                diff=progressNumber1-progressNumber2;
                syncronised(seekBar,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
//Methods
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        if(seekBar==seekBar1){
//            textDifference.setText(Math.abs(diff));
//        }
        syncronised(seekBar,progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    //Method to syncronise in case the toggle is on set the progress of one or the other, if not set the differnce between them
    private void syncronised(SeekBar s,int progress){
        if(tb.getText().toString().equalsIgnoreCase("ON")) {
            if(s.equals(seekBar1)) seekBar2.setProgress(seekBar1.getProgress());
            else seekBar1.setProgress(seekBar2.getProgress());
            textDifference.setText("" + Math.abs(diff));

        } else {
            textDifference.setText("" + Math.abs(diff));
        }
    }
}
