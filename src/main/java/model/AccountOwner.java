package model;

public class AccountOwner {

    private String name;
    private String lastname;
    private String PIN;

    public AccountOwner(String name, String lastname, String PIN) {
        this.name = name;
        this.lastname = lastname;
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return "model.AccountOwner{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", PIN='" + "****" + '\'' +
                '}';
    }
}
