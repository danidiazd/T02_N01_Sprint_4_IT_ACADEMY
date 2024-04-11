package cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruita, Integer> {
}
