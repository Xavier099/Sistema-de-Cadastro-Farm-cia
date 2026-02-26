package farmacias.x.projectfarmacia.User;

import farmacias.x.projectfarmacia.Produtos.ProdutosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String name;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "cpf", unique = true)
    private String cpf;

    @Column (name = "email", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "usermodels")
    private ProdutosModel produtos;
}
