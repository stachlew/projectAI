package pl.wat.api.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/images")
public class ImagesController {


    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public void getUserImage(HttpServletResponse resp, @PathVariable String id){
        try{
            int userPhotoId = Integer.parseInt(id);
            byte [] image = StreamUtils.copyToByteArray(new ClassPathResource("images/users/test.jpg").getInputStream());;
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(image);
        }
        catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

    @RequestMapping(value = "/events/{id}",method = RequestMethod.GET)
    public void getEventImage(HttpServletResponse resp, @PathVariable String id){
        try{
            int eventId = Integer.parseInt(id);
            byte [] image = StreamUtils.copyToByteArray(new ClassPathResource("images/events/test.jpg").getInputStream());;
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(image);
        }
        catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

}
