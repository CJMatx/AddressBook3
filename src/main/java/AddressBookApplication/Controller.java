package AddressBookApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by connormatthews on 2/2/2017.
 */

@RestController
public class Controller {

    @Autowired
    private AddressBookRepository repo;

    @RequestMapping("/getBook")
    public AddressBook getBook(@RequestParam(value = "id") Long id) {
        return repo.findOne(id);
    }

    @PostMapping("/createBook")
    public AddressBook createBook(@RequestParam(value="name") String name) {
        AddressBook book = new AddressBook(name);
        repo.save(book);
        return this.getBook(book.getId());
    }

    @PostMapping("/addBuddy")
    public AddressBook addBuddy(@RequestParam(value = "name") String name,
                                @RequestParam(value = "phone") String phone,
                                @RequestParam(value = "bookId") Long bookId) {
        BuddyInfo buddy = new BuddyInfo(name, phone);
        AddressBook book = this.getBook(bookId);
        book.add(buddy);
        repo.save(book);
        return getBook(bookId);
    }

    @PostMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam(value = "bookId") Long bookId,
                                   @RequestParam(value = "buddyId") Long buddyId) {

        AddressBook book = repo.findOne(bookId);
        book.remove(buddyId);
        repo.save(book);
        return repo.findOne(bookId);
    }
}