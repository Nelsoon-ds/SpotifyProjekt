public class PremiumUser extends User {
    public PremiumUser(String userName, boolean isSubscribed) {
        super(userName, isSubscribed);
    }

    @Override
    public String toString() {

        return "Premium User: " + userName + " " + isSubscribed;
    }

    public boolean canAddSongs() {
        System.out.println("User can add new songs");
        return true; // kan ikke tilføje sange
    }

    public boolean hasAds() {
        return false;
    }
}
