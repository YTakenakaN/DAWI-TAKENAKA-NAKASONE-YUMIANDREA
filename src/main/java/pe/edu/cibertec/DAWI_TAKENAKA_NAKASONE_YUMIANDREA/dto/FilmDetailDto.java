package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto;

import java.util.Date;

public record FilmDetailDto(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        String languageName,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Date lastUpdate,
        Integer languageId
) {
}
