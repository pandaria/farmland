CREATE TABLE IF NOT EXISTS `sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` int(11) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '1'

) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='序列表，命名s_[table_name]';

INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES  ('activity', 1000000, 1);
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES  ('customer', 2000000, 1);
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES  ('order', 3000000, 1);
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES  ('task', 4000000, 1);
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES  ('user', 5000000, 1);

DROP FUNCTION IF EXISTS `currval`;

DELIMITER //

CREATE  FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    READS SQL DATA
    DETERMINISTIC
BEGIN

DECLARE VALUE INTEGER;

SET VALUE = 0;

SELECT current_value INTO VALUE FROM sequence WHERE NAME = seq_name;

RETURN VALUE;

END//

DELIMITER ;

DROP FUNCTION IF EXISTS `nextval`;

DELIMITER //

CREATE  FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)

    DETERMINISTIC

BEGIN

UPDATE sequence SET current_value = current_value + increment WHERE NAME = seq_name;

RETURN currval(seq_name);

END//

DELIMITER ;