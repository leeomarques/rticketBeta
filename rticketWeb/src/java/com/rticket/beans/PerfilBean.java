package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
import com.rticket.model.Perfil;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "perfilBean")
public class PerfilBean {

    private DualListModel<String> dualListModulo;
    private Collection<Modulo> listarModulo;
    private Collection<Perfil> listarPerfil;
    private String nome;
    private Perfil perfil;
    private Modulo modulo;

    IFachada fach = new Fachada();

    @PostConstruct
    public void init() {
    
        List<String> moduloSource = new ArrayList();
        List<String> moduloTarget = new ArrayList();
        
        Iterator<Modulo> iterator;
        
        iterator = fach.listarModulo().iterator();
        
        while(iterator.hasNext()) {
            Modulo item = (Modulo)iterator.next();
            moduloSource.add(item.getNome());
         }       
         
        dualListModulo = new DualListModel<String>(moduloSource, moduloTarget);        
    }
    
    public void inserirPerfil() throws CampoExistenteException, FormatoInvalidoException, CampoVazioException {
        Perfil per = new Perfil();
        per.setNome(nome);
  
        fach.inserirPerfil(per);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ModuloBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        fach.alterarPerfil(perfil);
    }
    
    public DualListModel<String> getDualListModulo() {
        return dualListModulo;
    }

    public void setDualListModulo(DualListModel<String> dualListModulo) {
        this.dualListModulo = dualListModulo;
    }

    public Collection<Modulo> getListarModulo() {

        return fach.listarModulo();
    }

    public void setListarModulo(Collection<Modulo> listarModulo) {
        this.listarModulo = listarModulo;
    }
    
    public Collection<Perfil> getListarPerfil() {
        return fach.listarPerfil();
    }

    public void setListarPerfil(Collection<Perfil> listarPerfil) {
        this.listarPerfil = listarPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
}
