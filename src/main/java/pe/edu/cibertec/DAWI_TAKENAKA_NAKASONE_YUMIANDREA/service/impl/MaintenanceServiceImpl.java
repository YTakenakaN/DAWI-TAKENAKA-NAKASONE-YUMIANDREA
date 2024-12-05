package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto.FilmDto;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity.Film;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity.Language;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.repository.FilmRepository;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.repository.LanguageRepository;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.service.MaintenanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<FilmDto> findAllFilms() {

        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto= new FilmDto(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getDescription(),
                    film.getLanguage().getName(),
                    film.getRentalRate());
                    films.add(filmDto);
        });
        return films;
    }

    @Override
    public FilmDetailDto findFilmById(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                (film) -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate(),
                        0)
        ).orElse(null);
    }

    @Override
    public boolean updateFilm(FilmDetailDto filmDetailDto) {

        Optional<Film> optional=filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public boolean removeFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    filmRepository.delete(film);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public boolean addFilm(FilmDetailDto filmDetailDto) {
        return languageRepository.findById(filmDetailDto.languageId())
                .map(language -> {
                    Film film = new Film();
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    film.setLanguage(language);

                    filmRepository.save(film);
                    return true;
                })
                .orElse(false);
    }

}



