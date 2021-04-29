package dk.kea.carstorejpa.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noter;

    @OneToOne
    private Mod mod;

    public Note() {
    }

    public Note(String noter, Mod mod) {
        this.noter = noter;
        this.mod = mod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoter() {
        return noter;
    }

    public void setNoter(String noter) {
        this.noter = noter;
    }

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }
}
