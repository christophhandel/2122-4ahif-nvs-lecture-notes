package at.htl.carrental.entity.kfz;

import javax.persistence.*;

@Entity
@Table(name = "KFZ_KFZ")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Kfz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "K_ID")
    private Long id;
    @Column(name = "K_BRAND")
    private String brand;
    @Column(name = "K_MODEL")
    private String model;

    //region constructors
    public Kfz() {
    }

    public Kfz(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    //endregion

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%s %s", brand, model);
    }
}
