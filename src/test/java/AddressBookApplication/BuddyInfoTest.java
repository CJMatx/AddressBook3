package AddressBookApplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by connormatthews on 1/12/2017.
 */
public class BuddyInfoTest {
    private BuddyInfo buddy1;
    private BuddyInfo buddy2;

    @Before
    public void setUp() throws Exception {
        buddy1 = new BuddyInfo("Connor", "111-111-1111", "123 road");
        buddy2 = new BuddyInfo("Connor", "111-111-1111", "123 road");
    }

    @Test
    public void getName() throws Exception {
        assertTrue(buddy1.getName().equals("Connor"));
    }

    @Test
    public void setName() throws Exception {
        buddy1.setName("Charles");
        assertTrue(buddy1.getName().equals("Charles"));
    }

    @Test
    public void getPhone() throws Exception {
        assertTrue(buddy1.getPhone().equals("111-111-1111"));
    }

    @Test
    public void setPhone() throws Exception {
        buddy1.setPhone("222-222-2222");
        assertTrue(buddy1.getPhone().equals("222-222-2222"));
    }

    @Test
    public void getAddress() throws Exception {
        assertTrue(buddy1.getAddress().equals("123 road"));
    }

    @Test
    public void setAddress() throws Exception {
        buddy1.setAddress("abc road");
        assertTrue(buddy1.getAddress().equals("abc road"));
    }

    @Test
    public void equals() throws Exception {
        assertTrue(buddy1.equals(buddy2));
    }

}