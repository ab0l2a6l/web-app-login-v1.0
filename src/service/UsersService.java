package service;

import domain.Users;
import repository.UsersDB;

public class UsersService {
    private UsersService(){}
    private static final UsersService service = new UsersService();

    public static UsersService getInstance() {
        return service;
    }

    public Users login(String username , String password)throws Exception{
        return new UsersDB().selectOneUserByUsernameOrPassword(username,password);
    }

}
