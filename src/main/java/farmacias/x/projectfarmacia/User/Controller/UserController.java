package farmacias.x.projectfarmacia.User.Controller;

import farmacias.x.projectfarmacia.User.DTO.UserDTO;
import farmacias.x.projectfarmacia.User.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //list
    @GetMapping("/listar")
    public List<UserDTO> listar(){
        return userService.list();
    }

    //listById
    @GetMapping("/listarId/{id}")
    public UserDTO listarPorId(@PathVariable Long id){
        return userService.listByid(id);
    }

    //criar
    @PostMapping("/criar")
    public List<UserDTO> criar(@RequestBody List<UserDTO> userDTO){
        return userService.createUser(userDTO);
    }
    //deletar
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        userService.delete(id);
    }
}
