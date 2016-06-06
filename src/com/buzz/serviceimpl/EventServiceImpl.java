package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;


import com.buzz.bean.EventsBean;
import com.buzz.dao.EventsDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Events;

public class EventServiceImpl {
	EventsDAO eventsDAO = new EventsDAO();

	public void addEvents(EventsBean eventsBean) throws CommonException {
		Events events = new Events(eventsBean);
		eventsDAO.save(events);
	}

	public boolean eventUpdatebyid(EventsBean eventBean) throws CommonException,
			ConnectionException {
		Events Events = new Events(eventBean);
		return eventsDAO.attachDirty(Events);
	}

	public Vector<EventsBean> viewEvents() throws CommonException {
		Events Events = null;
		EventsBean eventsBean = null;
		Vector<EventsBean> vEventBeans = new Vector<EventsBean>();
		try {
			List list = eventsDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				Events = (Events) it.next();
				eventsBean = new EventsBean(Events);
				vEventBeans.add(eventsBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vEventBeans;
	}

	public EventsBean viewEventsbyId(int id) throws CommonException {
		Events Events = null;
		EventsBean eventsBean = null;
		try {
			Events = eventsDAO.findById(id);
			eventsBean = new EventsBean(Events);

		} catch (Exception e) {
			System.out.println(e);
		}
		return eventsBean;
	}

	public boolean deleteBranches(int parseInt) throws CommonException {
		try {
			Events Events = null;
			Events = eventsDAO.findById(parseInt);
			eventsDAO.delete(Events);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
