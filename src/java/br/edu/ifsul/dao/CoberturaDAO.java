
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cobertura;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class CoberturaDAO<T> extends DAOGenerico<Cobertura> implements Serializable {
    
    public CoberturaDAO(){
        super();
        super.setClassePersistente(Cobertura.class);       
        super.setOrdem("id");
    }
   
}