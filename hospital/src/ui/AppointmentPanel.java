package ui;

import dao.AppointmentDAO;
import model.Appointment;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppointmentPanel extends JPanel {
    private JTextField patientIdField, doctorIdField, dateField, notesField;
    private JTextArea appointmentListArea;

    public AppointmentPanel() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Schedule Appointment"));

        patientIdField = new JTextField();
        doctorIdField = new JTextField();
        dateField = new JTextField("yyyy-mm-dd");
        notesField = new JTextField();

        formPanel.add(new JLabel("Patient ID:"));
        formPanel.add(patientIdField);
        formPanel.add(new JLabel("Doctor ID:"));
        formPanel.add(doctorIdField);
        formPanel.add(new JLabel("Date:"));
        formPanel.add(dateField);
        formPanel.add(new JLabel("Notes:"));
        formPanel.add(notesField);

        JButton addButton = new JButton("Schedule");
        addButton.addActionListener(e -> addAppointment());
        formPanel.add(new JLabel());
        formPanel.add(addButton);

        appointmentListArea = new JTextArea(10, 50);
        appointmentListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(appointmentListArea);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        refreshAppointmentList();
    }

    private void addAppointment() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateField.getText());

            Appointment appointment = new Appointment(
                    0,
                    Integer.parseInt(patientIdField.getText()),
                    Integer.parseInt(doctorIdField.getText()),
                    date,
                    notesField.getText()
            );
            boolean success = new AppointmentDAO().addAppointment(appointment);
            if (success) {
                JOptionPane.showMessageDialog(this, "Appointment scheduled!");
                refreshAppointmentList();
            } else {
                JOptionPane.showMessageDialog(this, "Error scheduling appointment.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage());
        }
    }

    private void refreshAppointmentList() {
        List<Appointment> list = new AppointmentDAO().getAllAppointments();
        appointmentListArea.setText("");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Appointment a : list) {
            String dateStr = a.getAppointmentDate() != null ? sdf.format(a.getAppointmentDate()) : "";
            appointmentListArea.append("ID: " + a.getId() + " | Patient ID: " + a.getPatientId() + " | Doctor ID: " + a.getDoctorId() + " | Date: " + dateStr + " | Notes: " + a.getNotes() + "\n");
        }
    }
}
