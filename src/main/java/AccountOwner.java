/**
 * Created by HP on 2017-09-11.
 */
public class AccountOwner {

    private String name;
    private String lastname;
    private String PIN;

    public AccountOwner(String name, String lastname, String PIN) {
        this.name = name;
        this.lastname = lastname;
        this.PIN = PIN;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPIN() {
        return PIN;
    }

    @Override
    public String toString() {
        return "AccountOwner{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", PIN='" + "****" + '\'' +
                '}';
    }
}
