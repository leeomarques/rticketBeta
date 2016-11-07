package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

@ManagedBean(name = "moduloBean")
public class ModuloBean {

    private Modulo modulo;
    private String nome;

    IFachada fach = new Fachada();

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void inserirModulo(){
        try{
            modulo.setNome(this.nome);
            fach.inserirModulo(modulo);
        }catch(CampoExistenteException e){
            JOptionPane.showMessageDialog(null, e);
        }catch(CampoVazioException e){
            JOptionPane.showMessageDialog(null, e);
        }catch(FormatoInvalidoException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }

    public Modulo buscarModulo(int id) {
        return fach.buscarModulo(id);
    }

    public void alterarModulo(Modulo modulo) {
        fach.alterarModulo(modulo);
    }

    public Collection<Modulo> listarModulo() {
        return fach.listarModulo();
    }
}
