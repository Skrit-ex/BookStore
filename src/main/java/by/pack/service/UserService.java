package by.pack.service;

import by.pack.dao.HibernateUserDao;
import by.pack.dto.LoginDto;
import by.pack.dto.RegUserDto;
import by.pack.entity.SessionUser;
import by.pack.entity.User;
import by.pack.mapper.RegUserMapper;
import by.pack.mapper.UserSessionMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateUserDao hibernateUserDao;

    public void save(RegUserDto regUserDto) {
        User user = RegUserMapper.regUserDtoToUser(regUserDto);
        hibernateUserDao.save(user);
    }

    public Optional<SessionUser> login(LoginDto loginDto) {
        Optional<User> user = hibernateUserDao.findByEmail(loginDto.getEmail());

        if(user.isPresent()){

            User currentUser = user.get();

            if(currentUser.getPassword().equals(loginDto.getPassword())){
                return Optional.of(UserSessionMapper.userToSessionUser(currentUser));
            }
        }
        return Optional.empty();
    }
}
