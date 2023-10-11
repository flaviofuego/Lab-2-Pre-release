package Classes;

public class Game {
    Campo campo;
    int momento;

    public Game(Campo campo){
        this.campo = campo;
        this.momento = 0;
    }

    public void mostrarCampo(){
        campo.mostrarMatrizA();
    }
    
    public void setMomento(int momento){
        this.momento = momento;
    }

}
