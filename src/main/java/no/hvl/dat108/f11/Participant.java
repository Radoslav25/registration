package no.hvl.dat108.f11;

public class Participant {
	private String firstName;
    private String lastName;
    private String gender;
    private String mobile;

    public Participant(String firstName, String lastName, String gender, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }
}
