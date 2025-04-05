package RE08_Group3_A2;

public class Card {

    private String number;

    private String name;

    private String account;

    public Card(){

    }

    public Card(String name, String number, String account) {
        this.number = number;
        this.name = name;
        this.account = account;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
