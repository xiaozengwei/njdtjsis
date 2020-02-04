package com.roya.mas.platform;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

import org.apache.axis.client.Service;

import com.roya.mas.common.MasConstants;
import com.roya.mas.common.PathUtil;
import com.roya.mas.platform.business.SiMockStub;
import com.roya.mas.platform.schema.location.LocationData;
import com.roya.mas.platform.schema.location.LocationInfo;
import com.roya.mas.platform.schema.ussd.EndUssdRequest;
import com.roya.mas.platform.schema.ussd.HandleUssdResponse;
import com.roya.mas.platform.schema.ussd.UssdArray;
import com.roya.mas.platform.schema.ussd.UssdContinueRequest;
import com.roya.mas.platform.schema.ussd.UssdContinueResponse;

public class SiMock {
	public com.roya.mas.platform.schema.ap.APRegistrationRsp APRegistration(
			com.roya.mas.platform.schema.ap.APRegistrationReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==APRegistration==");
		return null;
	}

	public com.roya.mas.platform.schema.ap.APStatusRepRsp APStatusRep(
			com.roya.mas.platform.schema.ap.APStatusRepReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==APStatusRep==");
		return null;
	}

	public com.roya.mas.platform.schema.ap.APLogOutRsp APLogOut(
			com.roya.mas.platform.schema.ap.APLogOutReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==APLogOut==");
		return null;
	}

	public com.roya.mas.platform.schema.ap.PauseAPRsp pauseAP(
			com.roya.mas.platform.schema.ap.PauseAPReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		
		System.out.println("==pauseAP==");
		return null;
	}

	public com.roya.mas.platform.schema.ap.RecoveryAPRsp recoveryAP(
			com.roya.mas.platform.schema.ap.RecoveryAPReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		
		System.out.println("==recoveryAP==");
		return null;
	}

	public void startNotification(
			com.roya.mas.platform.schema.notification.StartNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==startNotification==");
	}

	public void stopNotification(
			com.roya.mas.platform.schema.notification.StopNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==stopNotification==");
	}

	public com.roya.mas.platform.schema.sms.SendSmsResponse sendSms(
			com.roya.mas.platform.schema.sms.SendSmsRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==sendSms==");
		return null;
	}

	public void notifySmsDeliveryStatus(
			com.roya.mas.platform.schema.sms.NotifySmsDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==notifySmsDeliveryStatus==");
	}

	public com.roya.mas.platform.schema.sms.SMSMessage[] getReceivedSms(
			com.roya.mas.platform.schema.sms.GetReceivedSmsRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getReceivedSms==");
		return null;
	}

	public com.roya.mas.platform.schema.sms.DeliveryInformation[] getSmsDeliveryStatus(
			com.roya.mas.platform.schema.sms.GetSmsDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getSmsDeliveryStatus==");
		return null;
	}

	public void notifySmsReception(
			com.roya.mas.platform.schema.sms.NotifySmsReceptionRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==notifySmsReception==");
		System.out.println(parameter.getMessage().getSenderAddress());
		System.out.println(parameter.getMessage().getMessage());
		System.out.println(parameter.getMessage().getSmsServiceActivationNumber());
		System.out.println(parameter.getMessage().getMessageFormat());
	}

	public com.roya.mas.platform.schema.mms.SendMessageResponse sendMessage(
			com.roya.mas.platform.schema.mms.SendMessageRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==sendMessage==");
		return null;
	}

	public com.roya.mas.platform.schema.mms.DeliveryInformation[] getMessageDeliveryStatus(
			com.roya.mas.platform.schema.mms.GetMessageDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getMessageDeliveryStatus==");
		return null;
	}

	public com.roya.mas.platform.schema.mms.MessageReference[] getReceivedMessages(
			com.roya.mas.platform.schema.mms.GetReceivedMessagesRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getReceivedMessages==");
		return null;
	}

	public com.roya.mas.platform.schema.mms.GetMessageResponse getMessage(
			com.roya.mas.platform.schema.mms.GetMessageRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getMessage==");
		return null;
	}

	public void notifyMessageReception(
			com.roya.mas.platform.schema.mms.NotifyMessageReceptionRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==notifyMessageReception==");
	}

	public void notifyMessageDeliveryReceipt(
			com.roya.mas.platform.schema.mms.NotifyMessageDeliveryReceiptRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==notifyMessageDeliveryReceipt==");
	}

	public com.roya.mas.platform.schema.location.GetLocationResponse getLocation(
			com.roya.mas.platform.schema.location.GetLocationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getLocation==");
		return null;
	}

	public com.roya.mas.platform.schema.location.LocationData[] getLocationForGroup(
			com.roya.mas.platform.schema.location.GetLocationForGroupRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getLocationForGroup==");
		return null;
	}

	public com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse startPeriodicNotification(
			com.roya.mas.platform.schema.location.StartPeriodicNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==startPeriodicNotification==");
		return null;
	}

	public void endNotification(
			com.roya.mas.platform.schema.location.EndNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==endNotification==");
	}

	public void locationNotification(
			com.roya.mas.platform.schema.location.LocationNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("Invoking locationNotification...");
		LocationData[] data = parameter.getData();
		for(int i=0;i<data.length;i++){
			System.out.println(data[i].getReportStatus().getValue());
			System.out.println(data[i].getErrorInformation().getText());
			LocationInfo l = data[i].getCurrentLocation();
			System.out.println(l.getAccuracy());
			System.out.println(l.getAltitude());
			System.out.println(l.getLatitude());
			System.out.println(l.getLongitude());
			System.out.println("");
		}
	}

	public void locationError(
			com.roya.mas.platform.schema.location.LocationErrorRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("Invoking locationError...");
	}

	public void locationEnd(
			com.roya.mas.platform.schema.location.LocationEndRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("Invoking locationEnd...");
	}

	public com.roya.mas.platform.schema.wap.SendPushResponse sendPush(
			com.roya.mas.platform.schema.wap.SendPushRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==sendPush==");
		return null;
	}

	public com.roya.mas.platform.schema.wap.DeliveryInformation[] getPushDeliveryStatus(
			com.roya.mas.platform.schema.wap.GetPushDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==getPushDeliveryStatus==");
		return null;
	}

	public void notifyPushDeliveryReceipt(
			com.roya.mas.platform.schema.wap.NotifyPushDeliveryReceiptRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		
		System.out.println(parameter.getDeliveryStatus(0).getStatus().toString());
	}

	public com.roya.mas.platform.schema.ussd.MakeUssdResponse makeUssd(
			com.roya.mas.platform.schema.ussd.MakeUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==makeUssd==");
		return null;
	}

	public com.roya.mas.platform.schema.ussd.HandleUssdResponse handleUssd(
			com.roya.mas.platform.schema.ussd.HandleUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		System.out.println("==handleUssd==");
		MasConstants.order = new StringBuffer("m");
		String globalFile="";
		String configFIle="";
		Properties global = new Properties();
		Properties props = new Properties();
		globalFile = PathUtil.getRootPath()+"../test/global.properties";
		configFIle = PathUtil.getRootPath()+"../test/ussd/UssdContinue.properties";
		InputStream in;
		try {
			in = new FileInputStream(configFIle);
			props.load(in);
			InputStream globalin = new FileInputStream(globalFile);
			global.load(globalin);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HandleUssdResponse rsp = new HandleUssdResponse();
		UssdArray array = new UssdArray();
		String message = props.getProperty(MasConstants.order.toString());
		
		try {
			System.out.println(new String(message.getBytes("ISO-8859-1"),"utf-8"));
			array.setUssdMessage(new String(message.getBytes("ISO-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		array.setUssdReturnRequest(Boolean.valueOf(props.getProperty("UssdReturnRequest")));
		rsp.setResult(array);
		return rsp;
	}

	public com.roya.mas.platform.schema.ussd.UssdContinueResponse ussdContinue(
			com.roya.mas.platform.schema.ussd.UssdContinueRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		UssdContinueResponse rsp = new UssdContinueResponse();
		System.out.println("==ussdContinue==");
		String globalFile="";
		String configFIle="";
		Properties global = new Properties();
		Properties props = new Properties();
		globalFile = PathUtil.getRootPath()+"../test/global.properties";
		configFIle = PathUtil.getRootPath()+"../test/ussd/UssdContinue.properties";
		InputStream in;
		try {
			in = new FileInputStream(configFIle);
			props.load(in);
			InputStream globalin = new FileInputStream(globalFile);
			global.load(globalin);			
			
			
			URL url = new URL(global.getProperty("MasWsUrl"));
			Service service = new Service();
			SiMockStub stub = new SiMockStub(url, service);
			
			
			
			UssdContinueRequest req1 = new UssdContinueRequest();
			
			UssdArray array = new UssdArray();
			String reqMessage= parameter.getUssdMessage().getUssdMessage();
			String UssdIdentifie = parameter.getUssdIdentifier();
			System.out.println("UssdIdentifie="+UssdIdentifie);
			req1.setUssdIdentifier(UssdIdentifie);
			
			String p_order = reqMessage.substring(0,1);
			
			if(!"9".equals(p_order)){
				//首先记录USSD级别
				if("0".equals(p_order)){
					//直接在主菜单，发送0指令
					if(MasConstants.order.length() == 1){
						setUssdArray(props, array, MasConstants.order.toString());
					}
					else{
						MasConstants.order.deleteCharAt(MasConstants.order.length()-1);
						setUssdArray(props, array, MasConstants.order.toString());
					}
				}
				else{
					MasConstants.order.append(p_order);
					String message = props.getProperty(MasConstants.order.toString());
		
					if(message != null && !"".equals(message)){
						setUssdArray(props, array, MasConstants.order.toString());
					}
					else{
						MasConstants.order.deleteCharAt(MasConstants.order.length()-1);
						setUssdArray(props, array, MasConstants.order.toString());
					}
				}
				
				array.setUssdReturnRequest(Boolean.valueOf(props.getProperty("UssdReturnRequest")));
				req1.setUssdMessage(array);
				stub.ussdContinue(req1);
			}
			else{
				configFIle = PathUtil.getRootPath()+"../test/ussd/EndUssd.properties";
				in = new FileInputStream(configFIle);
				props.load(in);
				EndUssdRequest req = new EndUssdRequest();
				req.setApplicationID(props.getProperty("ApplicationID"));
				req.setUssdIdentifier(UssdIdentifie);
				String ussdMessage = props.getProperty("UssdMessage");
				req.setUssdMessage(new String(ussdMessage.getBytes("ISO-8859-1"),"utf-8"));
				stub.endUssd(req);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		return null;
	}

	private void setUssdArray(Properties props, UssdArray array, String order) throws Exception{
		String message = props.getProperty(order);
		array.setUssdMessage(new String(message.getBytes("ISO-8859-1"),"utf-8"));
	}
	
	public void endUssd(
			com.roya.mas.platform.schema.ussd.EndUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		MasConstants.order = new StringBuffer("m");
		System.out.println("==endUssd==");
	}

	public void notifyUssdEnd(
			com.roya.mas.platform.schema.ussd.NotifyUssdEndRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		MasConstants.order = new StringBuffer("m");
		System.out.println("==notifyUssdEnd==");
	}

}
