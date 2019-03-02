package pl.petapp.pet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import pl.petapp.common.enums.PetType;
import pl.petapp.keeper.Keeper;
import pl.petapp.owner.Owner;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PET")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Pet {
    //public Pet(String name, Double wight, Integer age, PetType type, Owner owner) {
//        this.name = name;
//        this.wight = wight;
//        this.age = age;
//        this.type = type;
//        this.owner = owner;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "AGE")
    private Integer age;

    @NotNull
    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType type;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "KEEPER_ID")
    private Keeper keeper;

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

    public Double getWight() {
        return weight;
    }

    public void setWight(Double wight) {
        this.weight = wight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wight=" + weight +
                ", age=" + age +
                ", type=" + type +
                ", owner=" + owner +
                '}';
    }
}

