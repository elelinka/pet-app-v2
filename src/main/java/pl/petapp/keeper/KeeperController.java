package pl.petapp.keeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.KeeperNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/keeper")
public class KeeperController {

    @Autowired
    private KeeperRepository keeperRepository;

    @GetMapping
    public List<Keeper> list() {
        return (List<Keeper>) keeperRepository.findAll();
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
