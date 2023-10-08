package Classes;

public class Game {
    Campo campo;
    int momento;

    public Game(Campo campo){
        this.campo = campo;
        this.momento = 0;
    }

    public void mostrargrafo(){
        System.out.println("Matriz de adyacencia:");
        for (int i = 0; i < campo.jugadores.size(); i++) {
            System.out.print(campo.jugadores.get(i).nombre + ",");
            for (int j = 0; j < campo.jugadores.size(); j++) {
                System.out.print(campo.matrizadyacencia[i][j] + ",");
            }
            System.out.println("");
        }
    }
    public void mostrarrutas(){
        System.out.println("Rutas:");
        for (int i = 0; i < campo.rutas.size(); i++) {
            System.out.print(campo.rutas.get(i) + ",");
        }
        System.out.println("");
    }
    public void cambiarmomento(int momento){
        this.momento = momento;
    }

}
