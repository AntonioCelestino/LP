package dao;

import java.util.List;
import modelo.Fornecedor;

public class FornecedorDAO extends GenericoDAO<Fornecedor>{

    private FornecedorDAO() {
    }

    public static List<Fornecedor> obterFornecedores() {
        return getInstance().obterClasses("select f from Fornecedor f", Fornecedor.class);
    }
}
