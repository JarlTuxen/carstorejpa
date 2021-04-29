package dk.kea.carstorejpa.controller;

import dk.kea.carstorejpa.model.Mod;
import dk.kea.carstorejpa.model.Note;
import dk.kea.carstorejpa.service.BrandService;
import dk.kea.carstorejpa.service.ModService;
import dk.kea.carstorejpa.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModController {

    @Autowired
    ModService modService;

    @Autowired
    BrandService brandService;

    @Autowired
    NoteService noteService;

    @GetMapping("/mods")
    public String mods(Model model){
        model.addAttribute("mods", modService.findAll());
        return "mods";
    }

    @GetMapping("/create")
    public String create(Model model){
        //tilføj liste af brands, så der kan vælges brand
        model.addAttribute("brands", brandService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Mod mod){
        Mod newMod = modService.create(mod);

        //opret ny note med newMod som reference
        Note note = new Note("tilføj noter", newMod);
        noteService.create(note);

        //sæt reference til note i newMod
        newMod.setNote(note);
        modService.update(newMod);

        return "redirect:/mods";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model modelMods, Model modelBrands){
        modelMods.addAttribute("mods", modService.findById(id));
        //add brands to choose from
        modelBrands.addAttribute("brands", brandService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Mod mod){
        //update by using update service
        modService.update(mod);
        return "redirect:/mods";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        modService.deleteById(id);
        return "redirect:/mods";
    }

    @GetMapping("/updateNote/{id}")
    public String updateNote(@PathVariable("id") long id, Model model){
        model.addAttribute("note", noteService.findById(id));
        return "updateNote";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Note note){
        //update by using update service
        noteService.update(note);
        return "redirect:/mods";
    }

}
