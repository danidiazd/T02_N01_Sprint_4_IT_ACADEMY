package cat.itacademy.barcelonactiva.DiazDiaz.Dani.s04.t02.n01.model.domain;


import jakarta.persistence.*;


@Entity
@Table(name = "Fruita")
public class Fruita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String name;

    @Column(name = "quantitat_kg")
    private int quantityKg;

    public Fruita(){

    }
    public Fruita(String name, int quantityKg) {
        this.quantityKg = quantityKg;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }
}
