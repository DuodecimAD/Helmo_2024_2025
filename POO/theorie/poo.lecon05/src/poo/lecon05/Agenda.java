package poo.lecon05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Agenda {
	
	private String title;
	private List<Event> events;

	public Agenda(String title) {
		this.title = title;
		this.events = new ArrayList<>();
	}
	
	 public void add(Event evt) {
		 if(evt == null) {
			 return;
		 }
		 events.add(evt);

	 }
	 
	 public String[] getTodayEventAt(LocalTime time) {
		 
		 var todayEvents = new ArrayList<String>();
		 var todayTime = LocalDateTime.of(LocalDate.now(), time);
		 
		 for(var evt : events) {
			 if(evt.contains(todayTime)) {
					//Ajouter le nom de l'evt au résultat
					todayEvents.add(evt.getName());
				}
		 }
		 
		 return todayEvents.toArray(new String[0]);
	 }
}
