package pl.petapp.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import pl.petapp.keeper.Keeper;
import pl.petapp.pet.Pet;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "OWNER")
public class Owner {
//    public Owner(String nickname, String password, String email, String name, String surname, Set<Pet> pets) {
//        this.nickname = nickname;
//        this.password = password;
//        this.email = email;
//        this.name = name;
//        this.surname = surname;
//        this.pets = pets;
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NICKNAME", nullable = false, unique = true, updatable = false)
    private String nickname;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastname;


   // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Keeper> keepers;

   // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;

    //Getters and setters

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String surname) {
        this.lastname = surname;
    }

    public Set<Keeper> getKeepers() {
        return keepers;
    }

    public void setKeepers(Set<Keeper> keepers) {
        this.keepers = keepers;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + firstname + '\'' +
                ", surname='" + lastname + '\'' +
                ", pets=" + pets +
                ", keepers=" + keepers +
                '}';
    }
}
