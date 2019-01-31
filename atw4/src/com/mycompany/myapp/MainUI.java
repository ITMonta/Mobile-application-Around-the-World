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
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.mycompany.myapp.Models.Voyage;
import com.codename1.components.SpanButton;
import com.codename1.maps.Coord;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.messaging.Message;
import com.codename1.processing.Result;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Models.ReservationVoyage;
import com.sun.javafx.scene.control.behavior.ToggleButtonBehavior;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class includes the user interface for the restaurant, most of the theme elements are derived from the 
 * designer and can be replaced there. To change a lot of the constants such as the address, title etc. you can 
 * use the static variables defined at the top
 */
public class MainUI extends Form {
    private static final String APPLICATOIN_NAME = "Around The World";
    private static final double APPLICATOIN_LATITUDE = 36.89926084779188;
    private static final double APPLICATOIN_LONGITUDE = 10.189254622985858;
    private static final Coord  APPLICATOIN_LOCATION = new Coord(APPLICATOIN_LATITUDE, APPLICATOIN_LONGITUDE);
    private static final String APPLICATOIN_PHONE_NUMBER = "+1800777777";
    private static final String APPLICATOIN_DISPLAY_PHONE_NUMBER = "+1-800-777-7777";
    private static final String APPLICATOIN_EMAIL = "montassar.bouagina@esprit.tn";
    private static final String APPLICATOIN_DISPLAY_ADDRESS = "AroundTheWorld\n55 3rd street\nNY NY 66666";
    
    private static final boolean INCLUDE_RESERVATIONS = true;
    private static final String OPEN_TABLE_RESERVATION_ID = "168";
    
   
    private   ArrayList<Voyage> voyagesl1 =new ArrayList<>();
    private   ArrayList<ReservationVoyage> books1=new ArrayList<>();
    
    private Resources theme1;
    private Resources theme2;
    
    public MainUI(Resources theme) {
        super(APPLICATOIN_NAME);
        this.theme1 = theme;
        Toolbar t = new Toolbar();
        setToolBar(t);
        t.setScrollOffUponContentPane(true);
        
        Label rat = new Label(theme.getImage("itsquad2.png"));
        rat.setTextPosition(Label.BOTTOM);
        rat.setText(APPLICATOIN_NAME);
        rat.setUIID("SideMenuLogo");
        t.addComponentToSideMenu(rat);
        setLayout(new BorderLayout());
        
        Container Voyages = createVoyagesContainer();
        addComponent(BorderLayout.CENTER, Voyages);
        revalidate();
        
        Style iconStyle = UIManager.getInstance().getComponentStyle("SideCommandIcon");
        
        t.addCommandToSideMenu(new Command("Travels", FontImage.create(" \ue8d5 ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showVoyagesContainer();
            }
        });
        if(INCLUDE_RESERVATIONS) {
            t.addCommandToSideMenu(new Command("Reservation", FontImage.create(" \ue838 ", iconStyle)) {
                @Override
                public void actionPerformed(ActionEvent evt) {
       showreservationContainer();
                }
            });
        }
        t.addCommandToSideMenu(new Command("Find Us", FontImage.create(" \ue8d4 ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showMap();
            }
        });
        t.addCommandToSideMenu(new Command("Contact Us", FontImage.create(" \ue86b ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showContactUs();
            }
        });
        t.addCommandToSideMenu(new Command("Logout", FontImage.create(" \ue848 ", iconStyle)) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new DrSbaitso(theme1= UIManager.initNamedTheme("/theme2","Theme"));
            }
        });
        
              VoyageMapper mapper=new VoyageMapper();
          ListeVoyagesMapper mapper1=new ListeVoyagesMapper(); 
          mapper1.register(Voyage.class, mapper);
          BooksMapper booksmapper=new BooksMapper();
          ReservationVoyageMapper resmapper=new ReservationVoyageMapper();
          booksmapper.register(ReservationVoyage.class,resmapper);
                
      /*  try {
            
            Voyage voyage = mapper.readJSONFromURL("http://localhost/services/web/app_dev.php/api/travel/find/3",Voyage.class);
            System.out.println(voyage.getDcountry());
        } catch (IOException ex) {
            
        } */
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
	//	System.out.println(Result.fromContent(map).toString());  // NOK (contains class=null): See attached fromPOJO.json
          
            voyagesl1.add(ac);
            }
            
        }

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
	
          
            books1.add(resv);
            }
            
        }
}
    

    private void showContactUs() {
        getContentPane().replace(getContentPane().getComponentAt(0), createContactUs(), CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private Container createContactUs() {
        BorderLayout abs = new BorderLayout();
        abs.setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE);
        Container contactUsParent = new Container(abs);
        
        Container contactUs = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        contactUsParent.addComponent(BorderLayout.CENTER, contactUs);
        
        contactUs.setScrollableY(true);
        
        Button phone = new Button(APPLICATOIN_DISPLAY_PHONE_NUMBER);
        phone.addActionListener((e) -> {
            Display.getInstance().dial(APPLICATOIN_PHONE_NUMBER);
        });
        
        phone.setUIID("Label");
        contactUs.addComponent(phone);
        contactUs.setUIID("ContactUsLayer");
        contactUsParent.setUIID("ContactUs");

        Button email = new Button(APPLICATOIN_EMAIL);
        email.addActionListener((e) -> {
            Message m = new Message("Type your message here:\n");
            Display.getInstance().sendMessage(new String[] {APPLICATOIN_EMAIL}, "Contact from app", m);
        });
        
        email.setUIID("Label");
        contactUs.addComponent(email);
        
        SpanButton address = new SpanButton(APPLICATOIN_DISPLAY_ADDRESS);
        address.setUIID("Container");
        address.setTextUIID("Label");
        address.addActionListener((e) -> {
            Display.getInstance().openNativeNavigationApp(APPLICATOIN_LATITUDE, APPLICATOIN_LONGITUDE);
        });
        
        contactUs.addComponent(address);
        
        return contactUsParent;
    }
    
    private void showMap() {
        MapContainer mc = new MapContainer();
        mc.addMarker((EncodedImage)theme1.getImage("itsquad2.png"), APPLICATOIN_LOCATION, APPLICATOIN_NAME, APPLICATOIN_NAME, null);
        mc.zoom(APPLICATOIN_LOCATION, mc.getMaxZoom() - 2);
        getContentPane().replace(getContentPane().getComponentAt(0), mc, CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private void showVoyagesContainer() {
        Container Voyages = createVoyagesContainer();
        getContentPane().replace(getContentPane().getComponentAt(0), Voyages, CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private Container createVoyagesContainer() {
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.setScrollableY(true);  
        // allows elements to slide into view
        for(Voyage d : voyagesl1) {
            Component Voyage = createVoyageComponent(d);
            cnt.addComponent(Voyage);            
        }        
        return cnt;
    }
    
    private Container createVoyageComponent(Voyage v) {
        Image img = theme1.getImage(v.getImagelink());
        Container mb = new Container(new BorderLayout());
        mb.getUnselectedStyle().setBgImage(img);
        mb.getSelectedStyle().setBgImage(img);
        mb.getPressedStyle().setBgImage(img);
        mb.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        mb.getSelectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        mb.getPressedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Container box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        Button title = new Button(v.getDcountry());
        title.setUIID("DishTitle");
        Label highlights = new Label(v.getDuration()+"Hours");
        TextArea details = new TextArea(v.getDescription());
        details.setUIID("DishBody");
        highlights.setUIID("DishBody");
        Label price = new Label(v.getAdultprice()+"$");
        price.setUIID("DishPrice");
        box.addComponent(title);
        box.addComponent(highlights);
        
        
        Container boxAndPrice = new Container(new BorderLayout());
        boxAndPrice.addComponent(BorderLayout.CENTER, box);
        boxAndPrice.addComponent(BorderLayout.EAST, price);
        mb.addComponent(BorderLayout.SOUTH, boxAndPrice);
        
        mb.setLeadComponent(title);
        
        title.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filepath=v.getAudiolink();
                    Media m = MediaManager.createMedia(filepath, false);
                   //  m.pause();
                   
                    if(highlights.getParent() != null) {
                        m.pause();
                        box.removeComponent(highlights);
                        box.addComponent(details);
                           m.play();
                    } else {
                        m.setVolume(0);
                        box.removeComponent(details);
                        box.addComponent(highlights);
                         
                    }
                    title.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if(m.isPlaying()==true){ m.pause();}
                           
                        }
                    });
                    mb.getParent().animateLayout(300);
                   // m.pause();
                }
                catch(IOException err) {
                    
                }
            }
        });
        return mb;
    }
    private Container CreatReservationCompenant(ReservationVoyage rv)
    
    {
       
        Voyage v=searchTravel(rv.getFkvoy());
        
        Image img = theme1.getImage(v.getImagelink());
        Container cn = new Container(new BorderLayout());
        cn.getUnselectedStyle().setBgImage(img);
        cn.getSelectedStyle().setBgImage(img);
        cn.getPressedStyle().setBgImage(img);
        cn.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        cn.getSelectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        cn.getPressedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Container box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        Button title = new Button(v.getDcountry());
        title.setUIID("DishTitle");
        Label highlights = new Label(v.getTraveldate());
        TextArea details = new TextArea(rv.getAdnbr()+": adults \n"+rv.getCnbr()+":babys \n"+rv.getKnbr()+":Kids");
        details.setUIID("DishBody");
        highlights.setUIID("DishBody");
        Button Update =new Button("Update")    ;
        Button Delete =new Button("Delete")    ;
        box.addComponent(title);
        box.addComponent(highlights);
        
        Container boxAndPrice = new Container(new BorderLayout());
        boxAndPrice.addComponent(BorderLayout.CENTER, box);
        cn.addComponent(BorderLayout.SOUTH, boxAndPrice);
        cn.setLeadComponent(title);       
        title.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(highlights.getParent() != null) {
                    
                    box.removeComponent(highlights);
                    box.addComponent(details);
                    box.addComponent(Update);
                    box.addComponent(Delete);
                    
                    
                } else {
                    
                    box.removeComponent(details);
                    box.addComponent(highlights);
                    box.removeComponent(Update);
                    box.removeComponent(Delete);
                    
                }
                cn.getParent().animateLayout(300);
               
            }
        });
        return cn;
    }
   private void showreservationContainer() {
        Container RVoyages = createreservationContainer();
        getContentPane().replace(getContentPane().getComponentAt(0), RVoyages, CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
    }
    
    private Container createreservationContainer() {
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt.setScrollableY(true);  
        // allows elements to slide into view
        for(ReservationVoyage d : books1) {
            Component RVoyage = CreatReservationCompenant(d);
            cnt.addComponent(RVoyage);            
        }        
        return cnt;
    }
    private Voyage searchTravel(int id)
    {
   
       VoyageMapper travelmapper=new VoyageMapper();
       try {
            
            Voyage voyage = travelmapper.readJSONFromURL("http://localhost/services/web/app_dev.php/api/travel/find/2",Voyage.class);
            System.out.println(voyage.getIdvoy());
            return voyage;
        } catch (IOException ex) {
            return null;
        }
    
    }
    
}
