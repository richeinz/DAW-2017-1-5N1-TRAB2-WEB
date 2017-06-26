
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Sinistro;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class SinistroDAO<T> extends DAOGenerico<Sinistro> implements Serializable {
    
    public SinistroDAO(){
        super();
        super.setClassePersistente(Sinistro.class);       
        super.setOrdem("id");
    }
   
}