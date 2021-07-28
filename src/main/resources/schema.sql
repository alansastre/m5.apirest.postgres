-- springmysql.car definition
DROP TABLE IF EXIST car;
CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cc` double DEFAULT NULL,
  `doors` int DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;