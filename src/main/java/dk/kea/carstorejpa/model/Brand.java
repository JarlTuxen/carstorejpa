package dk.kea.carstorejpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Mod> mod;

    public Brand() {
    }

    //ingen id i constructor - JPA laver id
    public Brand(String name, Set<Mod> mod) {
        this.name = name;
        this.mod = mod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Mod> getModel() {
        return mod;
    }

    public void setModel(Set<Mod> mod) {
        this.mod = mod;
    }
}
