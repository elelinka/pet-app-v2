package pl.petapp.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.OwnerNotFoundException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("")
    public Page<Owner> findAll(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }

    @GetMapping("/id")
    public Owner findById(@PathVariable(name = "id") Long id) {
        Optional<Owner> owner = this.ownerRepository.findById(id);

        if (!owner.isPresent()) {
            throw new OwnerNotFoundException("Nie znaleziono właściciela o podanym id", id);
        }
        return owner.get();
    }

    @PostMapping("")
    public Owner create(@RequestBody @Valid Owner owner) {
        return ownerRepository.save(owner);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Owner owner) {
        ownerRepository.delete(owner);
    }
}
