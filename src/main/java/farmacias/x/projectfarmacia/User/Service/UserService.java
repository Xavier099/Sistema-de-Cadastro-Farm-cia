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
    public UserDTO createUser(UserDTO userDTO){
       UserModel user = userMapper.map(userDTO);
       user = userRepository.save(user);
       return userMapper.map(user);
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

    //update
    public UserDTO update(Long id, UserDTO userDto){
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if (userDto.getName() != null) user.setName(userDto.getName());
        if (userDto.getTelefone() != null) user.setTelefone(userDto.getTelefone());
        if (userDto.getEmail() != null) user.setEmail(userDto.getEmail());
        if (userDto.getCpf() != null) user.setCpf(userDto.getCpf());
        if (userDto.getProdutos() != null) user.setProdutos(userDto.getProdutos());

        UserModel saved = userRepository.save(user);
        return new UserDTO(saved);
    }
}
