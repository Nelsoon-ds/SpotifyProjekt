/**
 * Superclass
 *
 */

public class User {
    // Vi vil gerne tillade inheritance
    // Men attributterne skal ikke kunne ændres fra andre end dens subclass
    protected String userName;
    protected boolean isSubscribed;

    // Vi vil gerne finde brugeren på et brugerId i fremtiden.
    // protected long userId;



    public User(String userName, boolean isSubscribed) {
        this.userName = userName;
        this.isSubscribed = isSubscribed;
    }


    public boolean getSubscription() {
       return this.isSubscribed;
    }

    public String toString() {
        return "Printing user: " + userName + isSubscribed;
    }
}
