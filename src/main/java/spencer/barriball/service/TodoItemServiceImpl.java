package spencer.barriball.service;

import org.springframework.stereotype.Service;
import spencer.barriball.model.TodoData;
import spencer.barriball.model.TodoItem;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    private final TodoData data = new TodoData();

    // == public methods ==
    @Override
    public void addItem(TodoItem item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
       return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}
