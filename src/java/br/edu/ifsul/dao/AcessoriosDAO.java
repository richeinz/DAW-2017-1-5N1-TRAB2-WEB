
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Acessorios;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class AcessoriosDAO<T> extends DAOGenerico<Acessorios> implements Serializable {
    
    public AcessoriosDAO(){
        super();
        super.setClassePersistente(Acessorios.class);       
        super.setOrdem("id");
    }
   
}