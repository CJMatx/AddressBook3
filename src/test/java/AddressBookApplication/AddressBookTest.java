package AddressBookApplication;

import static org.junit.Assert.*;

/**
 * Created by connormatthews on 1/12/2017.
 */
public class AddressBookTest {
    private AddressBook book;
    private BuddyInfo buddy1;
    private BuddyInfo buddy2;

    @org.junit.Before
    public void setUp() throws Exception {
        book = new AddressBook();
        buddy1 = new BuddyInfo("Connor", "111-111-1111", "123 road");
        buddy2 = new BuddyInfo("Charles", "222-222-2222", "abc street");
    }

    @org.junit.Test
    public void add() throws Exception {
        book.add(buddy1);
        assertTrue(book.contains(buddy1));
    }

    @org.junit.Test
    public void contains() throws Exception {
        book.add(buddy2);
        assertTrue(book.contains(buddy2));
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertTrue(book.getName().equals("AddressBook"));
    }

    @org.junit.Test
    public void setName() throws Exception {
        book.setName("Book1");
        assertTrue(book.getName().equals("Book1"));
    }
}