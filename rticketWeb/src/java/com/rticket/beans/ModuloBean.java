package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;
import javax.faces.context.FacesContext;

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
        
        
    private String nome;
    private Collection<Modulo> listarModulo;

    IFachada fach = new Fachada();

    public void inserirModulo() throws CampoExistenteException, FormatoInvalidoException, CampoVazioException {
        Modulo mdl = new Modulo();
        mdl.setNome(nome);

        fach.inserirModulo(mdl);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("modulo.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ModuloBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Modulo buscarModulo(int id) {
        return fach.buscarModulo(id);
    }

    public void alterarModulo(Modulo modulo) {
        fach.alterarModulo(modulo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Modulo> getListarModulo() {
        this.listarModulo = fach.listarModulo();
        return this.listarModulo;

    }

    public void setListarModulo(Collection<Modulo> listarModulo) {
        this.listarModulo = listarModulo;
    }

}
