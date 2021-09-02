CREATE TABLE IF NOT EXISTS `drink_ingredients` (
  `drink_id` int NOT NULL,
  `ingredients_id` int NOT NULL,
  PRIMARY KEY (`drink_id`,`ingredients_id`),
  KEY `fk_ingredients_drink_idx` (`ingredients_id`) ,
  KEY `fk_drink_ingredients_idx` (`drink_id`) ,
  CONSTRAINT `fk_drink_ingredients` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`id`),
  CONSTRAINT `fk_ingredients_drink` FOREIGN KEY (`ingredients_id`) REFERENCES `ingredients` (`id`)
)