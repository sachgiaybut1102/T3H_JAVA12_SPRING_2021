package Demo.Service;

import java.util.List;

public interface IPaginationService<T> {
    public List<T> getByPage(int pageNumber, int pageSize, String keyword);

    public int getCountPage(int pageSize, String keyword);
}
