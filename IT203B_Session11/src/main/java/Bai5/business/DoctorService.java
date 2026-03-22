package Bai5.business;

import Bai5.dao.DoctorDAO;
import Bai5.model.Doctor;
import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showAllDoctors() {
        List<Doctor> list = dao.getAllDoctors();
        for (Doctor d : list) {
            System.out.println("Mã: " + d.getId() + " | Tên: " + d.getName() + " | Chuyên khoa: " + d.getSpecialty());
        }
    }

    public void addDoctor(String id, String name, String specialty) {
        dao.addDoctor(new Doctor(id, name, specialty));
    }

    public void statistic() {
        dao.statisticBySpecialty();
    }
}
