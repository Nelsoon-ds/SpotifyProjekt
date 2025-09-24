public class PremiumUser extends User {
    public PremiumUser(String userName, boolean isSubscribed) {
        super(userName, isSubscribed);
    }

    @Override
    public String toString() {
        return "Premium User: " + userName + " " + isSubscribed;
    }
}
