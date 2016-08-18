use accident_tracker;
SET FOREIGN_KEY_CHECKS = 0;
truncate table vehicles;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Toyota', '4Runner', '2000');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Toyota', 'Corolla', '1988');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Ford', 'Mustang', '2005');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`) VALUES ('Subaru', 'WRX');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Toyota', '4Runner', '2002');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Toyota', 'Corolla', '1993');
INSERT INTO `accident_tracker`.`vehicles` (`make`, `model`, `year`) VALUES ('Ford', 'Mustang', '2025');


