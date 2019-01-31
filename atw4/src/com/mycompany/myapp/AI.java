/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author Monta
 */
import com.codename1.util.StringUtil;
import com.mycompany.myapp.Models.ReservationVoyage;
import com.mycompany.myapp.Models.Voyage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class AI {
     private static AI instance = new AI();
    private static final String[] BAD_WORDS = {"fuck", "sex"};
    private static final String[] TRAVEL = {"your travels", "all travels"};
    private static final String[] BOOKS = {"my books", "my book","my travel"};
    private static final String[] HOW_TO_BOOKS = {"how to book", "how can i book"};
    private static final String[] HELLO = {"hi", "hello","good morning"};
    private static final String[] NAME = {"your name"};
    private static final String CANT_ABIDE_SUCH_LANGUAGE = "I can't abide such language... Clean up your act... ";
    
    private static final String WHY_ARE_YOU_CONCERNED = "Why are you concerned about ";

    private static final String TOO_LITTLE_DATA_PLEASE_TELL_ME_MORE = "Too little data. Please tell me more...";
    private   ArrayList<Voyage> voyagesl1 =new ArrayList<>();
    private   ArrayList<ReservationVoyage> books1=new ArrayList<>();
    private String travels="";
    private String travelbooks="";
    public static String getResponse(String question) {
        return instance.getResponseToQuestion(question.toLowerCase());
    }

    private String getResponseToQuestion(String question) {
        travels="";
        travelbooks="";
        if(has(question, BAD_WORDS)) {
            return CANT_ABIDE_SUCH_LANGUAGE;
        }
        
        if(question.startsWith("please")) {
            return "You don't have to be so polite";
        }
        
        if(question.startsWith("say ")) {
            return question.substring(4);
        }
         if(has(question,TRAVEL)) {
            
              VoyageMapper mapper=new VoyageMapper();
          ListeVoyagesMapper mapper1=new ListeVoyagesMapper(); 
          mapper1.register(Voyage.class, mapper);
           List<Voyage> voyages = null;
    Map map;
    try {
	map = mapper1.readJSONFromURL("http://localhost/services/web/app_dev.php/api/travel/all");
	voyages = mapper1.getList(map, "root", Voyage.class);
	 // System.out.println(Result.fromContent(map).toString()); // OK: See attached fromStream.json
	
	
} catch (IOException ex) {
	System.err.println(ex);
}
        System.out.println(voyages.size());
if (voyages != null) {
	for(Voyage ac: voyages) {
		map = mapper.writeMap(ac);
                travels=travels+ac.getDcountry()+",";
		System.out.println(travels);  // NOK (contains class=null): See attached fromPOJO.json
          
            voyagesl1.add(ac);
            }
            
        }
             
             return travels ;
             
        }
        
        if(question.length() < 2) {
            return TOO_LITTLE_DATA_PLEASE_TELL_ME_MORE;
        }
        if(has(question,HELLO)) {
        return "Hello";
        
        }
        if(has(question,NAME)) {
        return "My Name is Montassar bouagina";
        
        }
         if(has(question,BOOKS)) {
      
           BooksMapper booksmapper=new BooksMapper();
          ReservationVoyageMapper resmapper=new ReservationVoyageMapper();
          booksmapper.register(ReservationVoyage.class,resmapper);
           List<ReservationVoyage> books = null;
    Map map1;
    try {
	map1 = booksmapper.readJSONFromURL("http://localhost/services/web/app_dev.php/api/tbook/all");
	books = booksmapper.getList(map1, "root", ReservationVoyage.class);
	
	
} catch (IOException ex) {
	System.err.println(ex);
}
        System.out.println(books.size());
if (books != null) {
	for(ReservationVoyage resv: books) {
		map1 = resmapper.writeMap(resv);
	       travelbooks=travelbooks+"\n the book number is "+resv.getIdrvoyage()+"   you booked  for  :"+resv.getAdnbr()+" Adults and :"+resv.getKnbr()+" Kids";
          
            books1.add(resv);
            }
            return travelbooks;
        }
}
        
         
          if(has(question,HOW_TO_BOOKS)) {
            
        return "You need to leave and go to side menu then choose my books";
        
        }
        List<String> tokens = StringUtil.tokenize(question, " .,;\"':-?!-_");
        return WHY_ARE_YOU_CONCERNED + tokens.get(tokens.size() - 1);
    }
    
    private boolean has(String question, String[] words) {
        for(String s : words) {
            if(question.indexOf(s) > -1) {
                return true;
            }
        }
        return false;
    }
}
