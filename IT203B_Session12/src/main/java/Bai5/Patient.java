package Bai5;

public class Patient {
    private int patientId;
    private String fullName;
    private int age;
    private String department;
    private String medicalRecord;

    public Patient(int patientId, String fullName, int age, String department, String medicalRecord) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.medicalRecord = medicalRecord;
    }


    public int getPatientId() {
        return patientId;
    }
    public String getFullName() {
        return fullName;
    }
    public int getAge() {
        return age;
    }
    public String getDepartment() {
        return department;
    }
    public String getMedicalRecord() {
        return medicalRecord;
    }
}