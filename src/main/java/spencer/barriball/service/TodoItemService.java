package spencer.barriball.service;

import spencer.barriball.model.TodoData;
import spencer.barriball.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem item);
    TodoData getData();
}
