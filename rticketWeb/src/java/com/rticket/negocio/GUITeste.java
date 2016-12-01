package com.rticket.negocio;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Chamados;
import com.rticket.model.Perfil;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.swing.JOptionPane;

public class GUITeste {
    public static void main(String[] args) 
            throws FormatoInvalidoException, CampoExistenteException, NoSuchAlgorithmException{
        try{
        IFachada fach = new Fachada();
        IFachada fach1 = new Fachada();
        
        Usuario user = new Usuario();
        Perfil perfil = new Perfil();
        
//        perfil.setNome("Administrador");
//        fach.inserirPerfil(perfil);
        
        perfil = fach.buscarPerfil(1);
        
        user.setNome("AntonioCorrea");
        user.setLogin("toinhotony");
        user.setSenha("1234");
        user.setPerfil(perfil);
        fach1.inserirUsuario(user);
          
        }catch(CampoVazioException e){
            JOptionPane.showMessageDialog(null, "Para fechar o chamado tem que informar a resposta e a nota");
        }
        
       

         /*Iterator<Modulo> iterator;
        
         iterator = fach.listarModulo().iterator();
        
        Laço para exibir a lista de Modulos.
         while(iterator.hasNext()) {
             Modulo item = (Modulo)iterator.next();
             System.out.println(item.getId()+" "+item.getNome());
         }*/
    }
}
