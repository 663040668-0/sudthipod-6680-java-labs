package wanaprom.sudthipod.lab11;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Player:
 * This class implements the serializable interface and
 * integrate with PlayerFormV14 to read and write .obj files
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 26/02/2024
 */

public class Player implements Serializable {
    private String name, nationality, birthDate, gender, playerType;
    private ArrayList<String> hobbies, sports;
    private int expYear;

    // No constructor since we will be using setters and getters    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public ArrayList<String> getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<String> getSports() {
        return this.sports;
    }

    public void setSports(ArrayList<String> sports) {
        this.sports = sports;
    }

    public int getExpYear() {
        return this.expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }
}
