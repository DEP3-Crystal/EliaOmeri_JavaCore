import com.crystal.atm.controller.AtmMenu;
import com.crystal.atm.dao.DataAccess;
import com.crystal.atm.dao.DataAccessFromMemory;
import com.crystal.atm.service.AccountService;

import java.io.IOException;

public class ATM_App {
    public static void main(String[] args) throws IOException {
        DataAccess dataAccess= new DataAccessFromMemory();
        dataAccess.getUsers();
        AtmMenu atmMenu=new AtmMenu(dataAccess,new AccountService(dataAccess));
        dataAccess.getUsers();

    }
}
