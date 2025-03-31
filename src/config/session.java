package config;

public class session {

    private static session instance;
    private static String u_id;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String contact;
    private static String username;
    private static String acc_type;
    private static String acc_status;
    private static String acc_pfp;
    private static String secQ;
    private static String secQanswer;

    private session() {

    }

    public static synchronized session getInstance() {
        if (instance == null) {
            instance = new session();
        }
        return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public static String getU_id() {
        return u_id;
    }

    public static void setU_id(String u_id) {
        session.u_id = u_id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        session.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        session.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        session.email = email;
    }

    public static String getContact() {
        return contact;
    }

    public static void setContact(String contact) {
        session.contact = contact;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        session.username = username;
    }

    public static String getAcc_type() {
        return acc_type;
    }

    public static void setAcc_type(String acc_type) {
        session.acc_type = acc_type;
    }

    public static String getAcc_status() {
        return acc_status;
    }

    public static void setAcc_status(String acc_status) {
        session.acc_status = acc_status;
    }

    public static String getAcc_pfp() {
        return acc_pfp;
    }

    public static void setAcc_pfp(String acc_pfp) {
        session.acc_pfp = acc_pfp;
    }
    
    public static String getSecQ() {
        return secQ;
    }

    public static void setSecQ(String secQ) {
        session.secQ = secQ;
    }

    public static String getSecQanswer() {
        return secQanswer;
    }

    public static void setSecQanswer(String secQanswer) {
        session.secQanswer = secQanswer;
    }

}
