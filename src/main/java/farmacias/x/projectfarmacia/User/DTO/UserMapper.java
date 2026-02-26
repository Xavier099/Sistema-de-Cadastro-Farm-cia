package farmacias.x.projectfarmacia.User.DTO;

import farmacias.x.projectfarmacia.User.Model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setTelefone(userModel.getTelefone());
        userDTO.setCpf(userModel.getCpf());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setProdutos(userModel.getProdutos());
        return userDTO;
    }

    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setTelefone(userDTO.getTelefone());
        userModel.setCpf(userDTO.getCpf());
        userModel.setEmail(userDTO.getEmail());
        userModel.setProdutos(userDTO.getProdutos());
        return userModel;
    }

}
