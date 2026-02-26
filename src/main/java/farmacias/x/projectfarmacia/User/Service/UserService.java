package farmacias.x.projectfarmacia.User.Service;

import farmacias.x.projectfarmacia.User.DTO.UserDTO;
import farmacias.x.projectfarmacia.User.DTO.UserMapper;
import farmacias.x.projectfarmacia.User.Model.UserModel;
import farmacias.x.projectfarmacia.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //create user
    public List<UserDTO> createUser(List<UserDTO> userDTO){
        List<UserModel> user = userDTO.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
        List<UserModel> userSave = userRepository.saveAll(user);

        return userSave.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    //list
    public List<UserDTO> list(){
        List<UserModel> user = userRepository.findAll();
        return user.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    //list by id
    public UserDTO listByid(Long id){
        Optional<UserModel> userId = userRepository.findById(id);
        return userId.map(userMapper::map).orElse(null);
    }

    //delete user
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
