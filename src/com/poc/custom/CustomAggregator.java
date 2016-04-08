package com.poc.custom;

import java.util.Iterator;

import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.routing.AbstractCorrelationAggregator;
import org.mule.routing.AggregationException;
import org.mule.routing.EventGroup;

public class CustomAggregator extends AbstractCorrelationAggregator {

	@Override
	protected MuleEvent aggregateEvents(EventGroup events)
			throws AggregationException {
		MuleEvent event = events.iterator().next();
		MuleMessage msg = null;
		try {
			msg = aggregateResponsesFromEvents(events);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultMuleEvent(msg, event);

	}

	public static MuleMessage aggregateResponsesFromEvents(EventGroup events)
			throws Exception {
		String aggregateResponse = "";
		MuleEvent event = null;

		for (Iterator iterator = events.iterator(); iterator.hasNext();) {
			event = (MuleEvent) iterator.next();
			String payload = event.getMessage().getPayloadAsString();
			aggregateResponse += payload;
		}

		return new DefaultMuleMessage(aggregateResponse, event.getMuleContext());
	}

}
