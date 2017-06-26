
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Seguro;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class SeguroDAO<T> extends DAOGenerico<Seguro> implements Serializable {
    
    public SeguroDAO(){
        super();
        super.setClassePersistente(Seguro.class);       
        super.setOrdem("id");
    }
   
}