
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Corretor;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class CorretorDAO<T> extends DAOGenerico<Corretor> implements Serializable {
    
    public CorretorDAO(){
        super();
        super.setClassePersistente(Corretor.class);       
        super.setOrdem("nome");
    }
   
}