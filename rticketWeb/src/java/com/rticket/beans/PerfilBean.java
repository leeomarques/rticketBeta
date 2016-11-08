package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
import com.rticket.model.Perfil;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
//import org.primefaces.model.DualListModel;

@ManagedBean(name = "perfilBean")
public class PerfilBean {

    private Collection<Modulo> modEsq = new ArrayList<Modulo>();
    private Collection<Modulo> modDir = new ArrayList<Modulo>();
    //private DualListModel<Modulo> modulos;

    IFachada fach = new Fachada();

    public void inserirPerfil(Perfil perfil) throws CampoExistenteException, FormatoInvalidoException, CampoVazioException {
        fach.inserirPerfil(perfil);
    }

    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        fach.alterarPerfil(perfil);
    }

    public Collection<Perfil> listarPerfil() {
        return fach.listarPerfil();
    }

    public Collection<Modulo> getModEsq() {
        return modEsq;
    }

    public void setModEsq(Collection<Modulo> modEsq) {
        this.modEsq = modEsq;
    }

    public Collection<Modulo> getModDir() {
        return modDir;
    }

    public void setModDir(Collection<Modulo> modDir) {
        this.modDir = modDir;
    }

    /*public DualListModel<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(DualListModel<Modulo> modulos) {
        this.modulos = modulos;
    }*/

}
