package service;

import model.User;
import util.StringUtil;

public class UserCreator {
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_USERNAME = "testdata.user.username";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_USERNAME));
    }

    public static User withRandom() {
        return new User(StringUtil.randomEmail(),
                StringUtil.randomString(10),
                StringUtil.randomName(10));
    }
}
