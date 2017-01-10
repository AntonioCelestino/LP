package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Fornecedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-10T14:43:29")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Float> preco;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, Fornecedor> fornecedorId;
    public static volatile SingularAttribute<Produto, Integer> quantidade;

}