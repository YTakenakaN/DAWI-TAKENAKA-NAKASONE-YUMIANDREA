package pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.dto.FilmDto;
import pe.edu.cibertec.DAWI_TAKENAKA_NAKASONE_YUMIANDREA.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    //Lo que se retorna es el html, un string
    public String start(Model model){
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("film", new FilmDetailDto(null,"","",null,"",null,null,null,null,"","",null,null));
        return "maintenance_add";
    }

    @PostMapping("/add-confirm")
    public String addConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.addFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        maintenanceService.removeFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }


}
