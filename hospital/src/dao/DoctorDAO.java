package dao;

import model.Doctor;
import java.sql.*;
import java.util.*;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (name, specialization, phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialization());
            stmt.setString(3, doctor.getPhone());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Doctor d = new Doctor(rs.getInt("id"), rs.getString("name"),
                                      rs.getString("specialization"), rs.getString("phone"));
                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public boolean deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
