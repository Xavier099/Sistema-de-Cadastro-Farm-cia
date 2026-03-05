package farmacias.x.projectfarmacia.Produtos.Controller;

import farmacias.x.projectfarmacia.Produtos.DTO.ProdutosDTO;
import farmacias.x.projectfarmacia.Produtos.Service.ProdutosService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/produtos")
@RestController
public class Controller {

    private ProdutosService produtosService;

    public Controller(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    public List<ProdutosDTO> list(){
        return produtosService.list();
    }

    public ProdutosDTO listById(@PathVariable Long id){
        return produtosService.listByid(id);
    }

    public List<ProdutosDTO> create(@RequestBody List<ProdutosDTO> user){
        return produtosService.createProduto(user);
    }

    public ProdutosDTO updateProduct(@PathVariable Long id,@RequestBody ProdutosDTO produtosDTO){
        return produtosService.update(id, produtosDTO);
    }

    public void deletar(@PathVariable Long id){
        produtosService.deletar(id);
    }
}
