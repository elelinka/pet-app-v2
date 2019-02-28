package pl.petapp.keeper;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface KeeperRepository extends PagingAndSortingRepository<Keeper, Long> {
}
