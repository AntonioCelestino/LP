package dao;

import java.util.List;
import modelo.Produto;

public class ProdutoDAO extends GenericoDAO<Produto>{
    
    private ProdutoDAO(){
    }
    
    public static List<Produto> obterProdutos(){
        return getInstance().obterClasses("select p from Produto p", Produto.class);
    }
}
