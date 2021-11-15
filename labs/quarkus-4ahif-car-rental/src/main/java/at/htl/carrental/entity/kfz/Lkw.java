package at.htl.carrental.entity.kfz;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Lkw extends Kfz implements Serializable {


    private int maxLoad;

    public Lkw() {
    }

    public Lkw(String brand, String model, int maxLoad) {
        super(brand, model);
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}
