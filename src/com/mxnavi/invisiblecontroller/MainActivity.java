package com.mxnavi.invisiblecontroller;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements CommandResultListener, ServerStartedListener {

	private ControllerService.ControllerServiceBinder controllerServiceBinder;
	private CommandMaker commandMaker = new CommandMaker();
	static class DisplayHandler extends Handler {
		private final WeakReference<MainActivity> activity;
		public DisplayHandler(MainActivity activity) {
			this.activity = new WeakReference<MainActivity>(activity);
		}
		
		@Override
		public void handleMessage(Message msg) {   
            switch (msg.what) {   
                case 0x11:  
                	Toast.makeText(activity.get().getApplicationContext(), "连接错误",
                		     Toast.LENGTH_SHORT).show();
                    break;   
                case 0x12:
                	Toast.makeText(activity.get().getApplicationContext(), "连接成功",
               		     Toast.LENGTH_SHORT).show();
                   break;  
            }   
            //super.handleMessage(msg);   
        }   
	}
	DisplayHandler displayHandler = new DisplayHandler(this);
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		((InvisibleControllerApplication)getApplication()).addServerStartedListener(this);
	}
	
	public void clickFMOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFMOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFSOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FSLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFSOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FSLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickChairStart(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRSTART);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickChairHeaderUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRHEADERUP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairHeaderDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRHEADERDOWN);
		controllerServiceBinder.sendCommand(command);	
	}

	public void clickChairBackUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRBACKUP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairBackDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRBACKDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairHipUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRHIPUP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairHipDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRHIPDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairFootUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRFOOTUP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairFootDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRFOOTDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairWaistUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRWAISTUP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairWaistDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRWAISTDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairStraight(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRSTRAIGHT);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairHalfLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRHALFLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickChairStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CHAIRSTOP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickFrontDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOOROPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorLockOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTLGITHOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestRedOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTREDLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestRedLittle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTREDLIGHTLITTLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestGreenOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTGREENLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestGreenLittle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTGREENLIGHTLITTLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestBlueOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTBLUELIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestBlueLittle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTBLUELIGHTLITTLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestMixOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTMIXLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickLightTestMixLittle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TESTMIXLIGHTLITTLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	@Override
	public void commandResultArrived(String command) {
		// TODO Auto-generated method stub
		if (command.equals("neterror")) {
			displayHandler.sendEmptyMessage(0x11);
		} else if (command.equals("netconnected")) {
			displayHandler.sendEmptyMessage(0x12);
		}
	}

	@Override
	public void started() {
		// TODO Auto-generated method stub
		controllerServiceBinder = ((InvisibleControllerApplication)getApplication()).getControllerServiceBinder();
		controllerServiceBinder.addCommandResultListener(this);
		controllerServiceBinder.connectServer();
	}
}
