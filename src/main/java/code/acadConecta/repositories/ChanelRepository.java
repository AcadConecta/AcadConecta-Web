package code.acadConecta.repositories;

import code.acadConecta.model.entities.Chanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChanelRepository extends JpaRepository<Chanel, Long> {
}
