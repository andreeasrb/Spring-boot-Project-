package repo;

import entity.Materie;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterieRepository extends CrudRepository<Materie, Long>{

}
