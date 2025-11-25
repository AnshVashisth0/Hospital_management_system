USE hospital_db;

-- Insert 10 doctors
INSERT INTO doctors (name, specialization, phone) VALUES
('Dr. Alice Smith', 'Cardiology', '123-456-7890'),
('Dr. Bob Jones', 'Neurology', '234-567-8901'),
('Dr. Carol White', 'Pediatrics', '345-678-9012'),
('Dr. David Brown', 'Orthopedics', '456-789-0123'),
('Dr. Eva Green', 'Dermatology', '567-890-1234'),
('Dr. Frank Black', 'Oncology', '678-901-2345'),
('Dr. Grace Lee', 'Gynecology', '789-012-3456'),
('Dr. Henry King', 'Psychiatry', '890-123-4567'),
('Dr. Irene Scott', 'Ophthalmology', '901-234-5678'),
('Dr. Jack Turner', 'ENT', '012-345-6789');

-- Insert 10 patients
INSERT INTO patients (name, age, gender, address, doctor_id) VALUES
('John Doe', 30, 'Male', '123 Main St', 1),
('Jane Roe', 25, 'Female', '456 Oak Ave', 2),
('Mike Miller', 40, 'Male', '789 Pine Rd', 3),
('Sara Smith', 35, 'Female', '321 Maple St', 4),
('Tom Clark', 50, 'Male', '654 Cedar Ave', 5),
('Lisa Adams', 28, 'Female', '987 Spruce Dr', 6),
('Paul Young', 45, 'Male', '159 Elm St', 7),
('Nina Brown', 32, 'Female', '753 Birch Rd', 8),
('Chris Evans', 38, 'Male', '852 Willow Ln', 9),
('Emma Wilson', 27, 'Female', '951 Aspen Ct', 10);

-- Insert 10 appointments
INSERT INTO appointments (patient_id, doctor_id, appointment_date, notes) VALUES
(1, 1, '2025-05-25', 'Routine checkup'),
(2, 2, '2025-05-26', 'Consultation'),
(3, 3, '2025-05-27', 'Follow-up'),
(4, 4, '2025-05-28', 'X-ray review'),
(5, 5, '2025-05-29', 'Skin rash'),
(6, 6, '2025-05-30', 'Cancer screening'),
(7, 7, '2025-05-31', 'Annual exam'),
(8, 8, '2025-06-01', 'Therapy session'),
(9, 9, '2025-06-02', 'Eye test'),
(10, 10, '2025-06-03', 'ENT checkup');
