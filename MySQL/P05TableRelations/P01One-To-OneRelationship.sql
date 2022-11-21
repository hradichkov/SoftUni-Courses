CREATE TABLE `passports` (
   `passport_id` INT PRIMARY KEY AUTO_INCREMENT,
   `passport_number` VARCHAR(50) UNIQUE);
  
INSERT INTO `passports` (`passport_id`, `passport_number`) 
VALUES 
    (101, 'N34FG21B'), 
    (102, 'K65LO4R7'), 
    (103, 'ZE657QP2');