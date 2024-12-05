package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("filmId") // Vincula la parte de la clave compuesta con la entidad Film
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @MapsId("actorId") // Vincula la parte de la clave compuesta con la entidad Actor
    @JoinColumn(name = "actor_id")
    private Actor actor;

    private Date lastUpdate;
}

