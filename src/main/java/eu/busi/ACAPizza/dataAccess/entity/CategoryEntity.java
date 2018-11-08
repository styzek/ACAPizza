package eu.busi.ACAPizza.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
public class CategoryEntity {



    @Id
    @Column(name="name")
    private String name;


    @ManyToMany(mappedBy = "categories")
    private Collection<PizzaEntity> pizzas;

    public CategoryEntity() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<PizzaEntity> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Collection<PizzaEntity> pizzas) {
        this.pizzas = pizzas;
    }
}
