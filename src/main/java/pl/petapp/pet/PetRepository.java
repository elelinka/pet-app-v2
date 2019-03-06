package pl.petapp.pet;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {
}
