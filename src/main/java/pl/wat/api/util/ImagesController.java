package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wat.config.Constants;
import pl.wat.logic.dto.profile.ProfilePictureDTO;
import pl.wat.logic.dto.user.UserDTO;
import pl.wat.logic.service.utils.ImagesService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.List;
import org.apache.commons.io.FileUtils;

@RestController
@RequestMapping("/api/images")
public class ImagesController extends BaseController {

    @Value("${upload.files.directory}")
    private String sourceDirectory;

    @Autowired
    private ImagesService imagesService;

//    @RequestMapping(value = "/picture-list/{userId}",method = RequestMethod.GET)
//    public List<ProfilePictureDTO> getUserPictures(@PathVariable int userId){
//        return imagesService.getUserPicturesList(userId);
//    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public void getUserImage(HttpServletResponse resp, @PathVariable String id){
        try{
            if(id != null && !"null".equals(id)){
                int userPhotoId = Integer.parseInt(id);
                File file = new File(sourceDirectory + "images/users/"+ userPhotoId+".jpg");
                byte [] image = FileUtils.readFileToByteArray(file);
                resp.setContentType("image/jpeg");
                resp.getOutputStream().write(image);
            }
            else {
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException fnfe){
            try {
                File fileStock = new File(sourceDirectory + "images/users/stock.jpg");
                byte [] imageStock = FileUtils.readFileToByteArray(fileStock);
                resp.setContentType("image/jpeg");
                resp.getOutputStream().write(imageStock);
            }
            catch (Exception ee){
                System.out.println("Exception while reading stock user photo:" + ee.getMessage());
            }
        }
        catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

    @RequestMapping(value = "/events/{id}",method = RequestMethod.GET)
    public void getEventImage(HttpServletResponse resp, @PathVariable String id){
        try{
            int eventId = Integer.parseInt(id);
            File file = new File(sourceDirectory + "images/events/"+eventId+".jpg");
            byte [] image = FileUtils.readFileToByteArray(file);
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(image);
        }
        catch (FileNotFoundException | NumberFormatException pe){
            try {
                File file = new File(sourceDirectory + "images/events/stock.jpg");
                byte [] imageStock = FileUtils.readFileToByteArray(file);
                resp.setContentType("image/jpeg");
                resp.getOutputStream().write(imageStock);
            }
            catch (Exception ee){
                System.out.println("Exception while reading stock event photo:" + ee.getMessage());
            }
        }
        catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

    //UPLOAD EVENT PHOTO
    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value = "/upload-event-photo/{eventId}",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Long eventId) {

        if(!file.isEmpty() && eventId!=null){
            try{
                byte[] bytes = file.getBytes();
                File serverFile = new File(sourceDirectory+"images/events/"+ eventId+".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            }catch (Exception e){
                System.out.println("uploadImage() Exception ");
            }
        }
    }
    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value = "/delete-event-photo/{eventId}",method = RequestMethod.GET)
    public boolean uploadImage(@PathVariable Long eventId) {

        if(eventId!=null){
            try{
                File file = new File(sourceDirectory + "images/events/"+eventId+".jpg");
                if(file.exists()){
                    file.delete();
                    return true;
                }else {
                    return false;
                }
            }catch (Exception e){
                System.out.println("deleteImage() Exception ");
            }
        }
        return false;
    }

    //UPLOAD EVENT PHOTO
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/upload-user-photo",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void uploadImage(@RequestParam("file") MultipartFile file, Authentication auth) {

        UserDTO loggedUser = getLoggerUser(auth);
        System.out.println(file.getName());
        if(!file.isEmpty() && loggedUser != null && loggedUser.getId() != null){
            try{
                byte[] bytes = file.getBytes();
                File serverFile = new File(sourceDirectory+"images/users/"+ loggedUser.getId() +".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            }catch (Exception e){
                System.out.println("uploadImage() Exception ");
            }
        }
    }

}
