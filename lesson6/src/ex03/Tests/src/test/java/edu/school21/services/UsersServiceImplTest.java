package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.exceptions.AlwaysAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;
import edu.school21.repositories.UsersRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
    private UsersService usersService;
    private UsersRepository usersRepositoryMock;

    private final User ABOBA_USER = new User(
            100L,
            "ABOBA",
            "PAROL"
    );
    private final static User AUTHENTICATED_ABOBA_USER = new User(
            100L,
            "ABOBA_AUTHENTICATED",
            "PAROL",
            true
    );

    @BeforeEach
    void setUp() {
        usersRepositoryMock = Mockito.mock(UsersRepository.class);
        usersService = new UsersServiceImpl(usersRepositoryMock);
        Mockito.when(usersRepositoryMock.findByLogin("ABOBA")).thenReturn(ABOBA_USER);
        Mockito.when(usersRepositoryMock.findByLogin("ABOBA_AUTHENTICATED")).thenReturn(AUTHENTICATED_ABOBA_USER);
    }

    @Test
    public void authenticateSuccessTest(){
        assertTrue(usersService.authenticate("ABOBA", "PAROL"));
    }
    @Test
    public void authenticateWrongPasswordTest(){
        assertFalse(usersService.authenticate("ABOBA", "WRONGPAROL"));
    }
    @Test
    public void authenticateExceptionTest(){
        assertThrows(AlreadyAuthenticatedException.class, () -> usersService.authenticate("ABOBA_AUTHENTICATED", "PAROL"));
    }
}