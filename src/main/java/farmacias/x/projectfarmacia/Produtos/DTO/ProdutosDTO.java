package farmacias.x.projectfarmacia.Produtos.DTO;

import farmacias.x.projectfarmacia.User.Model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO {
    private Long id;
    private String nameProduto;
    private Integer quantidade;
    private String decricaoProduto;
    private List<UserModel> userModels;
}
