package pl.petapp.keeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.petapp.common.KeeperNotFoundException;

import java.util.List;

@RestController
//@RequestMapping("/keeper")
public class KeeperController {

    @Autowired
    private KeeperRepository keeperRepository;

    // pobieranie całej listy
    @GetMapping("/keeper")
    public List<Keeper> list() {
        return (List<Keeper>) keeperRepository.findAll();
    }

    // pobieranie konkretnego id
    @GetMapping("/keeper/{id}")
    public Keeper one(@PathVariable Long id) {

        return keeperRepository.findById(id)
                .orElseThrow(() -> new KeeperNotFoundException(id));
    }

    // tworzenie nowego rekordu
    @PostMapping("/keeper")
    //@ResponseStatus(HttpStatus.OK) // status odpowiedzi z serwera - 200 OK
    public Keeper newKeeper(@RequestBody Keeper newKeeper) {
        return keeperRepository.save(newKeeper);
    }

    // update rekordu
    @PutMapping("/keeper/{id}")
    public Keeper replaceKeeper(@RequestBody Keeper newKeeper, @PathVariable Long id) {

        return keeperRepository.findById(id)
                .map(keeper -> {
                    keeper.setName(newKeeper.getName());
                    return keeperRepository.save(keeper);
                })
                .orElseGet(() -> {
                    newKeeper.setId(id);
                    return keeperRepository.save(newKeeper);
                });
    }

    // usunięcie
    @DeleteMapping("/keeper/{id}")
    public void deleteKeeper(@PathVariable Long id) {
        keeperRepository.deleteById(id);
    }
}
