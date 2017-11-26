package pl.wat.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wat.config.Constants;
import pl.wat.db.domain.Customer;
import pl.wat.db.domain.DemoClass;
import pl.wat.db.domain.event.Event;
import pl.wat.db.domain.personality.Match;
import pl.wat.db.repository.conversation.PrivateMessageRepository;
import pl.wat.db.repository.event.EventRepository;
import pl.wat.db.repository.localization.RegionRepository;
import pl.wat.db.repository.personality.UserPersonalityAttributeRepository;
import pl.wat.logic.demo.CustomerService;
import pl.wat.logic.dto.event.EventSearchDTO;
import pl.wat.logic.dto.localization.CityDTO;
import pl.wat.logic.dto.localization.RegionDTO;
import pl.wat.logic.dto.personality.MatchForm;
import pl.wat.logic.dto.profile.ProfileSearchDTO;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.conversation.ConversationService;
import pl.wat.logic.service.dictionary.DictionaryService;
import pl.wat.logic.service.personality.PersonalityService;
import pl.wat.logic.service.user.UserService;
import sun.java2d.cmm.Profile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

//KONTROLER DEMO typu Ctrl+c, Ctrl+v dla dalszych metod kontrolerow w projekcie
@RestController
@RequestMapping("/api")
public class DemoRestController {

    @Autowired
    ConversationService conversationService;
    @Autowired
    PrivateMessageRepository privateMessageRepository;
    @Autowired
    UserService userService;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    UserPersonalityAttributeRepository userPersonalityAttributeRepository;

    @Autowired
    PersonalityService personalityService;

    @Autowired
    EventRepository eventRepository;


    @RequestMapping(value = "/action1",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public Authentication getAction1(Authentication auth){
        return auth;
    }

    @RequestMapping(value = "/action2",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public List<String> getAction2(Authentication auth){
      //  Conversation conversation = conversationService.createConversation(1, 2);
    //    System.out.println(conversation.getId());
     //   PrivateMessage privateMessage= conversationService.addPrivateMessagesToConversation(conversation, 1, "tata");
     //   System.out.println(privateMessage.getId());
//        for (PrivateMessage privateMessage : privateMessageRepository.findAll()) {
//            System.out.println(privateMessage.getId()+" "+privateMessage.getTextMessage());
//        }
       // System.out.println(userService.countActiveUsers());
       // System.out.println(dictionaryService.getAllRegion());
       // dictionaryService.getAllRegion().forEach(region -> {
       //     System.out.println(region.getRegionName());
      //  });
       // dictionaryService.getCityByRegion(regionRepository.findOne(1)).forEach(city -> System.out.println(city.getCityName()));
       // List<March> marchUserOneToUserTwo = userPersonalityAttributeRepository.findMarchUserIdOneToUserIdTwo(Long.valueOf(1), Long.valueOf(2));

     //  ProfileSearchDTO profileSearchDTO= new ProfileSearchDTO();
      //  profileSearchDTO.setPageNo(0);
      //  profileSearchDTO.setPageSize(2);

        //profileSearchDTO.setCity(new CityDTO());
       // profileSearchDTO.getCity().setId(Long.valueOf(1));

       // List<UserDTO> profilesList = personalityService.getProfilesList(profileSearchDTO);
      //  profilesList.forEach(userDTO -> System.out.println(userDTO.getUsername()));
       // System.out.println(profileSearchDTO.getCountPage());

        MatchForm matchForm = personalityService.getMatchForm(3L);
        matchForm.getCharacterList().get(1).setAnswer("Y");
        matchForm.getCharacterList().get(1).setPartnerAnswer("Y");
        matchForm.getPersonalityList().get(1).setAnswer("Y");
        matchForm.getPersonalityList().get(1).setPartnerAnswer("Y");
        MatchForm matchForm1 = personalityService.saveMatchForm(matchForm);

        MatchForm matchForm2 = personalityService.getMatchForm(2L);
        matchForm2.getCharacterList().get(1).setAnswer("Y");
        matchForm2.getCharacterList().get(1).setPartnerAnswer("Y");
        matchForm2.getPersonalityList().get(1).setAnswer("Y");
        matchForm2.getPersonalityList().get(1).setPartnerAnswer("Y");
        personalityService.saveMatchForm(matchForm2);

        List<Object[]> result = userPersonalityAttributeRepository.findMatchUserIdOneToUserIdTwo(1L,2L);
        List<Match> matchList = new LinkedList<>();
        result.forEach(objects -> matchList.add(new Match((String)objects[0],(BigDecimal)objects[1])));
//
        //CityDTO cityDTO = new CityDTO();
        //cityDTO.setId(1L);
       // RegionDTO regionDTO =new RegionDTO();
      //  regionDTO.setId(7L);
//        Date dateFrom = new Date(117,11,20);
//        EventSearchDTO eventSearchDTO = new EventSearchDTO();
//        eventSearchDTO.setDateFrom(dateFrom);
//        eventSearchDTO.setPageNo(0);
//        eventSearchDTO.setPageSize(5);
//        Slice<Event> eventByFilter = eventRepository.findEventByFilter(eventSearchDTO, new PageRequest(eventSearchDTO.getPageNo(), eventSearchDTO.getPageSize()));
//eventByFilter.getContent().forEach(event -> System.out.println(event.getTitle()));

        List<String> resp = new LinkedList<>();
        resp.add("element1");
        resp.add("element2");
        resp.add("element3");
        return resp;
    }

    @RequestMapping(value = "/action3",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public String getAction3(Authentication auth){
        return "action 3 response";
    }




    //----------------------------------------

    @Autowired
    CustomerService customerService;


    //POBRANIE DANYCH BEZ AUTORYZACJI
    @RequestMapping(value = "/getGuest",method = RequestMethod.GET)
    @ResponseBody Iterable<Customer> getGuest(){
        System.out.println("METODA DOSTEPNA DLA GOSCIA");
        Iterable<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    //WYSLANIE ZADANIA BEZ ODPOWIEDZI Z AUTORYZACJA [USER]
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(value = HttpStatus.OK)
    public void getUser(Authentication auth){
        System.out.println("METODA DOSTEPNA DLA USERA");
        System.out.println(auth.getName()+" "+auth.getAuthorities());
    }

    //POBRANIE DANYCH Z AUTORYZACJA [ADMIN]
    @RequestMapping(value = "/getAdmin",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody Iterable<Customer> getAdmin(){
        System.out.println("METODA DOSTEPNA DLA  ADMINA");
        customerService.testService();
        return customerService.getAllCustomers();
    }

    //WYSLANIE DANYCH BEZ AUTORYZACJI
    @RequestMapping(value = "/postGuest",method = RequestMethod.POST)
    public void postGuest(@RequestBody DemoClass demoClass){
        System.out.println("METODA POST DOSTEPNA DLA GOSCIA");
        System.out.println("Otrzymal nr: "+demoClass.nr);
        System.out.println("Otrzymal napis: "+demoClass.napis);
    }

    //WYSLANIE DANYCH Z AUTORYZACJA [ADMIN]
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/postAdmin",method = RequestMethod.POST)
    public void postAdmin(@RequestBody DemoClass demoClass){
        System.out.println("METODA POST DOSTEPNA DLA ADMINA");
        System.out.println("Otrzymal nr: "+demoClass.nr);
        System.out.println("Otrzymal napis: "+demoClass.napis);
    }


//    UPLOAD PLIKOW Z AUTORYZACJA [USER]
    private static int nrPliku = 0;
    @PreAuthorize("hasRole('USER') or hasRole('MANAGER')")
    @RequestMapping(value = "/postFile",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void uploadImage(@RequestParam("file") MultipartFile file) {
        System.out.println("Upload pliku");
        System.out.println(file.getName());
        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                File serverFile = new File(Constants.UPLOAD_TEST_DIRECTORY    //ZMIENIC NA SWOJA SCIEZKE DLA ZAPISU UPLOADOWANYCH PLIKO!!!
                        + File.separator  + nrPliku + ".jpg");
                nrPliku++;
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            }catch (Exception e){
                System.out.println("uploadImage() Exception ");
            }
        }
    }


}
