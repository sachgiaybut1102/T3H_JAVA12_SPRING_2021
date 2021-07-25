package Demo.Service;

import java.util.List;

public interface ICommonService<T> {
    public List<T> getAll();

    public T getByID(String id);

    public List<T> getByKeyword(String keyword);

    public boolean add(T info);

    public boolean update(T info);

    public boolean delete(T info);
}
