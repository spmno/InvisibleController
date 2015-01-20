package com.mxnavi.invisiblecontroller;

import org.json.JSONException;
import org.json.JSONObject;

public class CommandMaker {
	static final String END_COMMAND_SIGN = "\n";
	enum Instruct {
		FMLON,
		FMLOFF,
		FSLON,
		FSLOFF,
	}
	public String make(Instruct instruct) {
		JSONObject commandJson = new JSONObject();
		String type = "";
		String part = "";
		String action = "";

		switch(instruct) {
		case FMLON:
			type = "single";
			part = "door";
			action = "open";
			break;
		case FMLOFF:
			break;
		default:
			return "";
		}
		
		try {
			commandJson.put("type", type);
			commandJson.put("part", part);
			commandJson.put("action", action);
			commandJson.put("priority", "high");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commandJson.toString() + END_COMMAND_SIGN;
	}
}
