package Demo.Service;

import Demo.DataAccess.SqlDataAccess;

import java.util.ArrayList;
import java.util.List;

public class BaseService {
    protected SqlDataAccess db;
    protected String query;
    protected List<String> paramters;

    public BaseService(){
        db = new SqlDataAccess();
        paramters = new ArrayList<>();
    }
}
