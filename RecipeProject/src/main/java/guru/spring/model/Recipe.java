package guru.spring.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    @Lob
    private Byte[] image;

    /*
    aggiungiamo le relazioni tra tabelle. Ogni piatto avrà una relativa nota,
    e avrà anche più ingredienti. Cascade serve a dirgli cosa deve fare in caso cancellassi
    dalla tabella dei recipe il mio oggetto recipe, ALL significa che cancella tutti gli associati
    nelle relative tabelle
     */

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    private Difficulty difficulty;
}
