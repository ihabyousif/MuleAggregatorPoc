package com.poc;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class InjectPropertiesComponent implements Callable{
	@SuppressWarnings("deprecation")
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// MULE_CORRELATION_SEQUENCE=1, MULE_CORRELATION_GROUP_SIZE=4, MULE_CORRELATION_ID=6c9d5dc3-147f-11e1-9cd3-75f5162d916c
		MuleMessage msg = eventContext.getMessage();
		System.out.println("******* received payload " + msg.getPayload().toString());
		String [] strArr = msg.getPayload().toString().split("_");
		msg.setProperty("MULE_CORRELATION_SEQUENCE", strArr[0]);
		msg.setProperty("MULE_CORRELATION_GROUP_SIZE", strArr[1]);
		msg.setProperty("MULE_CORRELATION_ID", strArr[2]);
		msg.setPayload(strArr[3]);
		return msg;
	}

}
