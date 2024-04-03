/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author nelsoncarrillo
 */
public class Regalo {
    private int costo;
    public int amistad;
    private String nombre;
    
    public Regalo(int auxFinale){
        this.costo=auxFinale;
        switch (auxFinale) {
            case 100:
                this.nombre = "BayaAranja";
                this.amistad=100;
                // Resto del código para cuando auxFinale es igual a 100
                break;
            case 200:
                this.nombre = "BayaCaquic";
                this.amistad=250;
                // Resto del código para cuando auxFinale es igual a 200
                break;
            case 300:
                this.nombre = "PokeBall";
                this.amistad=400;
                // Resto del código para cuando auxFinale es igual a 300
                break;
            case 400:
                this.nombre = "BayaZreza";
                this.amistad=550;
                // Resto del código para cuando auxFinale es igual a 400
                break;
            case 500:
                this.nombre = "BayaZanama";
                this.amistad=700;
                // Resto del código para cuando auxFinale es igual a 500
                break;
            case 600:
                this.nombre = "BayaZiuela";
                this.amistad=850;
                // Resto del código para cuando auxFinale es igual a 600
                break;
            case 700:
                this.nombre = "BayaZidra";
                this.amistad=1000;
                // Resto del código para cuando auxFinale es igual a 700
                break;
            case 800:
                this.nombre = "BayaEnigma";
                this.amistad=1150;
                // Resto del código para cuando auxFinale es igual a 800
                break;
            case 900:
                this.nombre = "CarameloRaro";
                this.amistad=1300;
                // Resto del código para cuando auxFinale es igual a 900
                break;
            default:
                break;
        }
        
    }

    /**
     * @return the costo
     */
    public int getCosto() {
        return costo;
    }
    
    public int getAmistad() {
        return amistad;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
