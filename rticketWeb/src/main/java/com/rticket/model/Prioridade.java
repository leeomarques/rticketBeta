package com.rticket.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PRIORIDADE")
public class Prioridade {
    
    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;

    @Column(name = "NOME", length = 100, nullable = false, unique = true)
    private String nome;
    
    @Column(name = "ATIVO", length = 1, nullable = true, unique = false)
    private String ativo;

    @OneToMany(mappedBy = "tipoChamados")
    private Collection<Chamados> chamados;
    
    public Prioridade(){
        
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Collection<Chamados> getChamados() {
        return chamados;
    }

    public void setChamados(Collection<Chamados> chamados) {
        this.chamados = chamados;
    }  
    
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof Prioridade) {
    		Prioridade prioridade = (Prioridade) obj;
        	return this.nome != null && 
        			this.nome.equals(prioridade.nome);
    	}
    	return false;
    }
}
