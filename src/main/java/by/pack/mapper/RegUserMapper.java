package by.pack.mapper;

import by.pack.dto.RegUserDto;
import by.pack.entity.User;


public class RegUserMapper {

    public static User regUserDtoToUser(RegUserDto regUserDto) {
        User user = new User();
        user.setFirstname(regUserDto.getFirstname());
        user.setLastname(regUserDto.getLastname());
        user.setUsername(regUserDto.getUsername());
        user.setEmail(regUserDto.getEmail());
        user.setPassword(regUserDto.getPassword());
        return user;
    }
    }
