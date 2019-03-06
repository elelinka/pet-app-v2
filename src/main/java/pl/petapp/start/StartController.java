package pl.petapp.start;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.petapp.pet.Pet;
import pl.petapp.pet.PetRepository;

import java.util.List;

@RestController
public class StartController {

    private PetRepository petRepository;

    public StartController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("")
    public String home(Model model) {
        List<Pet> pets = (List<Pet>) petRepository.findAll();
        model.addAttribute("pets",pets);
        return "../templates/index";
    }
}
