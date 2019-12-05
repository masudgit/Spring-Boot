create sequence student_sequence start with 1 increment by 1;
create sequence exam_sequence start with 1 increment by 1;


insert into `students` (`id`, `fullname`) values (1, 'John Doe');

insert into `exams` (`id`, `name`, `mark`, `student_id`) values (1, 'Software Engineering', 27, 1);

insert into `exams` (`id`, `name`, `mark`, `student_id`) values (2, 'Java Principles', 30, 1);