package farmacias.x.projectfarmacia.User.Controller;

import farmacias.x.projectfarmacia.User.DTO.UserDTO;
import farmacias.x.projectfarmacia.User.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> listar(){
        List<UserDTO> user = userService.list();
        return ResponseEntity.ok(user);
    }

    //listById
    @GetMapping("/listarId/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        UserDTO userId = userService.listByid(id);
        if(userId != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body("Usuario encontrado: \n" + userId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario com id: " + id + " não encontrado em nossos registros!");
    }

    //criar
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody UserDTO userDTO){
        UserDTO user =  userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario criado com sucesso!!");
    }

    //update
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        UserDTO userUpdate = userService.update(id, userDTO);
        if(userService.listByid(id) != null){
            return ResponseEntity.ok("Usuario atualizado: \n" + userUpdate);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario com id: " + id + " não encontrado em nossos registros");
    }
    //deletar
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        if (userService.listByid(id) != null){
            return ResponseEntity.ok("Usuario com id: " + id + " deletado com sucesso!!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario com id: " + id + " não encontrado em nossos registros");
    }
}
