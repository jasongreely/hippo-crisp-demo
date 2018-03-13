package hippo.crisp.demo.beans;

/**
 * Created by jgreely on 3/13/18.
 */
public class Animal {

    String name;
    String description;
    String color;
    Integer weight;
    Integer heightFeet;
    Integer heightInch;

    public Animal(){}

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(Integer heightFeet) {
        this.heightFeet = heightFeet;
    }

    public Integer getHeightInch() {
        return heightInch;
    }

    public void setHeightInch(Integer heightInch) {
        this.heightInch = heightInch;
    }
}
