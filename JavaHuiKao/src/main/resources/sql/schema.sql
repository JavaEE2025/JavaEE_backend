CREATE TABLE `users` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL COMMENT '加密加盐',
  `type` ENUM ('teacher', 'student') NOT NULL,
  `student_class_id` integer COMMENT '所在班级，仅学生类型有'
);

CREATE TABLE `classes` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `teacher_id` integer
);

CREATE TABLE `exams` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `class_id` integer,
  `start_time` datetime NOT NULL,
  `duration` time NOT NULL,
  `marked` boolean DEFAULT false COMMENT '是否批改'
);

CREATE TABLE `exam_question` (
  `exam_id` integer,
  `question_id` integer,
  `number` integer NOT NULL COMMENT '试题在试卷里的题号',
  `score` decimal(4,1) COMMENT '可设置分数',
  PRIMARY KEY (`exam_id`, `question_id`)
);

CREATE TABLE `questions` (
  `id` integer PRIMARY KEY,
  `topic` text COMMENT '题面，html格式',
  `score` decimal(4,1) COMMENT '分数',
  `type` ENUM ('single', 'multiple', 'fill', 'answer'),
  `difficulty` varchar(255) COMMENT '难度',
  `parse` text COMMENT '解析，html格式【注意考试时不能返回防止抓包】',
  `correct_answer` text COMMENT '正确答案，html格式【注意考试时不能返回防止抓包】',
  `method` varchar(1023) COMMENT '解题方法',
  `source` varchar(1023) COMMENT '试题来源'
);

CREATE TABLE `options` (
  `option` text,
  `is_correct` boolean NOT NULL,
  `question_id` integer
);

CREATE TABLE `kps` (
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `section` varchar(255)
);

CREATE TABLE `question_kp` (
  `question_id` integer,
  `kp_id` integer,
  PRIMARY KEY (`question_id`, `kp_id`)
);

CREATE TABLE `answers` (
  `student_id` integer,
  `exam_id` integer,
  `question_id` integer,
  `answer` text,
  `score` decimal(4,1) COMMENT '实际得分',
  PRIMARY KEY (`student_id`, `exam_id`, `question_id`)
);

ALTER TABLE `options` COMMENT = '存客观选择题的选项';

ALTER TABLE `users` ADD FOREIGN KEY (`student_class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `classes` ADD FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`);

ALTER TABLE `exams` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `exam_question` ADD FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`);

ALTER TABLE `exam_question` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`);

ALTER TABLE `options` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`);

ALTER TABLE `question_kp` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`);

ALTER TABLE `question_kp` ADD FOREIGN KEY (`kp_id`) REFERENCES `kps` (`id`);

ALTER TABLE `answers` ADD FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

ALTER TABLE `answers` ADD FOREIGN KEY (`exam_id`) REFERENCES `exams` (`id`);

ALTER TABLE `answers` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`);
