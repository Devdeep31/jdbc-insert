/* id, name,
roll_no, subject, marks[0-100]*/





USE School;
ALTER TABLE students 
    ADD CONSTRAINT chk_value_range CHECK (marks >= 0 AND marks <= 100);
    
use School;   
    DELIMITER //

CREATE TRIGGER trig_check_value_range
BEFORE INSERT ON Students
FOR EACH ROW
BEGIN
    IF NEW.marks < 0 OR NEW.marks > 100 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Value must be between 0 and 100';
    END IF;
END//

DELIMITER ;

