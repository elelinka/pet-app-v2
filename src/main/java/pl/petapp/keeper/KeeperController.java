package pl.petapp.keeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.KeeperNotFoundException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/keeper")
public class KeeperController {

    @Autowired
    private KeeperRepository keeperRepository;

    @GetMapping("")
    public Page<Keeper> findAll(Pageable pageable) {
        return keeperRepository.findAll(pageable);
    }

    @GetMapping("/id")
    public Keeper findById(@PathVariable(name = "id") Long id) {
        Optional<Keeper> keeper = this.keeperRepository.findById(id);

        if (!keeper.isPresent()) {
            throw new KeeperNotFoundException("Nie znaleziono opiekuna o podanym id", id);
        }
        return keeper.get();
    }

    @PostMapping("")
    public Keeper create(@RequestBody @Valid Keeper keeper) {
        return keeperRepository.save(keeper);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Keeper keeper) {
        keeperRepository.delete(keeper);
    }
}
