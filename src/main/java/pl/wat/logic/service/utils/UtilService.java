package pl.wat.logic.service.utils;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.wat.security.JwtUser;

@Service
public class UtilService {

    public int getUserId(Authentication auth){
        if(auth!= null && auth.getPrincipal()!= null){
            JwtUser user = (JwtUser) auth.getPrincipal();
            return user.getId();
        }else {
            return -1;
        }
    }
}
