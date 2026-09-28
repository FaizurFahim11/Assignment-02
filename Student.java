/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author otibhoedeoghon
 */
class Student {

    private String name;
    private int age;
    private String gender;
    private String phone;
    private String continent;
    private String experience;
    private String photoPath;

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    void setContinent(String continent) {
        this.continent = continent;
    }

    void setExperience(String experience) {
        this.experience = experience;
    }

    void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    String getName() { return name; }
    int getAge() { return age; }
    String getGender() { return gender; }
    String getPhone() { return phone; }
    String getContinent() { return continent; }
    String getExperience() { return experience; }
    String getPhotoPath() { return photoPath; }

    @Override
    public String toString() {
        return "Name: " + name
            + "\nAge: " + age
            + "\nGender: " + (gender == null ? "Not selected" : gender)
            + "\nPhone: " + phone
            + "\nContinent: " + (continent == null ? "Not selected" : continent)
            + "\nExperience: " + (experience == null || experience.trim().isEmpty() ? "None" : experience)
            + "\nPhoto Path: " + (photoPath == null || photoPath.trim().isEmpty() ? "Not uploaded" : photoPath);
    }
}