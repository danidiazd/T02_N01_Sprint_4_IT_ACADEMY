package cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruit(@RequestBody Fruita fruita) {
        return ResponseEntity.ok().body(this.fruitaService.createFruit(fruita));
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> updateFruit(@RequestBody Fruita fruita) {
        return ResponseEntity.ok().body(this.fruitaService.update(fruita));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruita> deleteFruit(@PathVariable("id") int id) {
        ResponseEntity<Fruita> responseEntity;

        if (fruitaService.delete(id)) {
            responseEntity = ResponseEntity.noContent().build();
        } else  {
            responseEntity = ResponseEntity.internalServerError().build();
        }
        return responseEntity;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneFruit(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(this.fruitaService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruits() {
     return ResponseEntity.ok().body(this.fruitaService.getAll());
    }
}
