package AddressBookApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by connormatthews on 1/12/2017.
 */

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String phone;

    private String address;

    public BuddyInfo() {
        this.name = "default name";
        this.phone = "XXX-XXX-XXXX";
        this.address = "default address";
    }

    public BuddyInfo(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BuddyInfo)) {
            return false;
        }

        BuddyInfo buddy = (BuddyInfo) obj;

        if(this.id == buddy.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.phone + ", " + this.address;
    }
}
