package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Doctors", new DoctorPanel());
        tabbedPane.addTab("Patients", new PatientPanel());
        tabbedPane.addTab("Appointments", new AppointmentPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }
}
