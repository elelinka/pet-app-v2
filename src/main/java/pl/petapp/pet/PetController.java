package pl.petapp.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.PetNotFoundException;

import java.util.List;

@RestController
//@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    // pobieranie całej listy
    @GetMapping("/pet")
    public List<Pet> list() {
        return (List<Pet>) petRepository.findAll();
    }

    // pobieranie konkretnego id
    @GetMapping("/pet/{id}")
    public Pet one(@PathVariable Long id) {

        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }

    // tworzenie nowego rekordu
    @PostMapping("/pet")
    //@ResponseStatus(HttpStatus.OK) // status odpowiedzi z serwera - 200 OK
    public Pet newPet(@RequestBody Pet newPet) {
        return petRepository.save(newPet);
    }

    // update rekordu
    @PutMapping("/pet/{id}")
    public Pet replacePet(@RequestBody Pet newPet, @PathVariable Long id) {

        return petRepository.findById(id)
                .map(pet -> {
                    pet.setName(newPet.getName());
                    pet.setAge(newPet.getAge());
                    pet.setType(newPet.getType());
                    pet.setWight(newPet.getWight());
                    return petRepository.save(pet);
                })
                .orElseGet(() -> {
                    newPet.setId(id);
                    return petRepository.save(newPet);
                });
    }

    // usunięcie
    @DeleteMapping("/pet/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }
}
