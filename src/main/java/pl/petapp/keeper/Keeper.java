package pl.petapp.keeper;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import pl.petapp.owner.Owner;
import pl.petapp.pet.Pet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "KEEPER")
public class Keeper {
//    public Keeper(String name) {
//        this.name = name;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false, updatable = false, unique = true)
    private String name;

   // @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

   // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
    private Set<Pet> pets;

    //Getters and setters

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", pets=" + pets +
                '}';
    }
}
