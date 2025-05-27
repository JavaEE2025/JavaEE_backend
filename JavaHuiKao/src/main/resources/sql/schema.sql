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
                         `start_time` datetime NOT NULL,
                         `duration` time NOT NULL,
                         `marked` boolean DEFAULT false COMMENT '是否批改'
);

CREATE TABLE `exam_class` (
                              `exam_id` integer,
                              `class_id` integer,
                              PRIMARY KEY (`exam_id`, `class_id`)
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
                           `id` integer PRIMARY KEY,
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

CREATE TABLE `student_answers_content` (
                                           `student_answers_id` integer,
                                           `question_id` integer,
                                           `text_answer` text COMMENT '文字回答',
                                           `img_answer` mediumblob COMMENT '图片回答（最大16MB）',
                                           `option_answer` text COMMENT '选择的选项ID',
                                           `score` decimal(4,1) COMMENT '实际得分',
                                           PRIMARY KEY (`student_answers_id`, `question_id`)
);

CREATE TABLE `student_answers` (
                                   `id` integer PRIMARY KEY,
                                   `student_id` integer NOT NULL,
                                   `exam_id` integer NOT NULL,
                                   `is_final` boolean DEFAULT false COMMENT '是否最终答案',
                                   `progress` decimal(5,2) COMMENT '答题进度，单位%',
                                   `sum_score` decimal(4,1) COMMENT '实际总得分'
);

CREATE INDEX `exam_class_index_0` ON `exam_class` (`class_id`);

CREATE INDEX `exam_class_index_1` ON `exam_class` (`exam_id`);

CREATE UNIQUE INDEX `student_ans` ON `student_answers` (`student_id`, `exam_id`);

ALTER TABLE `options` COMMENT = '存客观选择题的选项';

ALTER TABLE `student_answers_content` COMMENT = '针对一道题，学生的回答内容';

ALTER TABLE `student_answers` COMMENT = '针对一场考试，学生的回答';
