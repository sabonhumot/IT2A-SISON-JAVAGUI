-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2025 at 03:21 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `careq`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `appointment_id` int(11) NOT NULL,
  `doctor` text NOT NULL,
  `date` date NOT NULL,
  `time` varchar(10) NOT NULL,
  `notes` text NOT NULL,
  `patient_id` int(11) NOT NULL,
  `appointment_status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`appointment_id`, `doctor`, `date`, `time`, `notes`, `patient_id`, `appointment_status`) VALUES
(1, 'Dr. Trixie Mae', '2025-05-05', '12:00', 'gihilantan ko', 14, 'Pending'),
(4, 'Dr. Trixie Mae', '2025-05-05', '10:00', 'gimingaw nimo', 19, 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `action` varchar(255) NOT NULL,
  `action_date` text NOT NULL DEFAULT current_timestamp(),
  `action_time` text NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `action`, `action_date`, `action_time`) VALUES
(1, 1, 'Deleted an account', '2025-05-02', '20:59:15.232'),
(2, 1, 'Activated an account', '2025-05-02', '21:08'),
(3, 1, 'Deleted an account', '2025-05-02', '21:08'),
(4, 1, 'Deleted an account', '2025-05-02', '21:08'),
(5, 1, 'Updated profile photo', '2025-05-02', '21:08');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(255) NOT NULL,
  `u_lname` varchar(255) NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_pnum` varchar(255) NOT NULL,
  `u_user` varchar(255) NOT NULL,
  `u_pass` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `u_pfp` varchar(255) DEFAULT NULL,
  `sq` varchar(255) DEFAULT NULL,
  `sq_answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_pnum`, `u_user`, `u_pass`, `type`, `status`, `u_pfp`, `sq`, `sq_answer`) VALUES
(1, 'joshua', 'gwapo', 'gwapoolok321@gmail.com', '09090909090', 'admin', 'JAvlGPq9JyTdtvBO6x2llnRI1+gxwIyPqCKAn3THIKk=', 'administrator', 'active', 'src/user_img/2e83c67ca33455cfacf66717c923eefc.jpg', '', ''),
(14, 'pacure', 'bota', 'pacurebota1@gmail.com', '12345678941', 'pacurebota123', 'bItZVbKg+/xCEuTTrgHxsHkZXfb2acWj7NdFn26kNgY=', 'Patient', 'Active', 'src/user_img/borjak.jpg', '', ''),
(17, 'Bombardino', 'Crocodilo', 'bombardo_c@gmail.com', '09325648245', 'bombardino', 'S/oy7zM+IizvxEWqQoikMDo53s47de3rVdBbFWJE4ew=', 'Patient', 'Active', 'src/user_img/Bombardiro_crocodilo_cover.jpg', 'What is the first name of your dog?', 'nori'),
(18, 'Trixie', 'Mae', 'trixiemae@gmail.com', '09875757654', 'trixielovenorrie', 'trixie123', 'Doctor', 'Active', NULL, NULL, NULL),
(19, 'Joshua', 'Gwapo', 'joshuagwapo@gmail.com', '09090945124', 'joshuagwaps', 'goAXAbp531py6wn5mqsFydzuNz5sqLzXnnTJfz0uGQM=', 'Patient', 'Active', NULL, 'What is the first name of your dog?', 'norrie'),
(20, 'Norrie', 'Ugly', 'norrie@gmail.com', '09451265845', 'norrie', 'KecLiTYwylt2E2ESWrV7Ysd7Vgae2DiT36m58r3Sl7w=', 'Patient', 'Active', NULL, 'What is the first name of your dog?', 'trixie');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`appointment_id`),
  ADD KEY `doctor_id` (`doctor`(768)),
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `appointment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `user` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
