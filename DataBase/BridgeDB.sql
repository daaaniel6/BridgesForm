-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BridgesForm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BridgesForm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BridgesForm` ;
USE `BridgesForm` ;

-- -----------------------------------------------------
-- Table `BridgesForm`.`DatosGenerales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`DatosGenerales` (
  `idDatosGenerales` INT NOT NULL AUTO_INCREMENT,
  `longitud` DOUBLE NULL,
  `numeroTramos` INT NULL,
  `anchoRodadura` DOUBLE NULL,
  `anchoAceraDer` DOUBLE NULL,
  `anchoAceraIzq` DOUBLE NULL,
  `tipologiaPuente` VARCHAR(450) NULL,
  `alturaLibreSuperior` DOUBLE NULL,
  `alturaLibreSobreRio` DOUBLE NULL,
  `puenteSobre` VARCHAR(450) NULL,
  `numeroVias` INT NULL,
  `materialSuperestructura` VARCHAR(450) NULL,
  `cargaDisenio` VARCHAR(450) NULL,
  `anioConstruccion` INT NULL,
  `materialSubestructura` VARCHAR(450) NULL,
  `trafico` DOUBLE NULL,
  `porcentajeCamionesBuses` DOUBLE NULL,
  `fechaUltimaEvaluacion` DATE NULL,
  PRIMARY KEY (`idDatosGenerales`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`IdentificacionPuente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`IdentificacionPuente` (
  `idIdentificacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(450) NULL,
  `codigo` VARCHAR(450) NULL,
  `ruta` VARCHAR(450) NULL,
  `kilometraje` VARCHAR(450) NULL,
  `departamento` VARCHAR(450) NULL,
  `municipio` VARCHAR(450) NULL,
  `rutaPavimentada` VARCHAR(450) NULL,
  `alineamientoHorizontal` VARCHAR(450) NULL,
  `esviaje` VARCHAR(450) NULL,
  `coordenadasUtmN` VARCHAR(450) NULL,
  `coordenadasUtmE` VARCHAR(450) NULL,
  `poblacionAntes` VARCHAR(450) NULL,
  `poblacionDespues` VARCHAR(450) NULL,
  `DatosGenerales_idDatosGenerales` INT NULL,
  PRIMARY KEY (`idIdentificacion`),
  INDEX `fk_Identificacion_DatosGenerales_idx` (`DatosGenerales_idDatosGenerales` ASC) VISIBLE,
  CONSTRAINT `fk_Identificacion_DatosGenerales`
    FOREIGN KEY (`DatosGenerales_idDatosGenerales`)
    REFERENCES `BridgesForm`.`DatosGenerales` (`idDatosGenerales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Tramo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Tramo` (
  `idTramo` INT NOT NULL AUTO_INCREMENT,
  `longitud` INT NULL,
  `tipoSeccion` VARCHAR(45) NULL,
  `puente` INT NULL,
  PRIMARY KEY (`idTramo`),
  INDEX `fk_Tramo_IdentificacionPuente1_idx` (`puente` ASC) VISIBLE,
  CONSTRAINT `fk_Tramo_IdentificacionPuente1`
    FOREIGN KEY (`puente`)
    REFERENCES `BridgesForm`.`IdentificacionPuente` (`idIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Tabla` (
  `idTabla` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(450) NULL,
  `comentario` VARCHAR(450) NULL,
  `puente` INT NULL,
  PRIMARY KEY (`idTabla`),
  INDEX `fk_Tabla_IdentificacionPuente1_idx` (`puente` ASC) VISIBLE,
  CONSTRAINT `fk_Tabla_IdentificacionPuente1`
    FOREIGN KEY (`puente`)
    REFERENCES `BridgesForm`.`IdentificacionPuente` (`idIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Fila`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Fila` (
  `idFila` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(450) NULL,
  `comentario` VARCHAR(45) NULL,
  `tabla` INT NULL,
  PRIMARY KEY (`idFila`),
  INDEX `fk_Fila_Tabla1_idx` (`tabla` ASC) VISIBLE,
  CONSTRAINT `fk_Fila_Tabla1`
    FOREIGN KEY (`tabla`)
    REFERENCES `BridgesForm`.`Tabla` (`idTabla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Columna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Columna` (
  `idColumna` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(450) NULL,
  `atributo` VARCHAR(450) NULL,
  `comentario` VARCHAR(450) NULL,
  `fila` INT NULL,
  PRIMARY KEY (`idColumna`),
  INDEX `fk_Columna_Fila1_idx` (`fila` ASC) VISIBLE,
  CONSTRAINT `fk_Columna_Fila1`
    FOREIGN KEY (`fila`)
    REFERENCES `BridgesForm`.`Fila` (`idFila`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Inspector` (
  `idInspector` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(450) NULL,
  `telefono` VARCHAR(450) NULL,
  `correo` VARCHAR(450) NULL,
  `fechaInspeccion` DATE NULL,
  `puente` INT NULL,
  PRIMARY KEY (`idInspector`),
  INDEX `fk_Inspector_IdentificacionPuente1_idx` (`puente` ASC) VISIBLE,
  CONSTRAINT `fk_Inspector_IdentificacionPuente1`
    FOREIGN KEY (`puente`)
    REFERENCES `BridgesForm`.`IdentificacionPuente` (`idIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BridgesForm`.`Imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BridgesForm`.`Imagen` (
  `idImagen` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(45) NULL,
  `puente` INT NULL,
  `imagen` LONGBLOB NULL,
  PRIMARY KEY (`idImagen`),
  INDEX `fk_Imagen_IdentificacionPuente1_idx` (`puente` ASC) VISIBLE,
  CONSTRAINT `fk_Imagen_IdentificacionPuente1`
    FOREIGN KEY (`puente`)
    REFERENCES `BridgesForm`.`IdentificacionPuente` (`idIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
