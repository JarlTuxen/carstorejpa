package dk.kea.carstorejpa.model;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String note;

    @OneToOne
    private Mod model;

    public Note() {
    }

    public Note(String note, Mod model) {
        this.note = note;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Mod getModel() {
        return model;
    }

    public void setModel(Mod model) {
        this.model = model;
    }
}
