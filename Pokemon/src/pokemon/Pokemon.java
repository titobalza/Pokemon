package pokemon;

import edd.AVLTree;
import edd.Lista;

/** Superclase de pikachu y pachirisu, para instanciarlos a la hora de elegir con cu&aacutel jugar.
 *  sus subclases pues son pikachu y pachirisu, ellos extienden sus atributos y methods.
 *
 * @author Nelson Carrillo
 * @version 1.0 17 enero 2024
 */
abstract class Pokemon {
    int amistad; //Atributo de cada pokemon.
    AVLTree regalos = new AVLTree();
    Lista regalos2=new Lista();
    
    /**
    * Permite abrir el juego de las apuestas.
    * M&eacutetodo propuesto a polimorfismo tanto para pikachu como 
    * pachirisu.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024
    * @param user instancia del usuario que apostar&aacute y gana o pierde watts.
    */
    abstract int jugar(int saldo);
    abstract void verAmistad();
    
    /**
    * Se le da la amistad proveniente de un regalo.
    * M&eacutetodo sujeto a polimorfismo ya que pikachu acepta cualquier regalo
    * y pachirisu solo de bayas.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024.
    * @param n integer de la cantidad de amistad.
    */
    abstract void darAmistad(int n);
    
}
