package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "film_category")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("categoryId") // Vincula la parte de la clave compuesta con la entidad Category
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @MapsId("filmId") // Vincula la parte de la clave compuesta con la entidad Film
    @JoinColumn(name = "film_id")
    private Film film;

    private Date lastUpdate;
}
