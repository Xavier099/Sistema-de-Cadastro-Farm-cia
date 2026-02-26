package farmacias.x.projectfarmacia.Produtos.Repository;

import farmacias.x.projectfarmacia.Produtos.Model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}
