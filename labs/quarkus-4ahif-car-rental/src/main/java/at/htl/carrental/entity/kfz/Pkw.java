package at.htl.carrental.entity.kfz;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Pkw extends  Kfz implements Serializable {

    private boolean isCabrio;
    private int numSeats;

    public Pkw() {
    }

    public Pkw(String brand, String model, boolean isCabrio, int numSeats) {
        super(brand, model);
        this.isCabrio = isCabrio;
        this.numSeats = numSeats;
    }

    public boolean isCabrio() {
        return isCabrio;
    }

    public void setCabrio(boolean cabrio) {
        isCabrio = cabrio;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
}
