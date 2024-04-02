package pokemon;
import java.util.Random;
import java.util.Scanner;

/**
 * Subclase de pokemon.
 * Pues pikachu es un tipo de pokemon, y al modificar la opci&oacuten de 
 * elegir si usar a pachirisu o pikachu se cre&oacute esta herencia.
 * 
 * @author nelsoncarrillo
 * @version 1.0 17 enero 2024
 */
public class Pikachu extends Pokemon{
    Scanner myObje = new Scanner(System.in); //para los inputs por consola.
    
    /**
    * Disminuye en 1 unidad la amistad del pikachu.
    * Es creado para la funcionalidad de que se pierde 1 de amistad por cada 
    * segundo que pase.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    */
    public void restaram(){
        this.amistad-=1;
    }
    
    /**
    * Se le da la amistad proveniente de un regalo.
    * La unica manera de obtener amistad es mediante un regalo
    * y asi se le suma su valor.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024.
    * @param n integer de la cantidad de amistad.
    */
    public void darAmistad(int n){
        this.amistad+=n;
    }
    
    /**
    * Devuelve la amistad de la instancia del pikachu.
    * Es el getter del atributo amistad del pikachu.
    * 
    *
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    * @return Integer de la amistad del pikachu a un instante dado
    */
    public long getAmistad(){
        return this.amistad;
    }
    
    /**
    * Imprime por pantalla el ascii art del pikachu acorde a su amistad.
    * Se especifican unos rangos del nivel de amistad que sabemos que va de 0
    * hasta 10000 y entre ellos la actitud del pikachu cambia.
    * 
    *
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024   
    */
    public void verAmistad(){
        System.out.println("");
        System.out.println("NIVEL DE AMISTAD:    "+this.amistad);
        if(10000>= this.amistad & this.amistad >=7500){
            System.out.println("");
            System.out.println(" |\\---/|");
            System.out.println(" | ^_^ |");
            System.out.println("  \\_^_/");
        } else if(7500> this.amistad & this.amistad >=5000){
                        System.out.println("");
            System.out.println(" |\\---/|");
            System.out.println(" | O_O |");
            System.out.println("  \\_^_/");
        }else if(5000> this.amistad & this.amistad >=2500){
                        System.out.println("");

            System.out.println(" |\\---/|");
            System.out.println(" | >_< |");
            System.out.println("  \\_^_/");
        }else if(2500> this.amistad & this.amistad >=0){
                        System.out.println("");
            System.out.println(" |\\---/|");
            System.out.println(" | T_T |");
            System.out.println("  \\_^_/");
        }
        System.out.println("");
    }
    
    /**
    * Permite abrir el juego de las apuestas.
    * M&eacutetodo propuesto a polimorfismo tanto para pikachu como 
    * pachirisu.
    * 
    * @author nelsoncarrillo
    * @version 1.0 17 enero 2024
    * @param user instancia del usuario que apostar&aacute y gana o pierde watts.
    */
    void jugar(Usuario user){
        int opt=0;
        int apt=0;
        Random r = new Random();
        int cartaActual = r.nextInt(10) + 1;
        while(opt==0){
            System.out.println("");
            System.out.println("LA CARTA ACTUAL DE PIKACHU: " +cartaActual);
            System.out.println("Ingrese 1 para ingresar apuesta a que sera mayor.");
            System.out.println("Ingrese 2 para ingresar apuesta a que sera menor.");
            System.out.println("Ingrese 3 para regresar.");
            while(opt!=1 & opt!=2 & opt!=3){
            System.out.println("Ingrese ->");
            opt= myObje.nextInt();
            }
            if(opt==1){
                System.out.println("");
                System.out.println("INGRESE apuesta: "); 
                apt= myObje.nextInt();
                boolean t = user.apostar(apt);
                if(t==true){
                    int cartaActul = r.nextInt(10) + 1;
                    System.out.println("CARTA EN MESA: "+cartaActul);
                    if(cartaActul>cartaActual){
                        user.ganarapostar(apt);
                    }else {
                        user.perderapostar(apt);
                    }
                    cartaActual=cartaActul;
                }

            }else if (opt==3){
                break;
            }else if (opt==2){
                System.out.println("");
                System.out.println("INGRESE apuesta: "); 
                apt= myObje.nextInt();
                boolean t = user.apostar(apt);
                if(t==true){
                    int cartaActul = r.nextInt(10) + 1;
                    System.out.println("CARTA EN MESA: "+cartaActul);
                    if(cartaActul<cartaActual){
                        user.ganarapostar(apt);
                    }else {
                        user.perderapostar(apt);
                    }
                    cartaActual=cartaActul;
                }
                
            }
        }
        
    }

    
    
    
    

    }




