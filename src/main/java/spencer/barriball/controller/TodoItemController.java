package spencer.barriball.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spencer.barriball.model.TodoData;
import spencer.barriball.model.TodoItem;
import spencer.barriball.service.TodoItemServiceImpl;
import spencer.barriball.util.AttributeNames;
import spencer.barriball.util.Mappings;
import spencer.barriball.util.ViewNames;

import java.time.LocalDate;

@Slf4j
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("deleteItem() called on id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
