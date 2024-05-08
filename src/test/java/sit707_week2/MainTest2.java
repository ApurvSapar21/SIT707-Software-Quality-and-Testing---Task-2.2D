package sit707_week2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest2 {

    @Test
    public void testEmptyUsernameAndPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login(null, "wrong_password");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "correct_password");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("wrong_username", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("wrong_username", "wrong_password");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("wrong_username", "correct_password");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("correct_username", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login("correct_username", "wrong_password");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
    @Test
    public void testCorrectUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan@xyz.com", "Ahsan_pass1");
        Assert.assertTrue(status.isLoginSuccess());
        //Assert.assertTrue(status.getErrorMsg() == null || status.getErrorMsg().isEmpty());


        // Additional validation code tests (for successful login scenario)
        Assert.assertFalse(LoginForm.validateCode(null)); // Empty code
        Assert.assertFalse(LoginForm.validateCode("wrong_code")); // Wrong code
        Assert.assertTrue(LoginForm.validateCode("123456")); // Correct code
    }
}
