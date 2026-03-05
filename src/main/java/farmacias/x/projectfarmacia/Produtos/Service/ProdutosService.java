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
    public ProdutosDTO createProduto(ProdutosDTO produtosDTO){
        ProdutosModel produtos = produtosMapper.map(produtosDTO);
        produtos = produtosRepository.save(produtos);
        return produtosMapper.map(produtos);
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

    //update
    public ProdutosDTO update(Long id, ProdutosDTO produtosDTO){
        Optional<ProdutosModel> produtos = produtosRepository.findById(id);
        if (produtos.isPresent()){
            ProdutosModel produtoModel = produtosMapper.map(produtosDTO);
            produtoModel.setId(id);
            ProdutosModel produtoAtualizado = produtosRepository.save(produtoModel);
            return produtosMapper.map(produtoAtualizado);
        }
        return null;
    }

    //delete by id
    public void deletar(Long id){
        produtosRepository.deleteById(id);
    }

}
