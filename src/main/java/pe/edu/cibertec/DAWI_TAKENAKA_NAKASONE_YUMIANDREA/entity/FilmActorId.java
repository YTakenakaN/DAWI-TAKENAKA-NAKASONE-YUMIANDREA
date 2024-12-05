package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//Clase para la llave compuesta
@Embeddable
public class FilmActorId implements Serializable {
    private Integer filmId;
    private Integer actorId;

    public FilmActorId() {}

    public FilmActorId(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(filmId, that.filmId) &&
                Objects.equals(actorId, that.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorId);
    }
}
