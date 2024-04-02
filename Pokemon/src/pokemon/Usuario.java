package pokemon;

/**
 * Clase que representa al usuario que interact&uacutea con el pokemon.
 * Tenemos las clases de los pokemones y todo lo que les envuelve, sin embargo
 * se consideraba necesario almacenar lo que se le atribuye al usuario en una clase
 * la cual se presenta.
 * 
 * @author nelsoncarrillo
 * @version 1.0 17 enero 2024
 */
public class Usuario {
    
    private int cash; //Saldo en watts.

    /**
    * Devuelve la cantidad de watts que tiene el usuario.
    * Es el getter del atributo cash del usuario.
    * 
    *
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    * @return Integer de la cantidad de watts.
    */
    public int getCash() {
        return this.cash;
    }
    
    /**
    * Establece una cantidad de watts a la cartera digamos del usuario.
    * Es el setter del atributo cash del usuario.
    * 
    *
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    * @param cas integer que representa la cantidad a adjudicar.
    */
    public void setCash(int cas) {
        this.cash =cas;
    }
    
    /**
    * Aumenta en 1 unidad los watts del usuario.
    * Es creado para la funcionalidad de que se gane 1 watt por cada 
    * segundo que pase.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    * @param n se establece en el thread como 1 para un watt a sumar.
    */
    public void sumarCash(int n) {
        this.cash+=n;
    }
    
    
    
    /**
     * Permite apostar al usuario dependiendo de su cash.
     * Si dispone del que desea apostar, pues esta se realizar&aacute
     * 
     * @author nelsoncarrillo
     * @version 1.0 17 enero 2024
     * @param c en watts de la apuesta 
     */
    public boolean apostar(int c){
        if(this.cash>=c){
           this.cash-=c; 
           return true;
        }else{
            throw new IllegalStateException("Saldo insuficiente");
        }
        
    }
    
    /**
     * Al apostar, el usuario tiene atributo de duplicar su apuesta.
     * Si la gana pues se duplica lo apostado. 
     * 
     * @author nelsoncarrillo
     * @version 1.0 17 enero 2024
     * @param c  integer de la apuesta realizada en watts.
     */
    public void ganarapostar(int c){
        this.cash+=(2*c);
        
    }
    
    /**
     * Al apostar, el usuario tiene atributo de perder pues toda la apuesta.
     * Pierde y se pasa la apuesta. 
     * 
     * @author nelsoncarrillo
     * @version 1.0 17 enero 2024
     * @param c integer de la apuesta realizada
     */
    public void perderapostar(int c){
        System.out.println("PERDISTE.");
    }
}
