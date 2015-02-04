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
	private final String ipAddress = "192.168.1.104";
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
			printWriter.write(command);
			printWriter.flush();
		}
		
		public void addCommandResultListener(CommandResultListener listener) {
			commandResultListener = listener;
		}
		
		public void connectServer() {
			NetworkStartThread networkThread = new NetworkStartThread();
			networkThread.start();
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
				commandResultListener.commandResultArrived("netconnected");
			} catch (IOException e) {
				e.printStackTrace();
				commandResultListener.commandResultArrived("neterror");
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
