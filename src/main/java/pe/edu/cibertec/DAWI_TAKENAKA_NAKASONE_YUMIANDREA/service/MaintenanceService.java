package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.service;

import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto.*;
import java.util.List;


public interface MaintenanceService {

    List<FilmDto> findAllFilms();
    FilmDetailDto findFilmById(int id);

    boolean updateFilm(FilmDetailDto filmDetailDto);

    boolean removeFilm(FilmDetailDto filmDetailDto);

    boolean addFilm(FilmDetailDto filmDetailDto);
}
