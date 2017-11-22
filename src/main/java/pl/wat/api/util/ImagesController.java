package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.logic.dto.profile.ProfilePictureDTO;
import pl.wat.logic.service.utils.ImagesService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.apache.commons.io.FileUtils;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

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
        catch (FileNotFoundException fnfe){
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

}
