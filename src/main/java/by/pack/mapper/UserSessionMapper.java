package by.pack.mapper;

import by.pack.entity.SessionUser;
import by.pack.entity.User;

public class UserSessionMapper {

    public static SessionUser userToSessionUser(User user){
        SessionUser sessionUser = new SessionUser();
        sessionUser.setId(user.getId());
        sessionUser.setFirstname(user.getFirstname());
        sessionUser.setLastname(user.getLastname());
        sessionUser.setUsername(user.getUsername());
        sessionUser.setEmail(user.getEmail());
        return sessionUser;
    }
}
