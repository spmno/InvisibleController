package com.mxnavi.invisiblecontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ControllerService extends Service {
	private ControllerServiceBinder controllerServiceBinder = new ControllerServiceBinder();
	private Socket clientSocket;
	private CommandResultListener commandResultListener;
	OutputStream outputStream;
	private final String ipAddress = "192.168.2.231";
	public ControllerService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		return controllerServiceBinder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		NetworkThread networkThread = new NetworkThread();
		networkThread.start();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	
	public class ControllerServiceBinder extends Binder {
		public void sendCommand(String command) {
			try {
				outputStream.write(command.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void addCommandResultListener(CommandResultListener listener) {
			commandResultListener = listener;
		}
	}
	
	class NetworkThread extends Thread {
		private String buffer = "";
		@Override
		public void run() {
			
			 try {
				clientSocket = new Socket(ipAddress, 9876);
				outputStream = clientSocket.getOutputStream(); 
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(  
						 clientSocket.getInputStream()));
				JSONObject initJsonObject = new JSONObject();
				initJsonObject.put("type", "init");
				initJsonObject.put("name", "pad");
				outputStream.write(initJsonObject.toString().getBytes());
				while(true) {
					String line = "";  
	                buffer="";  
	                while ((line = bufferedReader.readLine()) != null) {  
	                    buffer = line + buffer;  
	                }  
	                JSONObject jsonObject = new JSONObject(buffer);
	                String result = jsonObject.getString("result");
	                commandResultListener.commandResultArrived(result);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}
