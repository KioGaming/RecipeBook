package login;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;

public class LoginTest {

    @Test
    public void signUp() {
        DatabaseHandler db = Mockito.mock(DatabaseHandler.class);
        Mockito.doReturn(true).when(db).verifyMailDB(any());
        Mockito.doReturn(true).when(db).verifyUsernameDB(any());
        Mockito.doNothing().when(db).signUpUser(any(), any(), any(), any());
        Assert.assertNotNull(Login.signUp("sdagfsf","fdsfds@gmail.com","frtryhj","uk", db));
    }

    @Test
    public void signIn() {
        DatabaseHandler db = Mockito.mock(DatabaseHandler.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        try {
            Mockito.doReturn(true).when(resultSet).next();
            Mockito.doReturn("vova").when(resultSet).getString("username");
            Mockito.doReturn("ru").when(resultSet).getString("location");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Mockito.doReturn(resultSet).when(db).signInUser(Mockito.same("vova@gmail.com"), Mockito.same("vovavova"));
        Assert.assertNotNull(Login.signIn("vova@gmail.com","vovavova", db));
    }
}