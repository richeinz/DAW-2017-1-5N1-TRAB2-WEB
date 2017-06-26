
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;

/**
 *
 * @author Ricardo Heinz
 * @email ricvicheinz@gmail.com
 * 
 */
public class CarroDAO<T> extends DAOGenerico<Carro> implements Serializable {
    
    public CarroDAO(){
        super();
        super.setClassePersistente(Carro.class);       
        super.setOrdem("placa");
    }
   
}