package com.mxnavi.invisiblecontroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements CommandResultListener {

	private ControllerService.ControllerServiceBinder controllerServiceBinder;
	private CommandMaker commandMaker = new CommandMaker();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
	}
	
	public void clickFMOn(View v) {
		controllerServiceBinder = ((InvisibleControllerApplication)getApplication()).getControllerServiceBinder();
		String command = commandMaker.make(CommandMaker.Instruct.FMLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFMOff(View v) {
		
	}
	
	public void clickFSOn(View v) {
		
	}
	
	public void clickFSOff(View v) {
		
	}

	@Override
	public void commandResultArrived(String command) {
		// TODO Auto-generated method stub
		
	}
}
