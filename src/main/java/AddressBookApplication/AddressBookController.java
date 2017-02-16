package AddressBookApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by connormatthews on 2/16/2017.
 */

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository repo;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("books", repo.findAll());
        return "index";
    }

    @GetMapping("/newBook")
    public String newBookPage(Model model) {
        model.addAttribute("book", new AddressBook());
        return "createBook";
    }

    @PostMapping("/newBook")
    public String createBook (Model model, @ModelAttribute AddressBook book) {
        repo.save(book);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/viewBook")
    public String viewBook (Model model, @RequestParam(value="bookId") Long bookId) {
        model.addAttribute("book", repo.findOne(bookId));
        return "book";
    }

    @GetMapping("/newBuddy")
    public String newBuddyPage (Model model, @RequestParam(value="bookId") Long bookId) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("buddy", new BuddyInfo());
        return "buddy";
    }

    @PostMapping("/newBuddy")
    public String addBuddy (Model model, @RequestParam(value="bookId") Long bookId, @ModelAttribute BuddyInfo buddy) {
        AddressBook book = repo.findOne(bookId);
        book.add(buddy);
        repo.save(book);
        model.addAttribute("book", book);
        return "book";
    }
}
