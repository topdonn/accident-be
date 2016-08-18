use accident_tracker;
SET FOREIGN_KEY_CHECKS = 0;
truncate table person;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `accident_tracker`.`person` (`name`, `age`, `gender`, `monthly`) VALUES ('mr. man', '21', 'M', '150');
INSERT INTO `accident_tracker`.`person` (`name`, `age`, `gender`, `monthly`) VALUES ('sally sue', '32', 'F', '75');
INSERT INTO `accident_tracker`.`person` (`name`, `age`, `gender`, `monthly`) VALUES ('slither IO', '150', 'M', '300');
INSERT INTO `accident_tracker`.`person` (`name`, `age`, `gender`, `monthly`) VALUES ('old guy', '70', 'M', '200');
INSERT INTO `accident_tracker`.`person` (`name`, `age`, `gender`, `monthly`) VALUES ('safe girl', '16', 'F', '500');