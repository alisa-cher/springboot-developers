package fr.formation.developers.domain.dtos;

import fr.formation.developers.validation.IsNotIdentical;

import javax.validation.constraints.*;
import java.time.LocalDate;

/*TODO - j'ai fait cette class hériter de la class ProjectUpdate
car sinon il y aurait ete deux champs (description, budget) pour lesquels
//le code se serait répété dans ProjectCreate et ProjectUpdate.
Vu que la classe ne peut hériter que d'une seule autre class,
//j'ai pas pu le faire pour la class ProjectClose, donc le champs
endDate existe dans les deux classes (ProjectCreate et ProjectClose).
La question est: quelle est la bonne pratique pour résoudre ce genre de problemes
pour que le code soit plus lisible/concis/plus facile a maintenir?*/


/*TODO - cette annotation rejete la création d’un projet si le nom et la description sont identiques.
Par conséquent, ca implique que si on fait le PATCH et change la description, on doit verifier
a ce stade aussi que le nom et la description ne sont identiques.

Je n'arrive pas a trouver la solution pour adresser ce problème, car ma methode PATCH n'a pas d'acces
a la classe ProjectCreate (on fait patch avec l'objet ProjectClose pour ne pas envoyer que les donnees qu'on a besoin).
Une de solutions possibles serait tojours envoyer dans le BODY de requête http le nom et la description du projet
(et optionnellement le budget).
Ainsi, on pourra mettre @IsNotIdentical au-dessus de la classe ProjectUpdate et ca va marcher dans tous les cas
(creation du projet, changement des informations concernant le project).*/

@IsNotIdentical
public class ProjectCreate extends ProjectUpdate {
    private static final int NAME_MAX_LENGTH = 255;

    @NotNull
    @NotBlank
    @Size(max = NAME_MAX_LENGTH)
    private String name;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

/*    TODO - si je comprends bien, selon la spec ce champs ne doit pas exister dans la classe qui crée le projet.
    je l'ai mis ici pour faire le PATCH (class ProjectController, la ligne 54)
    La question est: qu'est-ce que il faudra faire pour respecter les contraintes établis par la spec?*/
    @FutureOrPresent
    private LocalDate endDate;

    public ProjectCreate() {}

    public ProjectCreate(String name, String description, LocalDate startDate) {
        super(description);
        this.name = name;
        this.startDate = startDate;
    }

    public ProjectCreate(String name, String description, LocalDate startDate, Integer budget) {
        super(budget, description);
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ProjectCreate{" +
                "name='" + name + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budget=" + super.getBudget() +
                '}';
    }
}
