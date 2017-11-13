package pl.wat.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wat.logic.dto.profile.ProfilePictureDTO;
import pl.wat.logic.service.utils.ImagesService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/picture-list/{userId}",method = RequestMethod.GET)
    public List<ProfilePictureDTO> getUserPictures(@PathVariable int userId){
        return imagesService.getUserPicturesList(userId);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public void getUserImage(HttpServletResponse resp, @PathVariable String id){
        try{
            int userPhotoId = Integer.parseInt(id);
            byte [] image = StreamUtils.copyToByteArray(new ClassPathResource("images/users/"+ userPhotoId+".jpg").getInputStream());
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(image);
        }
        catch (FileNotFoundException fnfe){
            try {
                byte [] imageStock = StreamUtils.copyToByteArray(new ClassPathResource("images/users/stock.jpg").getInputStream());;
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
            byte [] image = StreamUtils.copyToByteArray(new ClassPathResource("images/events/"+eventId+".jpg").getInputStream());;
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(image);
        }
        catch (FileNotFoundException fnfe){
            try {
                byte [] imageStock = StreamUtils.copyToByteArray(new ClassPathResource("images/events/stock.jpg").getInputStream());;
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
