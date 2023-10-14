package Classes;
import Frames.Jugadores;
import Frames.Relaciones;
import java.util.EventListener;

public interface evento extends EventListener{
    public void onSetCampo(Relaciones r);
    public void onSetCampo(Jugadores j);
}
