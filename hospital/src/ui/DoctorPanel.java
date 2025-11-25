package ui;

import dao.DoctorDAO;
import model.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DoctorPanel extends JPanel {
    private JTextField nameField, specializationField, phoneField;
    private JTextArea doctorListArea;

    public DoctorPanel() {
        setLayout(new BorderLayout());

        // Input form
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Doctor"));

        nameField = new JTextField();
        specializationField = new JTextField();
        phoneField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Specialization:"));
        formPanel.add(specializationField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        JButton addButton = new JButton("Add Doctor");
        addButton.addActionListener(e -> addDoctor());
        formPanel.add(new JLabel());
        formPanel.add(addButton);

        // Doctor list
        doctorListArea = new JTextArea(10, 50);
        doctorListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(doctorListArea);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        refreshDoctorList();
    }

    private void addDoctor() {
        Doctor doctor = new Doctor(0, nameField.getText(), specializationField.getText(), phoneField.getText());
        boolean success = new DoctorDAO().addDoctor(doctor);
        if (success) {
            JOptionPane.showMessageDialog(this, "Doctor added successfully!");
            refreshDoctorList();
        } else {
            JOptionPane.showMessageDialog(this, "Error adding doctor.");
        }
    }

    private void refreshDoctorList() {
        List<Doctor> doctors = new DoctorDAO().getAllDoctors();
        doctorListArea.setText("");
        for (Doctor d : doctors) {
            doctorListArea.append("ID: " + d.getId() + " | Name: " + d.getName() + " | Specialization: " + d.getSpecialization() + " | Phone: " + d.getPhone() + "\n");
        }
    }
}
