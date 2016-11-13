/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 *
 * @author Nathan
 */
public interface DAO {
    public boolean persistir(Curso curso) throws SQLException, ClassNotFoundException;
    public boolean eliminar(Curso curso) throws SQLException, ClassNotFoundException;
}
