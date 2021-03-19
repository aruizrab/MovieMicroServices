-- Initialize database for movie service
CREATE DATABASE IF NOT EXISTS `moviedb`;
GRANT ALL ON `moviedb`.* TO 'user'@'%';