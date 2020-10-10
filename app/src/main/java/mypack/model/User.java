package mypack.model;

/**
 * Created by Peter MOUEZA on 05/10/20 03:58
 *  
 */
public class User {
    private String mFirstName;

    @Override
    public String toString() {
        return "User{" +
                "mFirstName='" + mFirstName + '\'' +
                '}';
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
}
