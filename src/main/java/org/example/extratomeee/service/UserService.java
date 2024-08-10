package org.example.extratomeee.service;

import org.example.extratomeee.dto.UserDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.model.User;
import org.example.extratomeee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }


    public Result createnewUser(UserDto userDto) {
        User user1 = new User();
        user1.setFirstname(userDto.getFirstname());
        user1.setLastname(userDto.getLastname());
        user1.setPhoneNumber(userDto.getPhoneNumber());
        user1.setCode(userDto.getCode());
        user1.setPassword(userDto.getPassword());
        user1.setActive(userDto.isActive());
        userRepository.save(user1);

        return new Result(true, "created");


    }

    public Result updateUser(UserDto userDto, Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            user.setActive(userDto.isActive());
            userRepository.save(user);
            return new Result(true, "saved");
        }
        return new Result(false, "user not found");
    }

    public Result deleteUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return new Result();

        }

return new Result(false,"not found");
    }
}


