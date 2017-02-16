package AddressBookApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by connormatthews on 2/2/2017.
 */

@RestController
public class AddressBookRestController {

    @Autowired
    private AddressBookRepository repo;

    @GetMapping("/getBook")
    public AddressBook getBook(@RequestParam(value = "id") Long id) {
        return repo.findOne(id);
    }

    @GetMapping("/books")
    public Iterable<AddressBook> getBooks() {
        return repo.findAll();
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
                                @RequestParam(value = "address") String address,
                                @RequestParam(value = "bookId") Long bookId) {
        BuddyInfo buddy = new BuddyInfo(name, phone, address);
        AddressBook book = this.getBook(bookId);
        book.add(buddy);
        repo.save(book);
        return this.getBook(bookId);
    }

    @PostMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam(value = "bookId") Long bookId,
                                   @RequestParam(value = "buddyId") Long buddyId) {

        AddressBook book = repo.findOne(bookId);
        book.remove(buddyId);
        repo.save(book);
        return this.getBook(bookId);
    }
}