package pl.petapp.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.OwnerNotFoundException;

import java.util.List;

@RestController
//@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    // pobieranie całej listy
    @GetMapping("/owner")
    public List<Owner> list() {
        return (List<Owner>) ownerRepository.findAll();
    }

    // pobieranie konkretnego id
    @GetMapping("/owner/{id}")
    public Owner one(@PathVariable Long id) {

        return ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    // tworzenie nowego rekordu
    @PostMapping("/owner")
    //@ResponseStatus(HttpStatus.OK) // status odpowiedzi z serwera - 200 OK
    public Owner newOwner(@RequestBody Owner newPet) {
        return ownerRepository.save(newPet);
    }

    // update rekordu
    @PutMapping("/owner/{id}")
    public Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable Long id) {

        return ownerRepository.findById(id)
                .map(owner -> {
                    owner.setFirstname(newOwner.getFirstname());
                    owner.setLastname(newOwner.getLastname());
                    owner.setNickname(newOwner.getNickname());
                    owner.setPassword(newOwner.getPassword());
                    owner.setEmail(newOwner.getEmail());
                    return ownerRepository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return ownerRepository.save(newOwner);
                });
    }

    // usunięcie
    @DeleteMapping("/owner/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
    }
}
