package com.mxnavi.invisiblecontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ControllerService extends Service {
	private ControllerServiceBinder controllerServiceBinder = new ControllerServiceBinder();
	private Socket clientSocket;
	BufferedReader bufferedReader;
	static private CommandResultListener commandResultListener;
	PrintWriter printWriter;
	private final String ipAddress = "192.168.1.100";
	static boolean readFlag = true;
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
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	public class ControllerServiceBinder extends Binder {
		public void sendCommand(String command) {
			try {
				printWriter.write(command);
				printWriter.flush();
			} catch (Exception e) {
				commandResultListener.commandResultArrived("neterror", null);
			}

		}
		
		public void addCommandResultListener(CommandResultListener listener) {
			commandResultListener = listener;
		}
		
		public void connectServer() {
			NetworkStartThread networkThread = new NetworkStartThread();
			networkThread.start();
		}
		
		public void disconnectServer() {
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class NetworkStartThread extends Thread {
		@Override 
		public void run() {
			try {
				clientSocket = new Socket(ipAddress, 9876);
				printWriter = new PrintWriter(clientSocket.getOutputStream(), true); 
				bufferedReader = new BufferedReader(new InputStreamReader(  
						 clientSocket.getInputStream()));
				JSONObject initJsonObject = new JSONObject();
				initJsonObject.put("type", "init");
				initJsonObject.put("name", "pad");
				printWriter.write(initJsonObject.toString()+"\n");
				printWriter.flush();
				commandResultListener.commandResultArrived("netconnected", null);
				NetworkReadThread readThread = new NetworkReadThread();
				readThread.start();
			} catch (IOException e) {
				e.printStackTrace();
				commandResultListener.commandResultArrived("neterror", null);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class NetworkReadThread extends Thread {
		private String buffer = "";
		@Override
		public void run() {
			
			 try {
				while(readFlag) {
					String line = "";  
	                buffer="";  
	                while ((line = bufferedReader.readLine()) != null) {  
		                JSONObject jsonObject = new JSONObject(line);
		                String result = jsonObject.getString("result");
		                String param = jsonObject.getString("part");
		                commandResultListener.commandResultArrived(result, param);

	                }  
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				commandResultListener.commandResultArrived("neterror", null);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
	}
}
