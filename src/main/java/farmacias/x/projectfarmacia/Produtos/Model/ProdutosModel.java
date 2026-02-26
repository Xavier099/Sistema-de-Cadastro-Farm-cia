package farmacias.x.projectfarmacia.Produtos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import farmacias.x.projectfarmacia.User.Model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tb_produtos")
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome_produto")
    private String nameProduto;

    @Column (name = "quantidade")
    private Integer quantidade;

    @Column (name = "descricao")
    private String descricaoProduto;

    @OneToMany(mappedBy = "produtos" )
    @JsonIgnore
    private List<UserModel> userModels;

}
