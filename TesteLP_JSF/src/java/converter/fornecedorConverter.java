package converter;

import dao.FornecedorDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Fornecedor;

@FacesConverter(forClass = Fornecedor.class, value="fornecedorConverter")
public class fornecedorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string != null && !string.equals("")){
            Integer id = Integer.valueOf(string);
            return FornecedorDAO.getInstance().obterClasse(Fornecedor.class, id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null && !o.equals("")){
            Fornecedor f = (Fornecedor) o;
            return f.getId().toString();
        }
        return null;
    }
    
}
