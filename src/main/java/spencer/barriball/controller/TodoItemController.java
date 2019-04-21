package spencer.barriball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import spencer.barriball.model.TodoData;
import spencer.barriball.util.Mappings;
import spencer.barriball.util.ViewNames;

@Controller
public class TodoItemController {

    // == model attribute ==
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == handler methods ==
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
