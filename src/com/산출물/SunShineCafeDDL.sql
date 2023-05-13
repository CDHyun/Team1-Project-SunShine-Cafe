-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sunshine
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sunshine
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sunshine` DEFAULT CHARACTER SET utf8mb3 ;
USE `sunshine` ;

-- -----------------------------------------------------
-- Table `sunshine`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`notice` (
  `noticeNo` INT NOT NULL AUTO_INCREMENT,
  `noticeImageName` VARCHAR(45) NULL DEFAULT NULL,
  `noticeImage` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`noticeNo`),
  UNIQUE INDEX `noticeNo_UNIQUE` (`noticeNo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`staff` (
  `staffNo` INT NOT NULL AUTO_INCREMENT,
  `staffPassword` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`staffNo`),
  UNIQUE INDEX `staffNo_UNIQUE` (`staffNo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`announce`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`announce` (
  `noticeNo` INT NOT NULL,
  `staffNo` INT NOT NULL,
  `announceInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noticeNo`, `staffNo`),
  INDEX `fk_notice_has_staff_staff1_idx` (`staffNo` ASC) VISIBLE,
  INDEX `fk_notice_has_staff_notice1_idx` (`noticeNo` ASC) VISIBLE,
  CONSTRAINT `fk_notice_has_staff_notice1`
    FOREIGN KEY (`noticeNo`)
    REFERENCES `sunshine`.`notice` (`noticeNo`),
  CONSTRAINT `fk_notice_has_staff_staff1`
    FOREIGN KEY (`staffNo`)
    REFERENCES `sunshine`.`staff` (`staffNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`category` (
  `categoryNo` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`categoryNo`),
  UNIQUE INDEX `categoryNo_UNIQUE` (`categoryNo` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`dessert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`dessert` (
  `dessertNo` INT NOT NULL AUTO_INCREMENT,
  `categoryNo` INT NOT NULL,
  `dessertName` VARCHAR(45) NULL DEFAULT NULL,
  `dessertStock` INT NULL DEFAULT NULL,
  `dessertPrice` INT NULL DEFAULT NULL,
  `dessertInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `dessertImageName` VARCHAR(45) NULL DEFAULT NULL,
  `dessertImage` LONGBLOB NULL DEFAULT NULL,
  `dessertStatus` TINYINT NULL DEFAULT '1',
  `dessertContent` VARCHAR(90) NULL DEFAULT NULL,
  PRIMARY KEY (`dessertNo`, `categoryNo`),
  UNIQUE INDEX `dessertNo_UNIQUE` (`dessertNo` ASC) VISIBLE,
  INDEX `fk_dessert_category_idx` (`categoryNo` ASC) VISIBLE,
  CONSTRAINT `fk_dessert_category`
    FOREIGN KEY (`categoryNo`)
    REFERENCES `sunshine`.`category` (`categoryNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`drink`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`drink` (
  `drinkNo` INT NOT NULL AUTO_INCREMENT,
  `categoryNo` INT NOT NULL,
  `drinkName` VARCHAR(45) NULL DEFAULT NULL,
  `drinkPrice` INT NULL DEFAULT NULL,
  `drinkInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `drinkImageName` VARCHAR(45) NULL DEFAULT NULL,
  `drinkImage` LONGBLOB NULL DEFAULT NULL,
  `drinkStatus` TINYINT NULL DEFAULT '1',
  `drinkContent` VARCHAR(90) NULL DEFAULT NULL,
  PRIMARY KEY (`drinkNo`, `categoryNo`),
  INDEX `fk_drink_category1_idx` (`categoryNo` ASC) VISIBLE,
  CONSTRAINT `fk_drink_category1`
    FOREIGN KEY (`categoryNo`)
    REFERENCES `sunshine`.`category` (`categoryNo`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`user` (
  `userid` VARCHAR(20) NOT NULL,
  `userPassword` VARCHAR(20) NULL DEFAULT NULL,
  `userPhone` VARCHAR(11) NULL DEFAULT NULL,
  `userInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `userCancellationDate` DATETIME NULL DEFAULT NULL,
  `userSecessionStatus` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`userid`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`cart` (
  `cartNo` INT NOT NULL AUTO_INCREMENT,
  `dessertNo` INT NULL DEFAULT NULL,
  `drinkNo` INT NULL DEFAULT NULL,
  `userid` VARCHAR(20) NOT NULL,
  `cartQty` INT NULL DEFAULT '1',
  PRIMARY KEY (`cartNo`),
  UNIQUE INDEX `cartNo_UNIQUE` (`cartNo` ASC) VISIBLE,
  INDEX `fk_cart_dessert1_idx` (`dessertNo` ASC) VISIBLE,
  INDEX `fk_cart_drink1_idx` (`drinkNo` ASC) VISIBLE,
  INDEX `fk_cart_user1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_cart_dessert1`
    FOREIGN KEY (`dessertNo`)
    REFERENCES `sunshine`.`dessert` (`dessertNo`),
  CONSTRAINT `fk_cart_drink1`
    FOREIGN KEY (`drinkNo`)
    REFERENCES `sunshine`.`drink` (`drinkNo`),
  CONSTRAINT `fk_cart_user1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`purchase` (
  `purchaseNo` INT NOT NULL AUTO_INCREMENT,
  `drinkNo` INT NULL,
  `dessertNo` INT NULL,
  `userid` VARCHAR(20) NOT NULL,
  `salesNo` INT NULL DEFAULT NULL,
  `purchaseQty` INT NULL DEFAULT NULL,
  `purchaseInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `purchaseDiningOption` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`purchaseNo`, `userid`),
  UNIQUE INDEX `purchaseNo_UNIQUE` (`purchaseNo` ASC) VISIBLE,
  INDEX `fk_purchase_drink1_idx` (`drinkNo` ASC) VISIBLE,
  INDEX `fk_purchase_dessert1_idx` (`dessertNo` ASC) VISIBLE,
  INDEX `fk_purchase_customer1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_customer1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`),
  CONSTRAINT `fk_purchase_dessert1`
    FOREIGN KEY (`dessertNo`)
    REFERENCES `sunshine`.`dessert` (`dessertNo`),
  CONSTRAINT `fk_purchase_drink1`
    FOREIGN KEY (`drinkNo`)
    REFERENCES `sunshine`.`drink` (`drinkNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`studyroom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`studyroom` (
  `tableNo` INT NOT NULL,
  `tableStatus` TINYINT NULL DEFAULT '1',
  `itemName` VARCHAR(45) NULL DEFAULT NULL,
  `itemPrice` INT NULL DEFAULT NULL,
  `itemImage` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`tableNo`),
  UNIQUE INDEX `tableNo_UNIQUE` (`tableNo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`rent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`rent` (
  `rentNo` INT NOT NULL AUTO_INCREMENT,
  `tableNo` INT NOT NULL,
  `userid` VARCHAR(20) NOT NULL,
  `rentStartTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rentNo`, `tableNo`, `userid`),
  UNIQUE INDEX `rentNo_UNIQUE` (`rentNo` ASC) VISIBLE,
  INDEX `fk_rent_studyroom1_idx` (`tableNo` ASC) VISIBLE,
  INDEX `fk_rent_customer1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_rent_customer1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`),
  CONSTRAINT `fk_rent_studyroom1`
    FOREIGN KEY (`tableNo`)
    REFERENCES `sunshine`.`studyroom` (`tableNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
