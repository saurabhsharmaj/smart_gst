
Create Table DEPT(
 `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`)
);

INSERT INTO `smartgst`.`dept` (`dept_id`, `name`) VALUES ('1', 'HR');
INSERT INTO `smartgst`.`dept` (`dept_id`, `name`) VALUES ('2', 'IT');


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
 

INSERT INTO `smartgst`.`employee` (`emp_id`, `email`, `full_name`,`username`, `password`, `enabled`, `dept_id`) VALUES ('1', 'admin@gmail.com', 'admin','admin', '$2a$04$k94yJSKW05UdRSSU9WzXdeFwRX9cEvg9gHwxzB5OCLZiI0S2xMP5u', '1', '1');
INSERT INTO `smartgst`.`employee` (`emp_id`, `email`, `full_name`,`username`, `password`, `enabled`, `dept_id`) VALUES ('2', 'user@gmail.com', 'user','user', '$2a$04$7kus2ju.e/lkFOd4o4UUaudzypL3CkmhJEsXwapQDzJ7mguUbQg6C', '1', '2');


CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
);

INSERT INTO `smartgst`.`roles` (`role_id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `smartgst`.`roles` (`role_id`, `name`) VALUES ('2', 'USER');


CREATE TABLE `emp_roles` (
  `emp_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `emp_fk_idx` (`emp_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
);

INSERT INTO `smartgst`.`emp_roles` (`emp_id`,`role_id`) VALUES ('1', '1');
INSERT INTO `smartgst`.`emp_roles` (`emp_id`,`role_id`) VALUES ('2', '2');

