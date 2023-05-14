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
-- Table `sunshine`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`Item` (
  `itemNo` INT NOT NULL AUTO_INCREMENT,
  `categoryNo` INT NOT NULL,
  `itemName` VARCHAR(45) NULL DEFAULT NULL,
  `itemPrice` INT NULL DEFAULT NULL,
  `itemInsertDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `itemImageName` VARCHAR(45) NULL DEFAULT NULL,
  `itemImage` LONGBLOB NULL DEFAULT NULL,
  `itemStatus` TINYINT NULL DEFAULT '1',
  `itemContent` VARCHAR(90) NULL DEFAULT NULL,
  PRIMARY KEY (`itemNo`),
  INDEX `fk_Item_category1_idx` (`categoryNo` ASC) VISIBLE,
  CONSTRAINT `fk_Item_category1`
    FOREIGN KEY (`categoryNo`)
    REFERENCES `sunshine`.`category` (`categoryNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`cart` (
  `cartNo` INT NOT NULL AUTO_INCREMENT,
  `itemNo` INT NOT NULL,
  `userid` VARCHAR(20) NOT NULL,
  `cartQty` INT NULL DEFAULT '1',
  `cartOptionPrice` INT NULL,
  PRIMARY KEY (`cartNo`),
  UNIQUE INDEX `cartNo_UNIQUE` (`cartNo` ASC) VISIBLE,
  INDEX `fk_cart_user1_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_cart_Item1_idx` (`itemNo` ASC) VISIBLE,
  CONSTRAINT `fk_cart_user1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`),
  CONSTRAINT `fk_cart_Item1`
    FOREIGN KEY (`itemNo`)
    REFERENCES `sunshine`.`Item` (`itemNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sunshine`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sunshine`.`purchase` (
  `purchaseNo` INT NOT NULL AUTO_INCREMENT,
  `purchaseInsertDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `itemNo` INT NOT NULL,
  `userid` VARCHAR(20) NOT NULL,
  `salesNo` INT NULL DEFAULT NULL,
  `purchaseQty` INT NULL DEFAULT NULL,
  `purchaseDiningOption` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`purchaseNo`, `purchaseInsertDate`),
  UNIQUE INDEX `purchaseNo_UNIQUE` (`purchaseNo` ASC) VISIBLE,
  INDEX `fk_purchase_Item1_idx` (`itemNo` ASC) VISIBLE,
  INDEX `fk_purchase_user1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_Item1`
    FOREIGN KEY (`itemNo`)
    REFERENCES `sunshine`.`Item` (`itemNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_user1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `userid` VARCHAR(20) NOT NULL,
  `tableNo` INT NOT NULL,
  `rentStartTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rentNo`),
  UNIQUE INDEX `rentNo_UNIQUE` (`rentNo` ASC) VISIBLE,
  INDEX `fk_rent_user1_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_rent_studyroom1_idx` (`tableNo` ASC) VISIBLE,
  CONSTRAINT `fk_rent_user1`
    FOREIGN KEY (`userid`)
    REFERENCES `sunshine`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rent_studyroom1`
    FOREIGN KEY (`tableNo`)
    REFERENCES `sunshine`.`studyroom` (`tableNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
