package Bai5;

import java.util.List;

public class PatientService {
    private PatientDAO dao = new PatientDAO();

    public void showAllPatients() {
        List<Patient> list = dao.getAllPatients();
        for (Patient p : list) {
            System.out.println("ID: " + p.getPatientId()
                    + " | Tên: " + p.getFullName()
                    + " | Tuổi: " + p.getAge()
                    + " | Khoa: " + p.getDepartment()
                    + " | Bệnh án: " + p.getMedicalRecord());
        }
    }

    public void addPatient(String name, int age, String dept) {
        dao.addPatient(name, age, dept);
        System.out.println("Tiếp nhận bệnh nhân mới thành công!");
    }

    public void updateRecord(int id, String record) {
        dao.updateRecord(id, record);
        System.out.println("Cập nhật bệnh án thành công!");
    }

    public void discharge(int id) {
        double fee = dao.discharge(id);
        System.out.println("Bệnh nhân ID " + id + " xuất viện. Tổng viện phí: " + fee);
    }
}
