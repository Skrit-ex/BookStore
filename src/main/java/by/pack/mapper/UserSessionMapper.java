package by.pack.mapper;

import by.pack.entity.SessionUser;
import by.pack.entity.User;

public class UserSessionMapper {

    public static SessionUser sessionUserToUser(User user){
        SessionUser sessionUser = new SessionUser();
        sessionUser.setFirstname(sessionUser.getFirstname());
        sessionUser.setLastname(sessionUser.getLastname());
        sessionUser.setUsername(sessionUser.getUsername());
        sessionUser.setEmail(sessionUser.getEmail());
        return sessionUser;
    }
}
