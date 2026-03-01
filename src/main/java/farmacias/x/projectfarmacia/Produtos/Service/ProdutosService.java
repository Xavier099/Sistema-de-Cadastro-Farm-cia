package farmacias.x.projectfarmacia.Produtos.Service;

import farmacias.x.projectfarmacia.Produtos.DTO.ProdutosDTO;
import farmacias.x.projectfarmacia.Produtos.DTO.ProdutosMapper;
import farmacias.x.projectfarmacia.Produtos.Model.ProdutosModel;
import farmacias.x.projectfarmacia.Produtos.Repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {
    private ProdutosRepository produtosRepository;
    private ProdutosMapper produtosMapper;

    public ProdutosService(ProdutosRepository produtosRepository, ProdutosMapper produtosMapper) {
        this.produtosRepository = produtosRepository;
        this.produtosMapper = produtosMapper;
    }

    //create
    public List<ProdutosDTO> createProduto(List<ProdutosDTO> produtosDTO){
        List<ProdutosModel> produto = produtosDTO.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
        List<ProdutosModel> productSave = produtosRepository.saveAll(produto);
        return productSave.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
    }

    //list
    public List<ProdutosDTO> list(){
        List<ProdutosModel> produtosModels = produtosRepository.findAll();
        return produtosModels.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
    }

    //list by id
    public ProdutosDTO listByid(Long id){
        Optional<ProdutosModel> listByid = produtosRepository.findById(id);
        return listByid.map(produtosMapper::map).orElse(null);
    }

    //delete by id
    public void deletar(Long id){
        produtosRepository.deleteById(id);
    }

}
