package com.sohu.nanohttpd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NanoHTTPD nanoHttpd = new MyNanoHTTPD("127.0.0.1",23456);
		try{
			nanoHttpd.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Log.e("DEMO",nanoHttpd.isAlive()+"");
		
	}

}

class MyNanoHTTPD extends NanoHTTPD{

	public MyNanoHTTPD(int port) {
		super(port);
	}
	
	public MyNanoHTTPD(String hostName,int port){
		super(hostName,port);
	}
	
	 public Response serve(IHTTPSession session) { 
		 Method method = session.getMethod();
		 Log.e("DEMO","Method:"+method.toString());
		 if(NanoHTTPD.Method.GET.equals(method)){
			 //get方式
			 String queryParams = session.getQueryParameterString();
			 Log.e("DEMO","params:"+queryParams);
		 }else if(NanoHTTPD.Method.POST.equals(method)){
			 //post方式
		 }
		 return super.serve(session);
	 }
	
	
}
