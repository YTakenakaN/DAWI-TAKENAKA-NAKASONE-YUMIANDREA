package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor {

    @Id
    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> filmActors = new ArrayList<>();
}
