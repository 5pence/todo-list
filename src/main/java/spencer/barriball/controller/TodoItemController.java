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

    // == fields ==
    private final TodoItemServiceImpl todoItemService;

    // == constructor ==
    @Autowired
    public TodoItemController(TodoItemServiceImpl todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attribute ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
