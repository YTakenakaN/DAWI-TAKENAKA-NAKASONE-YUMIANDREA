package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;
    private Integer storeId;
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals;
}
