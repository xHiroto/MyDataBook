package sg.edu.rp.c346.id19045784.mydatabook;

public class Data {

    private String bio;
    private String vaccination;
    private String anniversary;

    public Data(String bio, String vaccination, String anniversary) {
        this.bio = bio;
        this.vaccination = vaccination;
        this.anniversary = anniversary;
    }

    public Data(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }
}
