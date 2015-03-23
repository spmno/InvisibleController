package com.mxnavi.invisiblecontroller;

import org.json.JSONException;
import org.json.JSONObject;

public class CommandMaker {
	static final String END_COMMAND_SIGN = "\n";
	enum Instruct {
		FMTWINKLE,
		FMONGRADUALLY,
		FMLON,								//前中灯开
		FMLOFF,								//前中灯关
		HLTWINKLE,
		HLONGRADUALLY,
		HLON,								
		HLOFF,		
		DRTWINKLE,
		DRONGRADUALLY,
		DRON,								
		DROFF,	
		BMTWINKLE,
		BMONGRADUALLY,
		BMLON,								
		BMLOFF,	
		BSTWINKLE,
		BSONGRADUALLY,
		BSLON,								
		BSLOFF,	
		BLTWINKLE,
		BLONGRADUALLY,
		BLLON,								
		BLLOFF,	
		CHAIRSTART,							//椅子启动
		CHAIRHEADER,						//椅子头部调节
		CHAIRHEADERUP,						//椅子头部向上
		CHAIRHEADERDOWN,					//椅子头部向下
		CHAIRBACK,							//椅子背部调节
		CHAIRBACKUP,						//椅子背部向上
		CHAIRBACKDOWN,						//椅子背部向下
		CHAIRHIP,							//椅子臀部调节
		CHAIRHIPUP,							//椅子臀部向上
		CHAIRHIPDOWN,						//椅子臀部向下
		CHAIRFOOT,							//椅子脚部
		CHAIRFOOTUP,						//椅子脚部向上
		CHAIRFOOTDOWN,						//椅子脚部向下
		CHAIRFOOTLEFT,						//椅子脚部向左
		CHAIRFOOTRIGHT,						//椅子脚部向右
		CHAIRWAIST,							//椅子腰部
		CHAIRWAISTUP,						//椅子腰部向上
		CHAIRWAISTDOWN,						//椅子腰部向下
		CHAIRWAISTLEFT,						//椅子腰部向左
		CHAIRWAISTRIGHT,					//椅子腰部向右
		DRIVERCHAIRSTRAIGHT,						
		DRIVERCHAIRHALFLAYDOWN,
		DRIVERCHAIRLAYDOWN,
		DRIVERCHAIRSTOP,
		CODRIVERCHAIRSTRAIGHT,						
		CODRIVERCHAIRHALFLAYDOWN,
		CODRIVERCHAIRLAYDOWN,
		CODRIVERCHAIRSTOP,
		DRIVERCHAIRZ1,
		DRIVERCHAIRZ2,
		DRIVERCHAIRZ3,
		CODRIVERCHAIRZ1,
		CODRIVERCHAIRZ2,
		CODRIVERCHAIRZ3,
		IRISDOOROPEN,
		IRISDOORCLOSE,
		IRISDOORSTOP,
		FRONTDOOROPEN,
		FRONTDOORCLOSE,
		FRONTDOORSTOP,
		BACKDOOROPEN,
		BACKDOORCLOSE,
		BACKDOORSTOP,
		TAILDOOROPEN,
		TAILDOORCLOSE,
		TAILDOORSTOP,
		I1,
		I2,
		F1,
		F2,
		B1,
		B2,
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
		IRISPANELON,
		IRISPANELOFF,
		IRISPANELSTOP,
		IRISPANELRESET,
		FRONTWINDOWSHEETINGON,
		FRONTWINDOWSHEETINGOFF,
		SKYLIGHTSHEETINGON,
		SKYLIGHTSHEETINGOFF,
		LEFTWINDOWSHEETINGON,
		LEFTWINDOWSHEETINGOFF,
		RIGHTWINDOWSHEETINGON,
		RIGHTWINDOWSHEETINGOFF,
		BACKWINDOWSHEETINGON,
		BACKWINDOWSHEETINGOFF,
		RELAY3ON,
		RELAY3OFF,
		RELAY4ON,
		RELAY4OFF,
		MEDIAPLAY,
		MEDIASTOP,
		MEDIAPAUSE,
		RESET,
		NEARTHECAR,
		BACKSCREENSHOW,
		OPENAIR,							
		OPENTHEDOOR,						//开门模式
		CLOSETHEDOOR,						//关门模式
		DRIVING,							//驾驶模式
		AUTODRIVING,						//自动驾驶模式
		
	}
	
	public String make(Instruct instruct) {
		JSONObject commandJson = new JSONObject();
		String type = "";
		String part = "";
		String action = "";

		switch(instruct) {
		case FMTWINKLE:
			type = "single";
			part = "front-mid-light";
			action = "twinkle";
			break;
		case FMONGRADUALLY:
			type = "single";
			part = "front-mid-light";
			action = "on-gradually";
			break;
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
		case HLTWINKLE:
			type = "single";
			part = "head-light";
			action = "twinkle";
			break;
		case HLONGRADUALLY:
			type = "single";
			part = "head-light";
			action = "on-gradually";
		case HLON:
			type = "single";
			part = "head-light";
			action = "on";
			break;
		case HLOFF:
			type = "single";
			part = "head-light";
			action = "off";
			break;
		case DRTWINKLE:
			type = "single";
			part = "daytime-running-light";
			action = "twinkle";
			break;
		case DRONGRADUALLY:
			type = "single";
			part = "daytime-running-light";
			action = "on-gradually";
			break;
		case DRON:
			type = "single";
			part = "daytime-running-light";
			action = "on";
			break;
		case DROFF:
			type = "single";
			part = "daytime-running-light";
			action = "off";
			break;
		case BMTWINKLE:
			type = "single";
			part = "back-mid-light";
			action = "twinkle";
			break;
		case BMONGRADUALLY:
			type = "single";
			part = "back-mid-light";
			action = "on-gradually";
			break;
		case BMLON:
			type = "single";
			part = "back-mid-light";
			action = "on";
			break;
		case BMLOFF:
			type = "single";
			part = "back-mid-light";
			action = "off";
			break;
		case BSTWINKLE:
			type = "single";
			part = "back-side-light";
			action = "twinkle";
			break;
		case BSONGRADUALLY:
			type = "single";
			part = "back-side-light";
			action = "on-gradually";
			break;
		case BSLON:
			type = "single";
			part = "back-side-light";
			action = "on";
			break;
		case BSLOFF:
			type = "single";
			part = "back-side-light";
			action = "off";
			break;
		case BLTWINKLE:
			type = "single";
			part = "back-logo-light";
			action = "twinkle";
			break;
		case BLONGRADUALLY:
			type = "single";
			part = "back-logo-light";
			action = "on-gradually";
			break;
		case BLLON:
			type = "single";
			part = "back-logo-light";
			action = "on";
			break;
		case BLLOFF:
			type = "single";
			part = "back-logo-light";
			action = "off";
			break;
		case CHAIRSTART:
			type = "single";
			part = "driver-seat";
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
		case DRIVERCHAIRSTRAIGHT:
			type = "single";
			part = "driver-seat";
			action = "driving";
			break;
		case DRIVERCHAIRHALFLAYDOWN:
			type = "single";
			part = "driver-seat";
			action = "leisure";
			break;
		case DRIVERCHAIRLAYDOWN:
			type = "single";
			part = "driver-seat";
			action = "sleep";
			break;
		case DRIVERCHAIRSTOP:
			type = "single";
			part = "driver-seat";
			action = "stop";
			break;
		case CODRIVERCHAIRSTRAIGHT:
			type = "single";
			part = "co-driver-seat";
			action = "driving";
			break;
		case CODRIVERCHAIRHALFLAYDOWN:
			type = "single";
			part = "co-driver-seat";
			action = "leisure";
			break;
		case CODRIVERCHAIRLAYDOWN:
			type = "single";
			part = "co-driver-seat";
			action = "sheep";
			break;
		case CODRIVERCHAIRSTOP:
			type = "single";
			part = "co-driver-seat";
			action = "stop";
			break;
		case DRIVERCHAIRZ1:
			type = "single";
			part = "driver-seat-motor";
			action = "z1";
			break;
		case DRIVERCHAIRZ2:
			type = "single";
			part = "driver-seat-motor";
			action = "z2";
			break;
		case DRIVERCHAIRZ3:
			type = "single";
			part = "driver-seat-motor";
			action = "z3";
			break;
		case CODRIVERCHAIRZ1:
			type = "single";
			part = "co-driver-seat-motor";
			action = "z1";
			break;
		case CODRIVERCHAIRZ2:
			type = "single";
			part = "co-driver-seat-motor";
			action = "z2";
			break;
		case CODRIVERCHAIRZ3:
			type = "single";
			part = "co-driver-seat-motor";
			action = "z3";
			break;
		case IRISDOOROPEN:
			type = "single";
			part = "iris-door";
			action = "open";
			break;
		case IRISDOORCLOSE:
			type = "single";
			part = "iris-door";
			action = "close";
			break;
		case IRISDOORSTOP:
			type = "single";
			part = "iris-door";
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
		case FRONTDOORSTOP:
			type = "single";
			part = "front-door";
			action = "stop";
			break;
		case BACKDOOROPEN:
			type = "single";
			part = "back-door";
			action = "open";
			break;
		case BACKDOORCLOSE:
			type = "single";
			part = "back-door";
			action = "close";
			break;
		case BACKDOORSTOP:
			type = "single";
			part = "back-door";
			action = "stop";
			break;
		case TAILDOOROPEN:
			type = "single";
			part = "tail-door";
			action = "open";
			break;
		case TAILDOORCLOSE:
			type = "single";
			part = "tail-door";
			action = "close";
			break;
		case TAILDOORSTOP:
			type = "single";
			part = "tail-door";
			action = "stop";
			break;
		case I1:
			type = "single";
			part = "ip";
			action = "i1";
			break;
		case I2:
			type = "single";
			part = "ip";
			action = "i2";
			break;
		case F1:
			type = "single";
			part = "wheel";
			action = "f1";
			break;
		case F2:
			type = "single";
			part = "wheel";
			action = "f2";
			break;
		case B1:
			type = "single";
			part = "wheel-handle";
			action = "b1";
			break;
		case B2:
			type = "single";
			part = "wheel-handle";
			action = "b2";
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
		case IRISPANELON:
			type = "single";
			part = "iris-door";
			action = "open";
			break;
		case IRISPANELOFF:
			type = "single";
			part = "iris-door";
			action = "close";
			break;
		case IRISPANELSTOP:
			type = "single";
			part = "iris-door";
			action = "stop";
			break;
		case IRISPANELRESET:
			type = "single";
			part = "iris-door";
			action = "reset";
			break;
		case FRONTWINDOWSHEETINGON:
			type = "single";
			part = "front-window-sheeting";
			action = "on";
			break;
		case FRONTWINDOWSHEETINGOFF:
			type = "single";
			part = "front-window-sheeting";
			action = "off";
			break;
		case SKYLIGHTSHEETINGON:
			type = "single";
			part = "sky-light-sheeting";
			action = "on";
			break;
		case SKYLIGHTSHEETINGOFF:
			type = "single";
			part = "sky-light-sheeting";
			action = "off";
			break;
		case LEFTWINDOWSHEETINGON:
			type = "single";
			part = "left-window-sheeting";
			action = "on";
			break;
		case LEFTWINDOWSHEETINGOFF:
			type = "single";
			part = "left-window-sheeting";
			action = "off";
			break;
		case RIGHTWINDOWSHEETINGON:
			type = "single";
			part = "right-window-sheet";
			action = "on";
			break;
		case RIGHTWINDOWSHEETINGOFF:
			type = "single";
			part = "right-window-sheet";
			action = "off";
			break;
		case BACKWINDOWSHEETINGON:
			type = "single";
			part = "back-window-sheeting";
			action = "on";
			break;
		case BACKWINDOWSHEETINGOFF:
			type = "single";
			part = "back-window-sheeting";
			action = "off";
			break;
		case RELAY3ON:
			type = "single";
			part = "relay3";
			action = "on1";
			break;
		case RELAY3OFF:
			type = "single";
			part = "relay3";
			action = "off1";
			break;
		case RELAY4ON:
			type = "single";
			part = "relay3";
			action = "on2";
			break;
		case RELAY4OFF:
			type = "single";
			part = "relay3";
			action = "off2";
			break;
		case MEDIAPLAY:
			type = "single";
			part = "media-player";
			action = "play";
			break;
		case MEDIASTOP:
			type = "single";
			part = "media-player";
			action = "stop";
			break;
		case MEDIAPAUSE:
			type = "single";
			part = "media-player";
			action = "pause";
			break;
		case RESET:
			type = "mode";
			part = "all";
			action = "reset";
			break;
		case NEARTHECAR:
			type = "mode";
			part = "all";
			action = "near-the-car";
			break;
		case BACKSCREENSHOW:
			type = "mode";
			part = "all";
			action = "back-screen-show";
			break;
		case OPENAIR:
			type = "mode";
			part = "all";
			action = "open-air";
			break;
		case OPENTHEDOOR:
			type = "mode";
			part = "all";
			action = "open-the-door";
			break;
		case CLOSETHEDOOR:
			type = "mode";
			part = "all";
			action = "close-the-door";
			break;
		case DRIVING:
			type = "mode";
			part = "all";
			action = "driving";
			break;
		case AUTODRIVING:
			type = "mode";
			part = "all";
			action = "auto-driving";
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
	
	public String make(Instruct instruct, int id, int red, int green, int blue, int bright) {
		JSONObject commandJson = new JSONObject();
		String type = "";
		String part = "";
		String action = "";

		switch(instruct) {
		case ADJUSTLIGHT:
			type = "single";
			part = "side-atmosphere-light";
			action = String.format("%d:%d:%d:%d:%d:%d", id, 0, red, green, blue, bright);
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
