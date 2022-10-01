package model;

import java.util.List;

public class Json {
	
	String numFound;
	String start;
	String numFoundExact;
	List<Docs> docs;
	
		public class Docs{
			
			String title;
			List<String> publisher;
			List<String> author_name;
			
		}
		

}
