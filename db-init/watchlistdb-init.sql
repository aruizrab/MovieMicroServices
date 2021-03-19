-- Initialize database for watchlist service
CREATE DATABASE IF NOT EXISTS `watchlistdb`;
GRANT ALL ON `watchlistdb`.* TO 'user'@'%';