package AddressBookApplication;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by connormatthews on 1/12/2017.
 */

@Entity
@Component
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyList;

    public AddressBook() {
        this.buddyList = new ArrayList();
        this.name = "AddressBook";
    }

    public AddressBook(String name) {
        this.buddyList = new ArrayList();
        this.name = name;
    }

    public void add(BuddyInfo buddy) {
        buddyList.add(buddy);
    }

    public void remove(BuddyInfo buddy) {
        buddyList.remove(buddy);
    }

    public void remove(long id) {
        BuddyInfo buddy = this.getBuddy(id);
        buddyList.remove(buddy);
    }

    public boolean contains(BuddyInfo buddy) {
        return buddyList.contains(buddy);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public List<BuddyInfo> getBuddyList() {
        return this.buddyList;
    }

    public BuddyInfo getBuddy(long id) {
        for (BuddyInfo b : buddyList) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String out = name + ":";
        for (BuddyInfo b : buddyList) {
            out = out + "\n" + b;
        }
        return out;
    }

    public static void main(String [ ] args) {
        AddressBook book = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Connor", "111-111-1111", "123 road");
        BuddyInfo buddy2 = new BuddyInfo("Charles", "222-222-2222", "abc street");

        book.add(buddy1);
        book.add(buddy2);

        System.out.print(book.toString());
    }
}
