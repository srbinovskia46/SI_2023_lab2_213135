import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    //  new User(null, "pass", "email@test.com")
    //  new ArrayList<User>())
    @Test
    void everyBranchTest() {
        //1
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Andrej", null, "email@test.com"), new ArrayList<User>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //2
        assertFalse(SILab2.function(new User(null, "pass", "email@test.com"), new ArrayList<User>(List.of(
                new User("username1", "passwordNekoj", "valid@finki.com"),
                new User("username", "password46!", "email@test.com")))));

        //3
        assertFalse(SILab2.function(new User("user", "password46#", "email"),
                new ArrayList<User>(List.of(new User("username1", "passwordNekoj", "valid@finki.com"),
                        new User("username", "password46!", "email@test.com")))));

        //4
        assertFalse(SILab2.function(new User("user", "password 46", "email@test.com"),
                new ArrayList<User>(List.of(new User("username1", "passwordNekoj", "valid@finki.com"),
                        new User("user", "password46!", "email@test.com")))));

        //5
        assertFalse(SILab2.function(new User("user", "password46", "email@test.com"),
                new ArrayList<User>(List.of(new User("username1", "passwordNekoj", "valid@finki.com"),
                        new User("username3", "passwordNekojTret", "valid@finki.ukim.mk"),
                        new User("username80", "password46!80", "email@test.com.mk")))));
    }

    @Test
    void multipleConditionTest(){
        //if (user==null || user.getPassword()==null || user.getEmail()==null)
        //T||X||X
        //F||T||X
        //F||F||T
        //F||F||F

        //T||X||X
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<User>(List.of(new User("username", "password11!", "email@test.mk")))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F||T||X
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "email@test.com"), new ArrayList<User>(List.of(new User("username", "password11!", "email@test.mk")))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F||F||T
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "password11!", null), new ArrayList<User>(List.of(new User("username", "password11!", "email@test.mk")))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F||F||F
        assertTrue(() -> SILab2.function(new User("username46", "password46!", "email@test.com"), new ArrayList<User>(List.of(new User("username", "password11!", "email@test.mk")))));

    }
}