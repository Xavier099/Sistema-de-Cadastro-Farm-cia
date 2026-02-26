package farmacias.x.projectfarmacia.Produtos.DTO;

import farmacias.x.projectfarmacia.Produtos.Model.ProdutosModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {

    public ProdutosDTO map(ProdutosModel produtosModel){
        ProdutosDTO dto = new ProdutosDTO();
        dto.setId(produtosModel.getId());
        dto.setNameProduto(produtosModel.getNameProduto());
        dto.setQuantidade(produtosModel.getQuantidade());
        dto.setDecricaoProduto(produtosModel.getDescricaoProduto());
        dto.setUserModels(produtosModel.getUserModels());
        return dto;
    }

    public ProdutosModel map(ProdutosDTO produtosDTO){
        ProdutosModel pdm = new ProdutosModel();
        pdm.setId(produtosDTO.getId());
        pdm.setNameProduto(pdm.getNameProduto());
        pdm.setQuantidade(produtosDTO.getQuantidade());
        pdm.setDescricaoProduto(produtosDTO.getDecricaoProduto());
        pdm.setUserModels(produtosDTO.getUserModels());
        return pdm;
    }
}
