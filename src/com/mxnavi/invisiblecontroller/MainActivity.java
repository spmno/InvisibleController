package com.mxnavi.invisiblecontroller;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
                	Toast.makeText(activity.get().getApplicationContext(), 
                			"连接错误",
                			Toast.LENGTH_SHORT).show();
               	    Dialog alertDialog = new AlertDialog.Builder(activity.get()). 
                         setTitle("错误"). 
                         setMessage("网络连接错误"). 
                         setIcon(R.drawable.ic_launcher). 
                         setNegativeButton("确定", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                              // TODO Auto-generated method stub
                            	 android.os.Process.killProcess(android.os.Process.myPid());
                             }
                            }).
                         create(); 
                    alertDialog.show();
                    break;   
                case 0x12:
                	Toast.makeText(activity.get().getApplicationContext(),
                			"连接成功",
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
	
	public void clickPower5V1On(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER5V1ON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickPower5V1Off(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER5V1OFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickPower12V1On(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER12V1ON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickPower12V1Off(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER12V1OFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickPower24V1On(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER24V1ON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickPower24V1Off(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.POWER24V1OFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void lightTestActivity(View v) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, AdjustLightActivity.class);
		startActivity(intent);
	}
	
	public void irisPanelOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISPANELON);
		controllerServiceBinder.sendCommand(command);		
	}
	
	public void irisPanelOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISPANELOFF);
		controllerServiceBinder.sendCommand(command);		
	}
	
	public void clickRelay3On(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RELAY3ON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickRelay3Off(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RELAY3OFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickRelay4On(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RELAY4ON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickRelay4Off(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RELAY4OFF);
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
