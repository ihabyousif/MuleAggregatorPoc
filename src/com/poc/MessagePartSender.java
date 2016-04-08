package com.poc;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;


public class MessagePartSender implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String oldPayLoad = eventContext.getMessage().getPayload().toString().trim();
		System.out.println("********* old pay load = "+oldPayLoad);
		String newPayLoad = "";
		if (oldPayLoad.equals("a")){
		// Item one    MULE_CORRELATION_SEQUENCE=1, MULE_CORRELATION_GROUP_SIZE=4, MULE_CORRELATION_ID=6c9d5dc3-147f-11e1-9cd3-75f5162d916c
		newPayLoad = "1_4_6c9d5dc3-147f-11e1-9cd3-75f5162d916c_ItemOne";
		}else if (oldPayLoad.equals("b")){
		// Item two    MULE_CORRELATION_SEQUENCE=2, MULE_CORRELATION_GROUP_SIZE=4, MULE_CORRELATION_ID=6c9d5dc3-147f-11e1-9cd3-75f5162d916c
		newPayLoad = "2_4_6c9d5dc3-147f-11e1-9cd3-75f5162d916c_ItemTwo";
		}else if (oldPayLoad.equals("c")){
		// Item three  MULE_CORRELATION_SEQUENCE=3, MULE_CORRELATION_GROUP_SIZE=4, MULE_CORRELATION_ID=6c9d5dc3-147f-11e1-9cd3-75f5162d916c
		newPayLoad = "3_4_6c9d5dc3-147f-11e1-9cd3-75f5162d916c_ItemThree";
		}else if (oldPayLoad.equals("d")){
		// Item four   MULE_CORRELATION_SEQUENCE=4, MULE_CORRELATION_GROUP_SIZE=4, MULE_CORRELATION_ID=6c9d5dc3-147f-11e1-9cd3-75f5162d916c
		newPayLoad = "4_4_6c9d5dc3-147f-11e1-9cd3-75f5162d916c_ItemFour";
		}
		System.out.println("********* newPayLoad = "+newPayLoad);
		return newPayLoad;
	}
}