package com.poc.chunking;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;


public class AfterAggregatorComponent implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		byte [] barr = (byte []) eventContext.getMessage().getPayload();
		String str = new String(barr);
		System.out.println("########### after chunking aggregator #########");
		System.out.println("### message = " + str);
		return eventContext.getMessage().getPayload();
	}

}
