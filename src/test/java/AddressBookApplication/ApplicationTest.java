package AddressBookApplication;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by connormatthews on 2/9/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBookTest() throws Exception {
        this.mockMvc.perform(post("/createBook?name=Book1"));
        this.mockMvc.perform(get("/getBook?id=2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Book1\"")));
    }

    @Test
    public void addBuddyTest() throws Exception {
        this.mockMvc.perform(post("/createBook?name=Book2"));
        this.mockMvc.perform(post("/addBuddy?name=Connor&phone=111-111-1111&address=123 road&bookId=1"));
        this.mockMvc.perform(get("/getBook?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Book2\"")))
                .andExpect(content().string(containsString("\"name\":\"Connor\"")))
                .andExpect(content().string(containsString("\"phone\":\"111-111-1111\"")))
                .andExpect(content().string(containsString("\"address\":\"123 road\"")));
    }
}
