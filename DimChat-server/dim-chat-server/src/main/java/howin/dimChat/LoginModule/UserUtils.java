package howin.dimChat.LoginModule;

import howin.dimChat.dao.LoginDao;
import howin.dimChat.models.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUtils {
    @Autowired
    private LoginDao loginDao;

    User findByUsername(String username) {
        return loginDao.getPassword(username);
    }
}
