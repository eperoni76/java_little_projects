package guru.spring.model;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Byte[] image;

    @OneToOne
    private Notes notes;

    //todo Add
    //private Difficulty difficulty;
}
