public class FreeUser extends User {
    public FreeUser(String userName, boolean isSubscribed) {
        super(userName, isSubscribed);
    }

    @Override
    public String toString() {
        return "Free User: " + userName + " " + isSubscribed;
    }
}
