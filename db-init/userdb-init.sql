-- Initialize database for user service
CREATE DATABASE IF NOT EXISTS `userdb`;
GRANT ALL ON `userdb`.* TO 'user'@'%';