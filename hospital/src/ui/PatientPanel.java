package ui;

import dao.PatientDAO;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PatientPanel extends JPanel {
    private JTextField nameField, ageField, genderField, addressField, doctorIdField;
    private JTextArea patientListArea;

    public PatientPanel() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Patient"));

        nameField = new JTextField();
        ageField = new JTextField();
        genderField = new JTextField();
        addressField = new JTextField();
        doctorIdField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(new JLabel("Gender:"));
        formPanel.add(genderField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Doctor ID:"));
        formPanel.add(doctorIdField);

        JButton addButton = new JButton("Add Patient");
        addButton.addActionListener(e -> addPatient());
        formPanel.add(new JLabel());
        formPanel.add(addButton);

        patientListArea = new JTextArea(10, 50);
        patientListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(patientListArea);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        refreshPatientList();
    }

    private void addPatient() {
        Patient patient = new Patient(
                0,
                nameField.getText(),
                Integer.parseInt(ageField.getText()),
                genderField.getText(),
                addressField.getText(),
                Integer.parseInt(doctorIdField.getText())
        );
        boolean success = new PatientDAO().addPatient(patient);
        if (success) {
            JOptionPane.showMessageDialog(this, "Patient added successfully!");
            refreshPatientList();
        } else {
            JOptionPane.showMessageDialog(this, "Error adding patient.");
        }
    }

    private void refreshPatientList() {
        List<Patient> patients = new PatientDAO().getAllPatients();
        patientListArea.setText("");
        for (Patient p : patients) {
            patientListArea.append("ID: " + p.getId() + " | Name: " + p.getName() + " | Age: " + p.getAge() + " | Gender: " + p.getGender() + " | Doctor ID: " + p.getDoctorId() + "\n");
        }
    }
}
