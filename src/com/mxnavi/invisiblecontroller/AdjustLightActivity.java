package com.mxnavi.invisiblecontroller;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class AdjustLightActivity extends Activity implements OnSeekBarChangeListener, OnItemSelectedListener {

	private SeekBar seekBar1Red;
	private SeekBar seekBar1Green;
	private SeekBar seekBar1Blue;
	private SeekBar seekBar1Bright;
	
	private int lastRedValue = 0;
	private int lastGreenValue = 0;
	private int lastBlueValue = 0;
	private int lastBrightValue = 0;
	private int idValue = 1;
	private TextView seekBar1RedValueTextView;
	private TextView seekBar1GreenValueTextView;
	private TextView seekBar1BlueValueTextView;
	private TextView seekBar1BrightValueTextView;
	private Spinner spinner;
	
	private CommandMaker commandMaker = new CommandMaker();
	
	private static final String idList[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
	private static final int idListValue[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private ArrayAdapter<String> spinAdapter;   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adjust_light);
		// seek bar1 red
		seekBar1Red = (SeekBar)findViewById(R.id.seekBar1Red);
		seekBar1Red.setMax(255);
		seekBar1Red.setOnSeekBarChangeListener(this);

		//seek bar1 green 
		seekBar1Green = (SeekBar)findViewById(R.id.seekBar1Green);
		seekBar1Green.setMax(255);
		seekBar1Green.setOnSeekBarChangeListener(this);
		
		//seek bar1 blue
		seekBar1Blue = (SeekBar)findViewById(R.id.seekBar1Blue);
		seekBar1Blue.setMax(255);
		seekBar1Blue.setOnSeekBarChangeListener(this);
		
		//seek bar1 bright
		seekBar1Bright = (SeekBar)findViewById(R.id.seekBar1Bright);
		seekBar1Bright.setMax(255);
		seekBar1Bright.setOnSeekBarChangeListener(this);
		
		seekBar1RedValueTextView = (TextView)findViewById(R.id.seekBar1RedValue);
		seekBar1GreenValueTextView = (TextView)findViewById(R.id.seekBar1GreenValue);
		seekBar1BlueValueTextView = (TextView)findViewById(R.id.seekBar1BlueValue);
		seekBar1BrightValueTextView = (TextView)findViewById(R.id.seekBar1BrightValue);
		
		spinner = (Spinner)findViewById(R.id.spinner);
		spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idList);
		spinner.setAdapter(spinAdapter);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int value, boolean arg2) {
		// TODO Auto-generated method stub
		String content = "当前进度 " + Integer.toString(value);
		int seekBarId = seekBar.getId();
		switch (seekBarId) {
		case R.id.seekBar1Red:
			seekBar1RedValueTextView.setText(content);
			lastRedValue = value;
			break;
		case R.id.seekBar1Green:
			seekBar1GreenValueTextView.setText(content);
			lastGreenValue = value;
			break;
		case R.id.seekBar1Blue:
			seekBar1BlueValueTextView.setText(content);
			lastBlueValue = value;
			break;
		case R.id.seekBar1Bright:
			seekBar1BrightValueTextView.setText(content);
			lastBrightValue = value;
			break;
		}
		
		Log.i("InvisibleController", content);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		//String content = "当前进度 " + Integer.toString(seekBar);
		//currentValueTextView.setText(content);
		Log.i("InvisibleController", "结束");
		sendCommand();
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		idValue = idListValue[arg2];
		sendCommand();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void sendCommand() {
		String command = commandMaker.make(CommandMaker.Instruct.ADJUSTLIGHT, idValue, lastRedValue, lastGreenValue, lastBlueValue, lastBrightValue);
		ControllerService.ControllerServiceBinder controllerServiceBinder = 
				((InvisibleControllerApplication)getApplication()).getControllerServiceBinder();
		controllerServiceBinder.sendCommand(command);
	}
}
