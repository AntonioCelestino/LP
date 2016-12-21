/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertTrue;
import static org.easymock.EasyMock.*;

/**
 *
 * @author Nathan
 */
public class TesteMockCursoDAO extends TestCase {
    /** Creates a new instance of TesteDAO
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException */
    
    public void testPersistirCursoDAO() throws SQLException, ClassNotFoundException{
        Curso curso = new Curso();
        curso.setCodCurso(1);
        curso.setNome("curso");
        curso.setTipoEnsino("tipo");
        curso.setTurno("manha");
        DAO cursoDAO = CursoDAO.getInstanceMock();
    
        assertTrue(curso.persistir(cursoDAO));
        assertTrue(curso.eliminar(cursoDAO));
    }
    
    public void testPersistirCursoDAOMock() throws SQLException, ClassNotFoundException {
        Curso curso = new Curso();
        curso.setCodCurso(1);
        
        DAO cursoDAOMock = createMock(DAO.class);
        expect(cursoDAOMock.persistir(curso)).andReturn(true);
        expect(cursoDAOMock.eliminar(curso)).andReturn(true);
        replay(cursoDAOMock);
        
        assertTrue(curso.persistir(cursoDAOMock));
        assertTrue(curso.eliminar(cursoDAOMock));
    }
}
