package com.gx.soft.sms.ws;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.axis.client.Service;
import org.apache.axis.description.TypeDesc;
import com.roya.mas.platform.business.SiMockStub;
import com.roya.mas.platform.schema.sms.MessageFormat;
import com.roya.mas.platform.schema.sms.SendMethodType;
import com.roya.mas.platform.schema.sms.SendSmsRequest;
import com.roya.mas.platform.schema.sms.SendSmsResponse;


public class SendSMS extends  Thread
{
	private String phone;
	private String msg;
	
	
	public SendSMS(String phone,String msg){
		this.phone =phone;
		this.msg = msg;
	}
    public void run()
    {
			  String requestIdentifier = "";
			  TypeDesc returnMsg ;
			  URL url;



		  	  ResourceBundle bundle1 = ResourceBundle.getBundle("smsconfig");

		try{
			url = new URL(bundle1.getString("sms.server"));
			Service service = new Service();
			SiMockStub stub = new SiMockStub(url, service);
			SendSmsRequest s = new SendSmsRequest();
			s.setApplicationID(bundle1.getString("sms.appid"));
			s.setDeliveryResultRequest(true);
			s.setExtendCode("123456");
			s.setMessage(msg);
			s.setMessageFormat(MessageFormat.fromValue("GB2312"));
			s.setSendMethod(SendMethodType.fromValue("Normal"));
			String addr ="tel:"+phone;
			String[] a = addr.split(";");
			int leng= a.length;
			org.apache.axis.types.URI [] ary=new org.apache.axis.types.URI[leng];
			for(int i=0;i<leng;i++){
				org.apache.axis.types.URI temp=new org.apache.axis.types.URI(a[i]);
				ary[i]=temp;
			}
			s.setDestinationAddresses(ary);
			System.out.println("there is sending sms:"+msg);
			SendSmsResponse rep = stub.sendSms(s);
			requestIdentifier = rep.getRequestIdentifier();
			returnMsg = rep.getTypeDesc();
			System.out.println("短信接口返回ID="+requestIdentifier);
			System.out.println("短信接口返回信息="+returnMsg);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("requestIdentifier="+requestIdentifier);
			System.out.println("调用短信接口出现异常！");
		}
    }


}
