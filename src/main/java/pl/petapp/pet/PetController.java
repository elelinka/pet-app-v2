package pl.petapp.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.PetNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> list() {
        return (List<Pet>) petRepository.findAll();
    }

    @GetMapping("/pet/id")
    public Pet findById(@PathVariable(name = "id") Long id) {
        Optional<Pet> pet = this.petRepository.findById(id);

        if (!pet.isPresent()) {
            throw new PetNotFoundException("Nie znaleziono zwierzaka o podanym id", id);
        }
        return pet.get();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK) // status odpowiedzi z serwera - 200 OK
    public void create(@RequestBody Pet pet) {
        petRepository.save(pet);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Pet pet) {
        petRepository.delete(pet);
    }
}
