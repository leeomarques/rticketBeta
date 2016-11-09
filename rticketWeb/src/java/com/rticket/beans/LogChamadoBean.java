package com.rticket.beans;

import com.rticket.model.LogChamado;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "logChamadoBean")
public class LogChamadoBean {
    
    private Collection<LogChamado> listarLogChamado;
    
    IFachada fach = new Fachada();
    
    public Collection<LogChamado> getListarLogChamado() {
        this.listarLogChamado = fach.listarLogChamados();
        return this.listarLogChamado;
    }

    public void setListarLogChamado(Collection<LogChamado> listarLogChamado) {
        this.listarLogChamado = listarLogChamado;
    }
}
