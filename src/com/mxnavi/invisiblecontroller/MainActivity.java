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
                case 0x11:  {
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
                }
                case 0x12:
                	Toast.makeText(activity.get().getApplicationContext(),
                			"连接成功",
               		     Toast.LENGTH_SHORT).show();

                   break;  
                case 0x13: {
                	Toast.makeText(activity.get().getApplicationContext(), 
                			"硬件错误",
                			Toast.LENGTH_SHORT).show();
                	String showMessage = String.format("%s连接错误", msg.obj);
               	    Dialog alertDialog = new AlertDialog.Builder(activity.get()). 
                         setTitle("错误"). 
                         setMessage(showMessage). 
                         setIcon(R.drawable.ic_launcher). 
                         setNegativeButton("确定", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                              // TODO Auto-generated method stub
                            	// android.os.Process.killProcess(android.os.Process.myPid());
                             }
                            }).
                         create();
               	    alertDialog.show();
                	break;
                }
                case 0x14: {
                	Toast.makeText(activity.get().getApplicationContext(), 
                			"上传信息",
                			Toast.LENGTH_SHORT).show();
                	String showMessage = String.format("%s上传信息", msg.obj);
               	    Dialog alertDialog = new AlertDialog.Builder(activity.get()). 
                         setTitle("上传信息"). 
                         setMessage(showMessage). 
                         setIcon(R.drawable.ic_launcher). 
                         setNegativeButton("确定", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                              // TODO Auto-generated method stub
                            	// android.os.Process.killProcess(android.os.Process.myPid());
                             }
                            }).
                         create();
               	    alertDialog.show();
                	break;
                }
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
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	public void clickFMBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFMBrightenOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFMBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMONGRADUALLY);
		controllerServiceBinder.sendCommand(command);		
	}
	
	public void clickFMBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMOFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickFMTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMTWINKLE);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clieckFMTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFMOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FMLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickHLTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLTWINKLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickHLTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickHLBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickHLOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	
	public void clickHLBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}

	public void clickHLBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.HLOFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDRTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRTWINKLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDRTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDRBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDROff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DROFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDRBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickDRBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DROFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBMTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMTWINKLE);
		controllerServiceBinder.sendCommand(command);	    	
	}
	
	public void clickBMTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBMOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBMBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBMBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBMBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BMOFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSTWINKLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBSBrightenGraduallyOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BSOFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLTWINKLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBLBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BLOFFGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPTwinkle(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPTWINKLE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPTwinkleOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPTWINKLEOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPBrighten(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPLON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPLOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPBrightenGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPONGRADUALLY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickSPBrightenOffGradually(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SPOFFGRADUALLY);
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
	
	public void clickDriverChairStraight(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRSTRAIGHT);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairHalfLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRHALFLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRSTOP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairStraight(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRSTRAIGHT);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairHalfLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRHALFLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairLayDown(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRLAYDOWN);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRSTOP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairMotorZ1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRZ1);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairMotorZ2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRZ2);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickDriverChairMotorZ3(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVERCHAIRZ3);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairMotorZ1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRZ1);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairMotorZ2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRZ2);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickCoDriverChairMotorZ3(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CODRIVERCHAIRZ3);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void clickFrontDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOOROPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorClose1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORCLOSE1);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorClose2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORCLOSE2);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickFrontDoorStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDOORSTOP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickIrisDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISDOOROPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickIrisDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	

	
	public void clickIrisDoorStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISDOORSTOP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBackDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKDOOROPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBackDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBackDoorClose1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKDOORCLOSE1);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBackDoorClose2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKDOORCLOSE2);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickBackDoorStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKDOORSTOP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickTailDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TAILDOOROPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickTailDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TAILDOORCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickTailDoorStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TAILDOORSTOP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickI1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.I1);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickI2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.I2);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickF1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.F1);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickF2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.F2);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickB1(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.B1);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickB2(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.B2);
		controllerServiceBinder.sendCommand(command);
	}
		
	public void clickedFrontWindowSheetingOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTWINDOWSHEETINGON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedFrontWindowSheetingOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTWINDOWSHEETINGOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedSkyLightSheetingOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SKYLIGHTSHEETINGON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedSkyLightSheetingOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SKYLIGHTSHEETINGOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedLeftWindowSheetingOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.LEFTWINDOWSHEETINGON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedLeftWindowSheetingOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.LEFTWINDOWSHEETINGOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedRightWindowSheetingOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RIGHTWINDOWSHEETINGON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedRightWindowSheetingOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RIGHTWINDOWSHEETINGOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackWindowSheetingOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKWINDOWSHEETINGON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackWindowSheetingOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKWINDOWSHEETINGOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedAudioPowerOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.AUDIOSYSTEMON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedAudioPowerOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.AUDIOSYSTEMOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedLeftSeatOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.LEFTSEATON);
		controllerServiceBinder.sendCommand(command);
	}

	public void clickedLeftSeatOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.LEFTSEATOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedRightSeatOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RIGHTSEATON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedRightSeatOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RIGHTSEATOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedDashboardOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DASHBOARDON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedDashboardOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DASHBOARDOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackMidLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKMIDLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackMidLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKMIDLIGHTOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackSideLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKSIDELIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackSideLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKSIDELIGHTOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackLogoLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKLOGOLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackLogoLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKLOGOLIGHTOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedFrontDaytimeLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDAYTIMELIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedFrontDaytimeLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTDAYTIMELIGHTOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedFrontMidLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTMIDLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedFrontMidLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FRONTMIDLIGHTOFF);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedSidePanelLightOn(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SIDEPANELLIGHTON);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedSidePanelLightOff(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SIDEPANELLIGHTOFF);
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
	
	public void irisPanelStop(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISPANELSTOP);
		controllerServiceBinder.sendCommand(command);	
	}
	
	public void irisPanelReset(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISPANELRESET);
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
	
	public void clickedModeReset(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.RESET);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeNearTheCar(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.NEARTHECAR);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedBackScreenShow(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.BACKSCREENSHOW);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeOpenTheDoor(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.OPENTHEDOOR);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeCloseTheDoor(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CLOSETHEDOOR);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeDriving(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.DRIVING);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeWakeUp(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.WAKEUP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeEntertainment(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.ENTERTAINMENT);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeFullScreen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.FULLSCREEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeCinema(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.CINEMA);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSleep(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SLEEP);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeShowOver(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SHOWOVER);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeIris(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IRISMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeReadingForest(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.READINGFOREST);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSeaWave(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.READINGSEAWARE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeFireplace(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.READINGFIREPLACE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSleepStarrySky(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SLEEPSTARRYSKY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSleepRainyDay(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SLEEPRAINYDAY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeIpOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IPOPEN);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeIpClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.IPCLOSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSeatDriving(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SEATDRIVINGMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSeatLeisure(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SEATLEISUREMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeSeatSleep(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.SEATSLEEPMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeCoSeatDriving(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.COSEATDRIVINGMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeCoSeatLeisure(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.COSEATLEISUREMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeCoSeatSleep(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.COSEATSLEEPMODE);
		controllerServiceBinder.sendCommand(command);
	}

	public void clickedModeTailDoorOpen(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TAILDOOROPENMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeTailDoorClose(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.TAILDOORCLOSEMODE);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedModeAutoDriving(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.AUTODRIVING);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedMediaPlay(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.MEDIAPLAY);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedMediaExit(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.MEDIAEXIT);
		controllerServiceBinder.sendCommand(command);
	}
	
	public void clickedMediaPause(View v) {
		String command = commandMaker.make(CommandMaker.Instruct.MEDIAPAUSE);
		controllerServiceBinder.sendCommand(command);
	}
	
	@Override
	public void commandResultArrived(String command, String params) {
		// TODO Auto-generated method stub
		if (command.equals("neterror")) {
			displayHandler.sendEmptyMessage(0x11);
		} else if (command.equals("netconnected")) {
			displayHandler.sendEmptyMessage(0x12);
		} else if (command.equals("false")) {
			Message message = new Message();
			message.obj = params;
			message.what = 0x13;
			displayHandler.sendMessage(message);
		} else {
			Message message = new Message();
			message.obj = params;
			message.what = 0x14;
			displayHandler.sendMessage(message);
		}
	}

	@Override
	public void started() {
		// TODO Auto-generated method stub
		controllerServiceBinder = ((InvisibleControllerApplication)getApplication()).getControllerServiceBinder();
		controllerServiceBinder.addCommandResultListener(this);
		controllerServiceBinder.connectServer();
	}
	
	@Override
	public void exit() {
		controllerServiceBinder = ((InvisibleControllerApplication)getApplication()).getControllerServiceBinder();
		controllerServiceBinder.disconnectServer();
	}
}
