package pl.wat.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wat.config.Constants;
import pl.wat.db.domain.Customer;
import pl.wat.db.domain.DemoClass;
import pl.wat.db.repository.conversation.PrivateMessageRepository;
import pl.wat.logic.demo.CustomerService;
import pl.wat.logic.service.conversation.ConversationService;
import pl.wat.logic.service.user.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
        System.out.println(userService.countActiveUsers());


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
    } //end uploadImage()


}
