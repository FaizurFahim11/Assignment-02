package model;

import java.io.File;

public class User {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String phone;
    private String email;
    private String continent;
    private String hobbies;
    private File photo; // optional, can be null

    // === Constructor ===
    public User(String firstName, String lastName, String gender, int age,
                String phone, String email, String continent, String hobbies, File photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.continent = continent;
        this.hobbies = hobbies;
        this.photo = photo;
    }

    // === Getters & Setters ===
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getHobbies() { return hobbies; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }

    public File getPhoto() { return photo; }
    public void setPhoto(File photo) { this.photo = photo; }

    // === toString (excludes photo) ===
    @Override
    public String toString() {
        return String.format(
            "User Profile:\nName: %s %s\nGender: %s\nAge: %d\nPhone: %s\nEmail: %s\nContinent: %s\nHobbies: %s",
            firstName, lastName, gender, age, phone, email, continent, hobbies
        );
    }
}
