CREATE TABLE IF NOT EXISTS `Reddit`.`Comments` (`ID` INT NOT NULL,`parentID` VARCHAR(45) NULL,`body` VARCHAR(1024) NULL,`ups` INT NULL,`downs` INT NULL,`created` DATETIME NULL,`conttiversiality` INT NULL,`Archived` TINYINT NULL,`USER` VARCHAR(128) NULL,`SUBREDDIT` VARCHAR(128) NULL,PRIMARY KEY (`ID`));
CREATE TABLE IF NOT EXISTS `Reddit`.`Subreddits` (`Name` VARCHAR(48) NOT NULL,PRIMARY KEY (`Name`));
CREATE TABLE IF NOT EXISTS `Reddit`.`User` (`ID` INT NOT NULL,`Name` VARCHAR(45) NOT NULL,PRIMARY KEY (`Name`),UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);