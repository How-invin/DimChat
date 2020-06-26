package howin.dimChat.LoginModule;

import howin.dimChat.dao.LoginDao;
import howin.dimChat.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by echisan on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/test")
    public String test(){
        return "HELLO WORLD";
    }

    @Resource
    private LoginDao loginDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        int res = loginDao.createUser(user.getUsername(), user.getPassword(), user.getRole());
        return "";
    }
}
