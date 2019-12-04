package club.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ApuntadoId implements Serializable {

	private Jugador jugador;
    private Partida partida;

	@ManyToOne
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@ManyToOne
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApuntadoId that = (ApuntadoId) o;

        if (partida != null ? !partida.equals(that.partida) : that.partida != null) return false;
        if (jugador != null ? !jugador.equals(that.jugador) : that.jugador != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (partida != null ? partida.hashCode() : 0);
        result = 31 * result + (jugador != null ? jugador.hashCode() : 0);
        return result;
    }
    
}
