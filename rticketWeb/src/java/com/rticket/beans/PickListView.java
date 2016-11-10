package com.rticket.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean
public class PickListView {

    @ManagedProperty("#{themeService}")

    private DualListModel<String> cities;

    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();

        citiesSource.add("Cadastro de Módulo");
        citiesSource.add("Cadastro de Perfil");
        citiesSource.add("Cadastro de Status de Chamado");
        citiesSource.add("Cadastro de Tipos de Chamado");
        citiesSource.add("Cadastro de Usuário");
        citiesSource.add("Abrir Chamados");
        citiesSource.add("Admin");

        cities = new DualListModel<String>(citiesSource, citiesTarget);

    }

    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
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
