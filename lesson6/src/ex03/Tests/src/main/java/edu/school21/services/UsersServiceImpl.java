package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.exceptions.AlwaysAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean authenticate(String login, String password) {
        User user = usersRepository.findByLogin(login);
        if(user.getAuthenticationSuccessStatus()) {
            throw new AlreadyAuthenticatedException("User is already exists");
        }
        if(!password.equals(user.getPassword())) {
            return  false;
        }
        user.setAuthenticationSuccessStatus(true);
        usersRepository.update(user);
        return true;
    }
}
