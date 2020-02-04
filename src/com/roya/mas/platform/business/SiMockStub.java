/**
 * Cmcc_mas_wbsSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roya.mas.platform.business;

public class SiMockStub extends org.apache.axis.client.Stub {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[33];
		_initOperationDesc1();
		_initOperationDesc2();
		_initOperationDesc3();
		_initOperationDesc4();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("APRegistration");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						"APRegistrationReq"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						">APRegistrationReq"),
				com.roya.mas.platform.schema.ap.APRegistrationReq.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", ">APRegistrationRsp"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ap.APRegistrationRsp.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", "APRegistrationRsp"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("APStatusRep");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						"APStatusRepReq"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						">APStatusRepReq"),
				com.roya.mas.platform.schema.ap.APStatusRepReq.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", ">APStatusRepRsp"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ap.APStatusRepRsp.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", "APStatusRepRsp"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("APLogOut");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						"APLogOutReq"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						">APLogOutReq"),
				com.roya.mas.platform.schema.ap.APLogOutReq.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", ">APLogOutRsp"));
		oper.setReturnClass(com.roya.mas.platform.schema.ap.APLogOutRsp.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", "APLogOutRsp"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("PauseAP");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						"PauseAPReq"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						">PauseAPReq"),
				com.roya.mas.platform.schema.ap.PauseAPReq.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", ">PauseAPRsp"));
		oper.setReturnClass(com.roya.mas.platform.schema.ap.PauseAPRsp.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", "PauseAPRsp"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("RecoveryAP");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						"RecoveryAPReq"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
						">RecoveryAPReq"),
				com.roya.mas.platform.schema.ap.RecoveryAPReq.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", ">RecoveryAPRsp"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ap.RecoveryAPRsp.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ap", "RecoveryAPRsp"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("startNotification");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/notification",
						"startNotificationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/notification",
						">startNotificationRequest"),
				com.roya.mas.platform.schema.notification.StartNotificationRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("stopNotification");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/notification",
						"stopNotificationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/notification",
						">stopNotificationRequest"),
				com.roya.mas.platform.schema.notification.StopNotificationRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("sendSms");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms", "sendSmsRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms", ">sendSmsRequest"),
				com.roya.mas.platform.schema.sms.SendSmsRequest.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">sendSmsResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.sms.SendSmsResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "sendSmsResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifySmsDeliveryStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						"notifySmsDeliveryStatusRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						">notifySmsDeliveryStatusRequest"),
				com.roya.mas.platform.schema.sms.NotifySmsDeliveryStatusRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("GetReceivedSms");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						"GetReceivedSmsRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						">GetReceivedSmsRequest"),
				com.roya.mas.platform.schema.sms.GetReceivedSmsRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">GetReceivedSmsResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.sms.SMSMessage[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "GetReceivedSmsResponse"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "ReceivedSms"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[9] = oper;

	}

	private static void _initOperationDesc2() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("GetSmsDeliveryStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						"GetSmsDeliveryStatusRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						">GetSmsDeliveryStatusRequest"),
				com.roya.mas.platform.schema.sms.GetSmsDeliveryStatusRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms",
				">GetSmsDeliveryStatusResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.sms.DeliveryInformation[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms",
				"GetSmsDeliveryStatusResponse"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "DeliveryStatus"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[10] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifySmsReception");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						"notifySmsReceptionRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/sms",
						">notifySmsReceptionRequest"),
				com.roya.mas.platform.schema.sms.NotifySmsReceptionRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[11] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("sendMessage");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms", "sendMessageRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						">sendMessageRequest"),
				com.roya.mas.platform.schema.mms.SendMessageRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">sendMessageResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.mms.SendMessageResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "sendMessageResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[12] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getMessageDeliveryStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						"getMessageDeliveryStatusRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						">getMessageDeliveryStatusRequest"),
				com.roya.mas.platform.schema.mms.GetMessageDeliveryStatusRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getMessageDeliveryStatusResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.mms.DeliveryInformation[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				"getMessageDeliveryStatusResponse"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "result"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[13] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getReceivedMessages");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						"getReceivedMessagesRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						">getReceivedMessagesRequest"),
				com.roya.mas.platform.schema.mms.GetReceivedMessagesRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getReceivedMessagesResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.mms.MessageReference[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				"getReceivedMessagesResponse"));
		param = oper.getReturnParamDesc();
		param
				.setItemQName(new javax.xml.namespace.QName("",
						"receivedMessage"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[14] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getMessage");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms", "getMessageRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms", ">getMessageRequest"),
				com.roya.mas.platform.schema.mms.GetMessageRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">getMessageResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.mms.GetMessageResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "getMessageResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[15] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifyMessageReception");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						"notifyMessageReceptionRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						">notifyMessageReceptionRequest"),
				com.roya.mas.platform.schema.mms.NotifyMessageReceptionRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[16] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifyMessageDeliveryReceipt");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						"notifyMessageDeliveryReceiptRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/mms",
						">notifyMessageDeliveryReceiptRequest"),
				com.roya.mas.platform.schema.mms.NotifyMessageDeliveryReceiptRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[17] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getLocation");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"getLocationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">getLocationRequest"),
				com.roya.mas.platform.schema.location.GetLocationRequest.class,
				false, false);
		oper.addParameter(param);
		oper
				.setReturnType(new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">getLocationResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.location.GetLocationResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "getLocationResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[18] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getLocationForGroup");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"getLocationForGroupRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">getLocationForGroupRequest"),
				com.roya.mas.platform.schema.location.GetLocationForGroupRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">getLocationForGroupResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.location.LocationData[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				"getLocationForGroupResponse"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "Result"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[19] = oper;

	}

	private static void _initOperationDesc3() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("startPeriodicNotification");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"startPeriodicNotificationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">startPeriodicNotificationRequest"),
				com.roya.mas.platform.schema.location.StartPeriodicNotificationRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">startPeriodicNotificationResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				"startPeriodicNotificationResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[20] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("EndNotification");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"EndNotificationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">EndNotificationRequest"),
				com.roya.mas.platform.schema.location.EndNotificationRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[21] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("LocationNotification");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"LocationNotificationRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">LocationNotificationRequest"),
				com.roya.mas.platform.schema.location.LocationNotificationRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[22] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("LocationError");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"LocationErrorRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">LocationErrorRequest"),
				com.roya.mas.platform.schema.location.LocationErrorRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[23] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("LocationEnd");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						"LocationEndRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/location",
						">LocationEndRequest"),
				com.roya.mas.platform.schema.location.LocationEndRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[24] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("sendPush");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap", "sendPushRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap", ">sendPushRequest"),
				com.roya.mas.platform.schema.wap.SendPushRequest.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", ">sendPushResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.wap.SendPushResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", "sendPushResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[25] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getPushDeliveryStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap",
						"getPushDeliveryStatusRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap",
						">getPushDeliveryStatusRequest"),
				com.roya.mas.platform.schema.wap.GetPushDeliveryStatusRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap",
				">getPushDeliveryStatusResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.wap.DeliveryInformation[].class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap",
				"getPushDeliveryStatusResponse"));
		param = oper.getReturnParamDesc();
		param.setItemQName(new javax.xml.namespace.QName("", "result"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[26] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifyPushDeliveryReceipt");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap",
						"notifyPushDeliveryReceiptRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/wap",
						">notifyPushDeliveryReceiptRequest"),
				com.roya.mas.platform.schema.wap.NotifyPushDeliveryReceiptRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[27] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("makeUssd");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd", "makeUssdRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd", ">makeUssdRequest"),
				com.roya.mas.platform.schema.ussd.MakeUssdRequest.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">makeUssdResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ussd.MakeUssdResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", "makeUssdResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[28] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("handleUssd");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd", "handleUssdRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd",
						">handleUssdRequest"),
				com.roya.mas.platform.schema.ussd.HandleUssdRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">handleUssdResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ussd.HandleUssdResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", "handleUssdResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[29] = oper;

	}

	private static void _initOperationDesc4() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("ussdContinue");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd",
						"ussdContinueRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd",
						">ussdContinueRequest"),
				com.roya.mas.platform.schema.ussd.UssdContinueRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">ussdContinueResponse"));
		oper
				.setReturnClass(com.roya.mas.platform.schema.ussd.UssdContinueResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", "ussdContinueResponse"));
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[30] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("endUssd");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd", "endUssdRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd", ">endUssdRequest"),
				com.roya.mas.platform.schema.ussd.EndUssdRequest.class, false,
				false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[31] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("notifyUssdEnd");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd",
						"notifyUssdEndRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/ussd",
						">notifyUssdEndRequest"),
				com.roya.mas.platform.schema.ussd.NotifyUssdEndRequest.class,
				false, false);
		oper.addParameter(param);
		oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
		oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"),
				"com.roya.mas.platform.schema.common.v2_0.PolicyException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"PolicyException"), true));
		oper.addFault(new org.apache.axis.description.FaultDesc(
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"),
				"com.roya.mas.platform.schema.common.v2_0.ServiceException",
				new javax.xml.namespace.QName(
						"http://www.csapi.org/schema/common/v2_0",
						"ServiceException"), true));
		_operations[32] = oper;

	}

	public SiMockStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public SiMockStub(java.net.URL endpointURL, javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public SiMockStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		javax.xml.namespace.QName qName2;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APLogOutReq");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APLogOutReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APLogOutRsp");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APLogOutRsp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APRegistrationReq");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APRegistrationReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APRegistrationRsp");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APRegistrationRsp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APStatusRepReq");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APStatusRepReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">APStatusRepRsp");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APStatusRepRsp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">PauseAPReq");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.PauseAPReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">PauseAPRsp");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.PauseAPRsp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">RecoveryAPReq");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.RecoveryAPReq.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				">RecoveryAPRsp");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.RecoveryAPRsp.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				"APLogoutResult");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APLogoutResult.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				"APRegResult");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APRegResult.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap",
				"APStatusType");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ap.APStatusType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "CMAbility");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.CMAbility.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0",
				"MessageNotificationType");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.MessageNotificationType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "PolicyException");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.PolicyException.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "ServiceError");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.ServiceError.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "ServiceException");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.ServiceException.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "TimeMetric");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.TimeMetric.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/common/v2_0", "TimeMetricsValues");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.common.v2_0.TimeMetricsValues.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">EndNotificationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.EndNotificationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">getLocationForGroupRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.GetLocationForGroupRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">getLocationForGroupResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationData[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "LocationData");
		qName2 = new javax.xml.namespace.QName("", "Result");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", ">getLocationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.GetLocationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", ">getLocationResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.GetLocationResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", ">LocationEndRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationEndRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", ">LocationErrorRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationErrorRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">LocationNotificationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationNotificationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">startPeriodicNotificationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.StartPeriodicNotificationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				">startPeriodicNotificationResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location",
				"CoordinateReferenceSystem");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.CoordinateReferenceSystem.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "DelayTolerance");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.DelayTolerance.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "LocationData");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationData.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "LocationInfo");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocationInfo.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "LocType");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.LocType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "Priority");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.Priority.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "RetrievalStatus");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.RetrievalStatus.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/location", "ServiceType");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.location.ServiceType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getMessageDeliveryStatusRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.GetMessageDeliveryStatusRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getMessageDeliveryStatusResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.DeliveryInformation[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "DeliveryInformation");
		qName2 = new javax.xml.namespace.QName("", "result");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">getMessageRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.GetMessageRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">getMessageResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.GetMessageResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getReceivedMessagesRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.GetReceivedMessagesRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">getReceivedMessagesResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.MessageReference[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "MessageReference");
		qName2 = new javax.xml.namespace.QName("", "receivedMessage");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">notifyMessageDeliveryReceiptRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.NotifyMessageDeliveryReceiptRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms",
				">notifyMessageReceptionRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.NotifyMessageReceptionRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">sendMessageRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.SendMessageRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", ">sendMessageResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.SendMessageResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "DeliveryInformation");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.DeliveryInformation.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "DeliveryStatus");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.DeliveryStatus.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "MessagePriority");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.MessagePriority.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "MessageReference");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.MessageReference.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/mms", "MmsMessage");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.mms.MmsMessage.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/notification",
				">startNotificationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.notification.StartNotificationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/notification",
				">stopNotificationRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.notification.StopNotificationRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">GetReceivedSmsRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.GetReceivedSmsRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">GetReceivedSmsResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.SMSMessage[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "SMSMessage");
		qName2 = new javax.xml.namespace.QName("", "ReceivedSms");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms",
				">GetSmsDeliveryStatusRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.GetSmsDeliveryStatusRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms",
				">GetSmsDeliveryStatusResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.DeliveryInformation[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "DeliveryInformation");
		qName2 = new javax.xml.namespace.QName("", "DeliveryStatus");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms",
				">notifySmsDeliveryStatusRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.NotifySmsDeliveryStatusRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">notifySmsReceptionRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.NotifySmsReceptionRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">sendSmsRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.SendSmsRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", ">sendSmsResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.SendSmsResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "DeliveryInformation");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.DeliveryInformation.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "DeliveryStatus");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.DeliveryStatus.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "MessageFormat");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.MessageFormat.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "SendMethodType");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.SendMethodType.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/sms", "SMSMessage");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.sms.SMSMessage.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">endUssdRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.EndUssdRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">handleUssdRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.HandleUssdRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">handleUssdResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.HandleUssdResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">makeUssdRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.MakeUssdRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">makeUssdResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.MakeUssdResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">notifyUssdEndRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.NotifyUssdEndRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">ussdContinueRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.UssdContinueRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", ">ussdContinueResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.UssdContinueResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", "EndReason");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.EndReason.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/ussd", "UssdArray");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.ussd.UssdArray.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap",
				">getPushDeliveryStatusRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.GetPushDeliveryStatusRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap",
				">getPushDeliveryStatusResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.DeliveryInformation[].class;
		cachedSerClasses.add(cls);
		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", "DeliveryInformation");
		qName2 = new javax.xml.namespace.QName("", "result");
		cachedSerFactories
				.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(
						qName, qName2));
		cachedDeserFactories
				.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap",
				">notifyPushDeliveryReceiptRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.NotifyPushDeliveryReceiptRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", ">sendPushRequest");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.SendPushRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", ">sendPushResponse");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.SendPushResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", "DeliveryInformation");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.DeliveryInformation.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"http://www.csapi.org/schema/wap", "DeliveryStatus");
		cachedSerQNames.add(qName);
		cls = com.roya.mas.platform.schema.wap.DeliveryStatus.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(enumsf);
		cachedDeserFactories.add(enumdf);

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public com.roya.mas.platform.schema.ap.APRegistrationRsp APRegistration(
			com.roya.mas.platform.schema.ap.APRegistrationReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/APRegistration");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"APRegistration"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ap.APRegistrationRsp) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ap.APRegistrationRsp) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ap.APRegistrationRsp.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ap.APStatusRepRsp APStatusRep(
			com.roya.mas.platform.schema.ap.APStatusRepReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/APStatusRep");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName("",
						"APStatusRep"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ap.APStatusRepRsp) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ap.APStatusRepRsp) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ap.APStatusRepRsp.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ap.APLogOutRsp APLogOut(
			com.roya.mas.platform.schema.ap.APLogOutReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/APLogOut");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "APLogOut"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ap.APLogOutRsp) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ap.APLogOutRsp) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ap.APLogOutRsp.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ap.PauseAPRsp pauseAP(
			com.roya.mas.platform.schema.ap.PauseAPReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/PauseAP");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "PauseAP"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ap.PauseAPRsp) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ap.PauseAPRsp) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ap.PauseAPRsp.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ap.RecoveryAPRsp recoveryAP(
			com.roya.mas.platform.schema.ap.RecoveryAPReq parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/RecoveryAP");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "RecoveryAP"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ap.RecoveryAPRsp) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ap.RecoveryAPRsp) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ap.RecoveryAPRsp.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void startNotification(
			com.roya.mas.platform.schema.notification.StartNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/startNotification");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"startNotification"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void stopNotification(
			com.roya.mas.platform.schema.notification.StopNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[6]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/startNotification");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"stopNotification"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.sms.SendSmsResponse sendSms(
			com.roya.mas.platform.schema.sms.SendSmsRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[7]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/sendSms");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "sendSms"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.sms.SendSmsResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.sms.SendSmsResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.sms.SendSmsResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifySmsDeliveryStatus(
			com.roya.mas.platform.schema.sms.NotifySmsDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[8]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/notifySmsDeliveryStatus");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifySmsDeliveryStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.sms.SMSMessage[] getReceivedSms(
			com.roya.mas.platform.schema.sms.GetReceivedSmsRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[9]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/GetReceivedSms");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"GetReceivedSms"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.sms.SMSMessage[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.sms.SMSMessage[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.sms.SMSMessage[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.sms.DeliveryInformation[] getSmsDeliveryStatus(
			com.roya.mas.platform.schema.sms.GetSmsDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[10]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/GetSmsDeliveryStatus");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"GetSmsDeliveryStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.sms.DeliveryInformation[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.sms.DeliveryInformation[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.sms.DeliveryInformation[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifySmsReception(
			com.roya.mas.platform.schema.sms.NotifySmsReceptionRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[11]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/notifySmsReception");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifySmsReception"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.mms.SendMessageResponse sendMessage(
			com.roya.mas.platform.schema.mms.SendMessageRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[12]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/sendMessage");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName("",
						"sendMessage"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.mms.SendMessageResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.mms.SendMessageResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.mms.SendMessageResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.mms.DeliveryInformation[] getMessageDeliveryStatus(
			com.roya.mas.platform.schema.mms.GetMessageDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[13]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/getMessageDeliveryStatus");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"getMessageDeliveryStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.mms.DeliveryInformation[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.mms.DeliveryInformation[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.mms.DeliveryInformation[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.mms.MessageReference[] getReceivedMessages(
			com.roya.mas.platform.schema.mms.GetReceivedMessagesRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[14]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/getReceivedMessages");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"getReceivedMessages"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.mms.MessageReference[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.mms.MessageReference[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.mms.MessageReference[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.mms.GetMessageResponse getMessage(
			com.roya.mas.platform.schema.mms.GetMessageRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[15]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/getMessage");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "getMessage"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.mms.GetMessageResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.mms.GetMessageResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.mms.GetMessageResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifyMessageReception(
			com.roya.mas.platform.schema.mms.NotifyMessageReceptionRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[16]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/notifyMessageReception");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifyMessageReception"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifyMessageDeliveryReceipt(
			com.roya.mas.platform.schema.mms.NotifyMessageDeliveryReceiptRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[17]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/notifyMessageDeliveryReceipt");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifyMessageDeliveryReceipt"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.location.GetLocationResponse getLocation(
			com.roya.mas.platform.schema.location.GetLocationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[18]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/getLocation");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName("",
						"getLocation"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.location.GetLocationResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.location.GetLocationResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.location.GetLocationResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.location.LocationData[] getLocationForGroup(
			com.roya.mas.platform.schema.location.GetLocationForGroupRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[19]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/getLocationForGroup");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"getLocationForGroup"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.location.LocationData[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.location.LocationData[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.location.LocationData[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse startPeriodicNotification(
			com.roya.mas.platform.schema.location.StartPeriodicNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[20]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/startPeriodicNotification");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"startPeriodicNotification"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.location.StartPeriodicNotificationResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void endNotification(
			com.roya.mas.platform.schema.location.EndNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[21]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/EndNotification");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"EndNotification"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void locationNotification(
			com.roya.mas.platform.schema.location.LocationNotificationRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[22]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/LocationNotification");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"LocationNotification"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void locationError(
			com.roya.mas.platform.schema.location.LocationErrorRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[23]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/LocationError");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"LocationError"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void locationEnd(
			com.roya.mas.platform.schema.location.LocationEndRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[24]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/LocationEnd");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName("",
						"LocationEnd"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.wap.SendPushResponse sendPush(
			com.roya.mas.platform.schema.wap.SendPushRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[25]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/sendPush");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "sendPush"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.wap.SendPushResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.wap.SendPushResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.wap.SendPushResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.wap.DeliveryInformation[] getPushDeliveryStatus(
			com.roya.mas.platform.schema.wap.GetPushDeliveryStatusRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[26]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/getPushDeliveryStatus");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"getPushDeliveryStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.wap.DeliveryInformation[]) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.wap.DeliveryInformation[]) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.wap.DeliveryInformation[].class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifyPushDeliveryReceipt(
			com.roya.mas.platform.schema.wap.NotifyPushDeliveryReceiptRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[27]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("http://www.csapi.org/service/notifyPushDeliveryReceipt");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifyPushDeliveryReceipt"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ussd.MakeUssdResponse makeUssd(
			com.roya.mas.platform.schema.ussd.MakeUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[28]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/makeUssd");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "makeUssd"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ussd.MakeUssdResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ussd.MakeUssdResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ussd.MakeUssdResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ussd.HandleUssdResponse handleUssd(
			com.roya.mas.platform.schema.ussd.HandleUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[29]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/handleUssd");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "handleUssd"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ussd.HandleUssdResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ussd.HandleUssdResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ussd.HandleUssdResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public com.roya.mas.platform.schema.ussd.UssdContinueResponse ussdContinue(
			com.roya.mas.platform.schema.ussd.UssdContinueRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[30]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/ussdContinue");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName("",
						"ussdContinue"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (com.roya.mas.platform.schema.ussd.UssdContinueResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (com.roya.mas.platform.schema.ussd.UssdContinueResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									com.roya.mas.platform.schema.ussd.UssdContinueResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void endUssd(
			com.roya.mas.platform.schema.ussd.EndUssdRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[31]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/endUssd");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("", "endUssd"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

	public void notifyUssdEnd(
			com.roya.mas.platform.schema.ussd.NotifyUssdEndRequest parameter)
			throws java.rmi.RemoteException,
			com.roya.mas.platform.schema.common.v2_0.PolicyException,
			com.roya.mas.platform.schema.common.v2_0.ServiceException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[32]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("http://www.csapi.org/service/notifyUssdEnd");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName("",
				"notifyUssdEnd"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { parameter });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			}
			extractAttachments(_call);
		} catch (org.apache.axis.AxisFault axisFaultException) {
			if (axisFaultException.detail != null) {
				if (axisFaultException.detail instanceof java.rmi.RemoteException) {
					throw (java.rmi.RemoteException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.PolicyException) {
					throw (com.roya.mas.platform.schema.common.v2_0.PolicyException) axisFaultException.detail;
				}
				if (axisFaultException.detail instanceof com.roya.mas.platform.schema.common.v2_0.ServiceException) {
					throw (com.roya.mas.platform.schema.common.v2_0.ServiceException) axisFaultException.detail;
				}
			}
			throw axisFaultException;
		}
	}

}
