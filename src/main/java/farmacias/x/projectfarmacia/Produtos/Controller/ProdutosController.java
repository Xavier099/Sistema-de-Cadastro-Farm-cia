package farmacias.x.projectfarmacia.Produtos.Controller;

import farmacias.x.projectfarmacia.Produtos.DTO.ProdutosDTO;
import farmacias.x.projectfarmacia.Produtos.Service.ProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/produtos")
@RestController
public class ProdutosController {

    private ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    public ResponseEntity<List<ProdutosDTO>> list(){
        List<ProdutosDTO> produtosDTOS = produtosService.list();
        return ResponseEntity.ok(produtosDTOS);
    }

    public ResponseEntity<?> listById(@PathVariable Long id){
        ProdutosDTO produtosDTO = produtosService.listByid(id);
        if (produtosDTO != null){
            ResponseEntity.ok(produtosDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com id: " + id + " não encontrado nos nossos registros!");
    }

    public ResponseEntity<String> create(@RequestBody ProdutosDTO produto){
        ProdutosDTO produtoCriado = produtosService.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto criado com sucesso, com o nome de: " + produtoCriado.getNameProduto() + " e id: " + produtoCriado.getId());
    }

    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProdutosDTO produtosDTO){
        ProdutosDTO produtos = produtosService.update(id, produtosDTO);
        if(produtos != null){
            return ResponseEntity.ok("Produto atualizado com sucesso:\n" + produtos);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com id: " + id + " não encontrado em nossos registros");
        }
    }

    public ResponseEntity<?> deletar(@PathVariable Long id){
       if (produtosService.listByid(id) != null ){
           produtosService.deletar(id);
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Produto com id: " + id + " deletado dos nossos registros!!");
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("Produto com id: " + id + " não encontrado em nossos registros");
    }
}
