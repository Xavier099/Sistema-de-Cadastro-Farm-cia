package farmacias.x.projectfarmacia.User.DTO;

import farmacias.x.projectfarmacia.Produtos.Model.ProdutosModel;
import farmacias.x.projectfarmacia.User.Model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String telefone;
    private String cpf;
    private String email;
    private ProdutosModel produtos;

    public UserDTO(UserModel saved) {
    }
}
