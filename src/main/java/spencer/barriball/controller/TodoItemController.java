package spencer.barriball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import spencer.barriball.model.TodoData;
import spencer.barriball.service.TodoItemServiceImpl;
import spencer.barriball.util.Mappings;
import spencer.barriball.util.ViewNames;

@Controller
public class TodoItemController {

    // == constructor ==
    @Autowired
    public TodoItemController() {
    }

    // == model attribute ==
    @ModelAttribute
    public TodoData todoData() {
        TodoItemServiceImpl todoItemService = new TodoItemServiceImpl();
        return todoItemService.getData();
    }

    // == handler methods ==
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
