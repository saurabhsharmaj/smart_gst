
Create Table DEPT(
 `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`)
);

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`),
   CONSTRAINT `dept_fk` FOREIGN KEY (`dept_id`) REFERENCES `DEPT` (`dept_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);
 
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
);
 
CREATE TABLE `emp_roles` (
  `emp_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `emp_fk_idx` (`emp_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
);

