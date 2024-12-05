package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.entity.Film;

import org.springframework.cache.annotation.Cacheable;

public interface FilmRepository  extends CrudRepository<Film, Integer> {

    @Cacheable(value="films")
    Iterable<Film> findAll();

    @CacheEvict(value="films",allEntries=true)
    Film save(Film film);

    @CacheEvict(value="films",allEntries=true)
    void delete(Film film);
}
