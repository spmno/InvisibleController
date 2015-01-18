package com.mxnavi.invisiblecontroller;


import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class InvisibleControllerApplication extends Application {
	private ControllerServiceConnection controllerServiceConnection;
	private ControllerService.ControllerServiceBinder controllerServiceBinder;

	
	@Override
    public void onCreate() {
        super.onCreate();
		Intent intent = new Intent(this, ControllerService.class);
		controllerServiceConnection = new ControllerServiceConnection();
		bindService(intent, controllerServiceConnection, Context.BIND_AUTO_CREATE);
    }
    
	public ControllerService.ControllerServiceBinder getControllerServiceBinder() {
		return controllerServiceBinder;
	}
	
	public class ControllerServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder iBinder) {
			// TODO Auto-generated method stub
			controllerServiceBinder = (ControllerService.ControllerServiceBinder)iBinder;
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
