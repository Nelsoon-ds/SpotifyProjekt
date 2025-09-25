public class FreeUser extends User {

    public FreeUser(String userName, boolean isSubscribed) {
        super(userName, isSubscribed);
    }

    @Override
    public String toString() {

        return "Free User: " + userName + " " + isSubscribed;
    }

    public boolean canAddSongs() {
        System.out.println("This is a free user so you cant add songs.");
        return false; // kan ikke tilføje sange
    }

    public boolean hasAds() {
        return true;
    }





}
