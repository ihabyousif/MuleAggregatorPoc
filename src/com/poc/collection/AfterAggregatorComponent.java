package com.poc.collection;

import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class AfterAggregatorComponent implements Callable {
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		List list = (List) eventContext.getMessage().getPayload();
		System.out.println("########### After collection aggregator #########");
		
		String finalStr = "final string = ";
		for (int i=0 ; i<list.size() ; i++){
			finalStr += list.get(i);
			System.out.println("count number " + i +" = "+list.get(i));
		}
		
		return finalStr;
	}

}
