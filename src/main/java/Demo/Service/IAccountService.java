package Demo.Service;

import Demo.Model.Account;

public interface IAccountService extends ICommonService <Account,Account>{
    public Account getSingleByUserName(String userName);
}
