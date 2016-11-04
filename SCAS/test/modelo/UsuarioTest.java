package modelo;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest extends TestCase{
    Usuario usuario;
    public void setUp() throws Exception{
        usuario = new Usuario();
    }
    public void testCalculaImpostoValor99(){
        assertEquals(0.00, usuario.calculaImposto(99));
    } 
    public void testCalculaImpostoValor100(){
        assertEquals(5.00, usuario.calculaImposto(100));
    } 
    public void testCalculaImpostoValor200(){
        assertEquals(20.00, usuario.calculaImposto(200));
    } 
    public void testCalculaImpostoValor300(){
        assertEquals(45.00, usuario.calculaImposto(300));
    } 
    public void testCalculaImpostoValor400(){
        assertEquals(68.00, usuario.calculaImposto(400));
    } 
    public void testCalculaImpostoValor500(){
        assertEquals(95.00, usuario.calculaImposto(500));
    } 
    public void testCalculaImpostoValor600(){
        assertEquals(126.00, usuario.calculaImposto(600));
    } 
    public void testCalculaImpostoValor700(){
        assertEquals(161.00, usuario.calculaImposto(700));
    } 
    public void testCalculaImpostoValor800(){
        assertEquals(200.00, usuario.calculaImposto(800));
    } 
    public void testCalculaImpostoValor900(){
        assertEquals(243.00000000000003, usuario.calculaImposto(900));
    } 
    public void testCalculaImpostoValor1000(){
        assertEquals(300.00, usuario.calculaImposto(1000));
    } 
}
