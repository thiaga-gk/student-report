DROP TABLE
studentreport.department,
studentreport.classes,
studentreport.student,
studentreport.staff,
studentreport.attendance,
studentreport.course,
studentreport.course_attendance,
studentreport.class_attendance;

---- department

CREATE TABLE studentreport.department (
	department_id integer PRIMARY KEY,
    short_name varchar(5) NOT NULL,
    long_name varchar(50) NOT NULL,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- classes

CREATE TABLE studentreport.classes (
	class_id integer PRIMARY KEY,
    class_name varchar(25) NOT NULL,
    class_year smallint NOT NULL,
    department_id integer REFERENCES studentreport.department(department_id) NOT NULL,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- student

CREATE TABLE studentreport.student (
	student_id integer PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    gender character(1) NOT NULL,
    email_address varchar(50) NOT NULL,
    phone_number bigint NOT NULL,
    address json NOT NULL,
    birth_date date NOT NULL,
    student_status character(1) NOT NULL,
    department_id integer REFERENCES studentreport.department(department_id) NOT NULL,
    class_id integer REFERENCES studentreport.classes(class_id) NOT NULL,
    joined_on date NOT NULL,
    completed_on date,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- staff

CREATE TABLE studentreport.staff (
	staff_id integer PRIMARY KEY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    gender character(1) NOT NULL,
    email_address varchar(50) NOT NULL,
    phone_number bigint NOT NULL,
    staff_status character(1) NOT NULL,
    department_id integer REFERENCES studentreport.department(department_id) NOT NULL,
    joined_on date NOT NULL,
    terminated_on date,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- attendance

CREATE TABLE studentreport.attendance (
    attendance_code character(1) PRIMARY KEY,
    attendance_desc varchar(50) NOT NULL,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- course

CREATE TABLE studentreport.course (
	course_id integer PRIMARY KEY,
    course_name varchar(25) NOT NULL,
    staff_id integer REFERENCES studentreport.staff(staff_id) NOT NULL,
    class_id integer REFERENCES studentreport.classes(class_id) NOT NULL,
    created_by varchar(10) NOT NULL,
    created_on timestamptz DEFAULT Now(),
    modified_by varchar(10) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);

---- course_attendance

CREATE TABLE studentreport.course_attendance (
	attendance_on date NOT NULL,
    student_id integer REFERENCES studentreport.student(student_id) NOT NULL,
    course_id integer REFERENCES studentreport.course(course_id) NOT NULL,
    attendance_status character(1) REFERENCES studentreport.attendance(attendance_code) NOT NULL,
    submitted_by varchar(10) NOT NULL,
    submitted_on timestamptz DEFAULT Now(),
    PRIMARY KEY (attendance_on,student_id,course_id)
);

---- class_attendance

CREATE TABLE studentreport.class_attendance (
	student_id integer NOT NULL,
    attendance_on date NOT NULL,
    attendance_status character(1) REFERENCES studentreport.attendance(attendance_code) NOT NULL,
    modified_on timestamptz DEFAULT Now()
);