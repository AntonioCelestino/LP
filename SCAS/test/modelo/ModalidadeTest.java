package modelo;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModalidadeTest extends TestCase{
    Modalidade modalidade;
    public void setUp() throws Exception{
        modalidade = new Modalidade();
    }
    public void testCalculaImpostoValor99(){
        assertEquals(0.00, modalidade.calculaImposto(99));
    } 
    public void testCalculaImpostoValor100(){
        assertEquals(5.00, modalidade.calculaImposto(100));
    } 
    public void testCalculaImpostoValor200(){
        assertEquals(20.00, modalidade.calculaImposto(200));
    } 
    public void testCalculaImpostoValor300(){
        assertEquals(45.00, modalidade.calculaImposto(300));
    } 
    public void testCalculaImpostoValor400(){
        assertEquals(68.00, modalidade.calculaImposto(400));
    } 
    public void testCalculaImpostoValor500(){
        assertEquals(95.00, modalidade.calculaImposto(500));
    } 
    public void testCalculaImpostoValor600(){
        assertEquals(126.00, modalidade.calculaImposto(600));
    } 
    public void testCalculaImpostoValor700(){
        assertEquals(161.00, modalidade.calculaImposto(700));
    } 
    public void testCalculaImpostoValor800(){
        assertEquals(200.00, modalidade.calculaImposto(800));
    } 
    public void testCalculaImpostoValor900(){
        assertEquals(243.00000000000003, modalidade.calculaImposto(900));
    } 
    public void testCalculaImpostoValor1000(){
        assertEquals(300.00, modalidade.calculaImposto(1000));
    } 
}
