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
		CHAIRSTART,
		CHAIRHEADER,
		CHAIRHEADERUP,
		CHAIRHEADERDOWN,
		CHAIRBACK,
		CHAIRBACKUP,
		CHAIRBACKDOWN,
		CHAIRHIP,
		CHAIRHIPUP,
		CHAIRHIPDOWN,
		CHAIRFOOT,
		CHAIRFOOTUP,
		CHAIRFOOTDOWN,
		CHAIRFOOTLEFT,
		CHAIRFOOTRIGHT,
		CHAIRWAIST,
		CHAIRWAISTUP,
		CHAIRWAISTDOWN,
		CHAIRWAISTLEFT,
		CHAIRWAISTRIGHT,
		CHAIRSTRAIGHT,
		CHAIRHALFLAYDOWN,
		CHAIRLAYDOWN,
		CHAIRSTOP,
		FRONTDOOROPEN,
		FRONTDOORCLOSE,
		FRONTDOORLOCKOPEN,
		FRONTDOORLOCKCLOSE,
		TESTLIGHTON,
		TESTLGITHOFF,
		TESTREDLIGHTON,
		TESTREDLIGHTLITTLE,
		TESTGREENLIGHTON,
		TESTGREENLIGHTLITTLE,
		TESTBLUELIGHTON,
		TESTBLUELIGHTLITTLE,
		TESTMIXLIGHTON,
		TESTMIXLIGHTLITTLE,
		ADJUSTLIGHT,
		POWER5V1ON,
		POWER5V1OFF,
		POWER12V1ON,
		POWER12V1OFF,
		POWER24V1ON,
		POWER24V1OFF,
	}
	
	public String make(Instruct instruct) {
		JSONObject commandJson = new JSONObject();
		String type = "";
		String part = "";
		String action = "";

		switch(instruct) {
		case FMLON:
			type = "single";
			part = "front-mid-light";
			action = "on";
			break;
		case FMLOFF:
			type = "single";
			part = "front-mid-light";
			action = "off";
			break;
		case FSLON:
			type = "single";
			part = "light";
			action = "on";
			break;
		case FSLOFF:
			type = "single";
			part = "light";
			action = "off";
			break;
		case CHAIRSTART:
			type = "single";
			part = "chair";
			action = "start";
			break;
		case CHAIRHEADER:
			type = "single";
			part = "chair";
			action = "header";
			break;
		case CHAIRHEADERUP:
			type = "single";
			part = "chair";
			action = "header-up";
			break;
		case CHAIRHEADERDOWN:
			type = "single";
			part = "chair";
			action = "header-down";
			break;
		case CHAIRBACK:
			type = "single";
			part = "chair";
			action = "back";
			break;
		case CHAIRBACKUP:
			type = "single";
			part = "chair";
			action = "back-up";
			break;
		case CHAIRBACKDOWN:
			type = "single";
			part = "chair";
			action = "back-down";
			break;
		case CHAIRHIP:
			type = "single";
			part = "chair";
			action = "hip";
			break;
		case CHAIRHIPUP:
			type = "single";
			part = "chair";
			action = "hip-up";
			break;
		case CHAIRHIPDOWN:
			type = "single";
			part = "chair";
			action = "hip-down";
			break;
		case CHAIRFOOT:
			type = "single";
			part = "chair";
			action = "foot";
			break;
		case CHAIRFOOTUP:
			type = "single";
			part = "chair";
			action = "foot-up";
			break;
		case CHAIRFOOTDOWN:
			type = "single";
			part = "chair";
			action = "foot-down";
			break;
		case CHAIRFOOTLEFT:
			type = "single";
			part = "chair";
			action = "foot-left";
			break;
		case CHAIRFOOTRIGHT:
			type = "single";
			part = "chair";
			action = "foot-right";
			break;
		case CHAIRWAIST:
			type = "single";
			part = "chair";
			action = "waist";
			break;
		case CHAIRWAISTUP:
			type = "single";
			part = "chair";
			action = "waist-up";
			break;
		case CHAIRWAISTDOWN:
			type = "single";
			part = "chair";
			action = "waist-down";
			break;
		case CHAIRWAISTLEFT:
			type = "single";
			part = "chair";
			action = "waist-left";
			break;
		case CHAIRWAISTRIGHT:
			type = "single";
			part = "chair";
			action = "waistright";
			break;
		case CHAIRSTRAIGHT:
			type = "single";
			part = "chair";
			action = "straight";
			break;
		case CHAIRHALFLAYDOWN:
			type = "single";
			part = "chair";
			action = "half-lay-down";
			break;
		case CHAIRLAYDOWN:
			type = "single";
			part = "chair";
			action = "lay-down";
			break;
		case CHAIRSTOP:
			type = "single";
			part = "chair";
			action = "stop";
			break;
		case FRONTDOOROPEN:
			type = "single";
			part = "front-door";
			action = "open";
			break;
		case FRONTDOORCLOSE:
			type = "single";
			part = "front-door";
			action = "close";
			break;
		case FRONTDOORLOCKOPEN:
			type = "single";
			part = "front-door-lock";
			action = "open";
			break;
		case FRONTDOORLOCKCLOSE:
			type = "single";
			part = "front-door-lock";
			action = "close";
			break;
		case TESTLIGHTON:
			type = "single";
			part = "front-mid-light";
			action = "on";
			break;
		case TESTLGITHOFF:
			type = "single";
			part = "front-mid-light";
			action = "off";
			break;
		case TESTREDLIGHTON:
			type = "single";
			part = "front-mid-light";
			action = "red-on";
			break;
		case TESTREDLIGHTLITTLE:
			type = "single";
			part = "front-mid-light";
			action = "red-little";
			break;
		case TESTGREENLIGHTON:
			type = "single";
			part = "front-mid-light";
			action = "green-on";
			break;
		case TESTGREENLIGHTLITTLE:
			type = "single";
			part = "front-mid-light";
			action = "green-little";
			break;
		case TESTBLUELIGHTON:
			type = "single";
			part = "front-mid-light";
			action = "blue-on";
			break;
		case TESTBLUELIGHTLITTLE:
			type = "single";
			part = "front-mid-light";
			action = "blue-little";
			break;
		case TESTMIXLIGHTON:
			type = "single";
			part = "front-mid-light";
			action = "mix-on";
			break;
		case TESTMIXLIGHTLITTLE:
			type = "single";
			part = "front-mid-light";
			action = "mix-little";
			break;
		case POWER5V1ON:
			type = "single";
			part = "power-5v-1";
			action = "on";
			break;
		case POWER5V1OFF:
			type = "single";
			part = "power-5v-1";
			action = "off";
			break;
		case POWER12V1ON:
			type = "single";
			part = "power-12v-1";
			action = "on";
			break;
		case POWER12V1OFF:
			type = "single";
			part = "power-12v-1";
			action = "off";
			break;
		case POWER24V1ON:
			type = "single";
			part = "power-24v-1";
			action = "on";
			break;
		case POWER24V1OFF:
			type = "single";
			part = "power-24v-1";
			action = "off";
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
	
	public String make(Instruct instruct, String value) {
		JSONObject commandJson = new JSONObject();
		String type = "";
		String part = "";
		String action = "";

		switch(instruct) {
		case ADJUSTLIGHT:
			type = "single";
			part = "light-adjust";
			action = value;
			break;
		default:
			break;
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
