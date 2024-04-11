package cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruita createFruit(Fruita fruita) {
        Fruita newFruita;
        try {
            newFruita = fruitRepository.save(new Fruita(fruita.getName(), fruita.getQuantityKg()));
        } catch (Exception e) {
            System.out.println("Error al crear la fruta. " + e.getMessage() + e.getStackTrace());
            newFruita = null;
        }
        return newFruita;
    }
    public Fruita update(Fruita fruita) {
        Optional<Fruita> optionalFruita = fruitRepository.findById(fruita.getId());
        Fruita fruitaUpdate;

        try {
            optionalFruita.isPresent();
            fruitaUpdate = optionalFruita.get();
            fruitaUpdate.setName(fruita.getName());
            fruitaUpdate.setQuantityKg(fruita.getQuantityKg());
            fruitRepository.save(fruitaUpdate);
        } catch (Exception e) {
            fruitaUpdate = null;
            System.out.println("Error al actualizar información.");
        }
        return fruitaUpdate;
    }
    public boolean delete(int id) {
        boolean isDeleted;

        try {
            fruitRepository.deleteById(id);
            isDeleted = true;
        } catch (Exception e) {
            System.out.println("No se ha podido borrar.");
            isDeleted = false;
        }
        return isDeleted;
    }

    public Fruita getOne(int id) {
        return fruitRepository.findById(id).orElse(null);
    }

    public List<Fruita> getAll() {

        return this.fruitRepository.findAll();
    }
}
