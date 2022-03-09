CREATE TABLE IF NOT EXISTS `alumno` (
`idalumno` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`apellidos` varchar(100) NOT NULL,
`dni` varchar(14) NOT NULL,
PRIMARY KEY (`idalumno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE categories(
    categoryId INT AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(100) NOT NULL
) ENGINE=INNODB;

CREATE TABLE products(
    productId INT AUTO_INCREMENT PRIMARY KEY,
    productName varchar(100) not null,
    categoryId INT,
    CONSTRAINT fk_category
    FOREIGN KEY (categoryId) 
        REFERENCES categories(categoryId)
) ENGINE=INNODB;