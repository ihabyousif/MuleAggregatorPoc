package com.poc.custom;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class AfterAggregatorComponent implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		System.out.println("########### After custom aggregator #########");
		String str = eventContext.getMessage().getPayload().toString();
		System.out.println("### message = " + str);
		return eventContext.getMessage().getPayload();
	}

}
