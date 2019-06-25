# Host: localhost  (Version: 5.5.53)
# Date: 2019-06-25 18:53:28
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "authority"
#

CREATE TABLE `authority` (
  `author_Id` int(11) NOT NULL AUTO_INCREMENT,
  `author_uuid` varchar(255) DEFAULT NULL,
  `author_role` varchar(255) DEFAULT NULL,
  `author_right` varchar(11) DEFAULT NULL,
  `author_active` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`author_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

#
# Data for table "authority"
#

INSERT INTO `authority` VALUES (13,'b9fa01ec326d48fba63af6be1874f1de','学生','1','0'),(14,'aa26a41dcf544c0da93f77c9a82b8275','teacher','2','0'),(16,'55dfea9743fe4ca091c55dae37d71a2d','student','1','1'),(19,'44fe05f860cf4f7a800e674f597fe7b5','教师','2','1'),(20,'1c73876785e1478d81466d686217bf82','教务员','3','0'),(21,'1427e016b91c45b696d4b7fc7af63450','dean','3','0'),(24,'d834a6383db1457dadebf1b825cb8c1d','user','1','0'),(25,'31b0c2a0f68742c5b912c6f2d0b3e109','用户','1','0'),(26,'a197f4e649dc45079a8ef58623f68ee0','teacher','2','0'),(27,NULL,'管理员','4',NULL),(28,'aaba06b30d374d40b3c6cc8ea98ddf11','管理员','4','1');

#
# Structure for table "class"
#

CREATE TABLE `class` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "class"
#


#
# Structure for table "course"
#

CREATE TABLE `course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES (1,'1','数学'),(2,'2','语文'),(3,'3','英语'),(4,'4','物理'),(5,'5','化学'),(6,'6','其它');

#
# Structure for table "dean"
#

CREATE TABLE `dean` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `dean_uuid` varchar(255) NOT NULL DEFAULT '',
  `dean_id` varchar(255) NOT NULL DEFAULT '',
  `dean_name` varchar(255) DEFAULT NULL,
  `dean_idcard` varchar(255) NOT NULL DEFAULT '',
  `dean_active` varchar(255) NOT NULL DEFAULT '0',
  `teacher_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "dean"
#

INSERT INTO `dean` VALUES (5,'12332','1000001','张三','440536012251254025','0',NULL),(6,'12350','1000023','李四','161241002356255535','0',NULL),(7,'12334','1000005','赵云','440523196254242351','0',NULL),(8,'12346','1000002','胡四','443516289503452685','0',NULL);

#
# Structure for table "newsinfoimage"
#

CREATE TABLE `newsinfoimage` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(1200) DEFAULT NULL,
  `imagepath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "newsinfoimage"
#

INSERT INTO `newsinfoimage` VALUES (3,'666','66666','//picture//656647d6-23c0-45a9-93a0-fcd8296b7f67_5.jpg'),(31,'中学教育','中学教育是小学教育的继续和进入高等院校或转入其它中等学校的预备阶段;是暂时不能升学的初、高中学生准备就业的学习阶段。中学教育的对象是年龄在11、12岁--17、18岁之间的青少年，他们正处在生理、心理迅速发展和突变的转折时期，正经历着急剧获取知识和增长才干，以及世界观、人生观、价值观初步形成的关键年段。中学教育包括初中阶段和高中阶段两个层次的教育，中学教育对社会主义现代化建设中的物质文明建设和精神文明建设都起着至关重要的作用。','//picture//d3b03d4f-a7b6-4a5e-9d0d-681b6dbccfed_zhao.jpg'),(32,'公告标题','自主研发优能UMS教学管理系统:业内唯一获得政府官方认可的中学生在线学习系统。 实现学习内容 实现学习内容和教学策略与学生实际需自主研发优能UMS教学管理系统:业内唯一获得政府官方认可的中学生在线学习系统。 实现学习内容 实现学习内容和教学策略与学生实际需','//picture//183618a2-410c-4b12-ac19-90b7c3ab6750_test01.jpg'),(33,'33','33','//picture//cd0a29c8-9c61-4816-9504-1c10bef41c96_test01.jpg'),(34,'33','33','//picture//51e5bded-c108-4b08-b406-b767ce1d15c2_test01.jpg'),(35,'培训计划','自主研发优能UMS教学管理系统:业内唯一获得政府官方认可的中学生在线学习系统。 实现学习内容 实现学习内容和教学策略与学生实际需求的阶段性匹配,及时检验并巩固学...','//picture//9f45c5b0-de34-48ff-b266-76d7e447477f_test01.jpg'),(36,'2019初中教育信息化工作计划','以科学发展观为指导，依托我县“三通过程”等优势，通过不断培训教育信息化的技能，提高全县教师教育信息化应用水平，促进教育教学方法的改进，提高课堂教学效率，推动全县教育信息化均衡发展。\r\n\r\n　　XXXX年我校将以县教体局教育信息化工作计划为依托，结合我校各校实际，规范管理、强化培训、突出应用为重点，整体推进全校教育信息化基础设施建设，充分发挥教育信息网的作用，切实保障教育网站与网络信息安全，促进各校教育均衡发展，使全校教育技术装备工作迈上一个新台阶。','//picture//25440e97-652a-4597-9fe7-904a0cb656af_flag.jpg');

#
# Structure for table "personcounts"
#

CREATE TABLE `personcounts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `student_counts` varchar(255) NOT NULL DEFAULT '',
  `teacher_counts` varchar(255) NOT NULL DEFAULT '',
  `dean_counts` varchar(255) NOT NULL DEFAULT '',
  `user_counts` varchar(255) NOT NULL DEFAULT '',
  `other_counts` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "personcounts"
#

INSERT INTO `personcounts` VALUES (4,'12','12','5','25','10');

#
# Structure for table "sadmin"
#

CREATE TABLE `sadmin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `sa_id` varchar(255) DEFAULT NULL,
  `sa_name` varchar(255) DEFAULT '',
  `sa_idcard` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "sadmin"
#

INSERT INTO `sadmin` VALUES (1,'sa_01','赵云','440823182002360415');

#
# Structure for table "score"
#

CREATE TABLE `score` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `score_uuid` varchar(255) DEFAULT NULL,
  `score_id` varchar(255) NOT NULL DEFAULT '',
  `user_id` varchar(255) NOT NULL DEFAULT '',
  `user_name` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) NOT NULL DEFAULT '',
  `score` varchar(255) DEFAULT '',
  `score_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `course_name` (`course_name`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "score"
#

INSERT INTO `score` VALUES (2,'17606c39fec74872890843a58359748e','2','12345633453','陈云龙','物理','99','有效'),(3,'5899f41d53e14f0a814f3aa4f705242b','2','12345322345','丽丽','物理','93','有效'),(5,'5958b7656e934675bbc0083bbe80a34d','16124123514','16124123514','陈雨力','物理','16','有效'),(6,NULL,'','',NULL,'','66',NULL),(7,NULL,'','',NULL,'','100',NULL),(8,NULL,'','',NULL,'','25',NULL),(9,NULL,'','',NULL,'','20',NULL),(10,NULL,'','',NULL,'','85',NULL),(11,'2c65069ad8ae4492854f37ae71e59b23','16124100234','16124100234','陈翦进','物理','87','有效'),(13,'a448996df58b461a9ef52ba8a99bdf2e','46124100238','46124100238','楚云娜','物理','40','有效'),(14,'495bb58e9dd04cd89772de6d493fca21','33','33','33','物理','84','有效'),(19,'a4522b8922374f7cb906bf2f9297e1a3','33','33','33','物理','32','有效'),(20,NULL,'','',NULL,'','49',NULL),(21,NULL,'','',NULL,'','35',NULL),(22,NULL,'','',NULL,'','72',NULL),(23,NULL,'','',NULL,'','12',NULL),(24,NULL,'','',NULL,'','54',NULL),(25,NULL,'','',NULL,'','58',NULL),(26,NULL,'','',NULL,'','66',NULL),(27,NULL,'','',NULL,'','66',NULL),(29,NULL,'','',NULL,'','78',NULL),(30,NULL,'','',NULL,'','88',NULL),(31,NULL,'','',NULL,'','82',NULL),(32,NULL,'','',NULL,'','81',NULL),(33,NULL,'','',NULL,'','89',NULL),(34,NULL,'','',NULL,'','88',NULL),(35,NULL,'','',NULL,'','89',NULL),(36,NULL,'','',NULL,'','83',NULL),(37,'5d49af770a29480fb882a106957768b4','12345678','12345678','朱玉环','物理','32','有效'),(38,'5b57be951417442b8fb94f2bcc093814','24','24','陈雨婷','物理','32','有效'),(39,'c9452dd0acef4f06ae28e9dd2586df19','16124100234','16124100234','赵宇雨','物理','24','有效'),(40,'a7132e09bb604915b8321dc4cf59f7d9','16124100234','16124100234','胡刘理','物理','40','有效'),(41,'d33c3c3a08b247c78d1e86e9ca7db46b','11111111111','11111111111','露露','物理','32','有效'),(42,'c910bda542684c65addac20e558cac0c','666666','666666','露小云','物理','32','有效'),(43,'88f3b8683e01498aa984dc5971cb142c','456','456','胡科库','物理','32','有效'),(44,'0599d57e645a49e4b9298edd6535b0b2','789','789','李热如','物理','8','有效'),(45,'2ecb28da1ed54b3e957f2009ae94ada7','100000','100000','胡梳理','物理','8','有效'),(46,'6642efee7f8d4c0e852f3c73c4d23784','789','789','李热如','物理','8','有效');

#
# Structure for table "student"
#

CREATE TABLE `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `student_uuid` varchar(255) NOT NULL DEFAULT '',
  `student_id` varchar(255) NOT NULL DEFAULT '',
  `student_name` varchar(255) DEFAULT NULL,
  `student_idcard` varchar(255) NOT NULL DEFAULT '',
  `student_teacherid` varchar(255) NOT NULL DEFAULT '',
  `student_active` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'3','16124100234','3','3','','3'),(6,'12332','1000001','张三','440536012251254025','','0'),(9,'12332','1000002','张三','440536012251254025','','0'),(10,'12332','1356663','回显胡','440536012251254025','','0'),(11,'12332','1000004','张三','440536012251254025','','0'),(12,'4912bc937fbe436cbdea81ed1ed55edf','1324655','车于中','553261952625362654','','0'),(13,'f867ede66fc84d74965c934edcd0dbf9','1612456','洪湖胡','4526231665826523568','','0'),(14,'049b01df462444779df2b2c09d536b01','16124100235','胡海峰','332653166253262548','','0'),(15,'a4d2a790ca6143bfa7371a16fa21420a','16124200236','东护具','423562723520235236','','0'),(16,'161f908881bc41efa7a9323ed5fd2bcf','16124100237','陈鱼鱼','3261202332623523162','','0'),(17,'d096c66b18cd45ca997a1dae4548f084','16124100238','陈鱼','3261202332623523160','','0'),(18,'8b0eabc7c6d240efb8ef2e555db3cf12','16124100239','户号云','336013230002365026','','0');

#
# Structure for table "student_course"
#

CREATE TABLE `student_course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) NOT NULL DEFAULT '',
  `course_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `student_id` (`student_id`),
  KEY `course_name` (`course_name`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "student_course"
#

INSERT INTO `student_course` VALUES (1,'16124100234','数学');

#
# Structure for table "student_teacher"
#

CREATE TABLE `student_teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(255) NOT NULL DEFAULT '',
  `teacher_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `student_id` (`student_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "student_teacher"
#

INSERT INTO `student_teacher` VALUES (1,'16124100234','26124100234');

#
# Structure for table "teacher"
#

CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_uuid` varchar(255) NOT NULL DEFAULT '',
  `teacher_id` varchar(255) NOT NULL DEFAULT '',
  `teacher_name` varchar(255) NOT NULL DEFAULT '',
  `teacher_idcard` varchar(255) NOT NULL DEFAULT '',
  `teacher_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (18,'fbd1a0db05fc44c7a32fc1e1c51b108b','2354658','李怀已','354665585256988','1'),(19,'3ea2bf64422047b497463166566f60e7','23542681','杨丽华','563826856548256859','---选择---'),(20,'7c9487f89c714b8dad030133b69d70d6','29564855','李武','56482356878156245',''),(24,'d89d76c1cdbf4a6a9ad3ad1c7ddcc640','23564223','红虎一','552346253252652356','0'),(26,'fd8af6527bfe4d9c8feafefc2cf107dd','23645895','胡U好','44352658/2123526332522356','0'),(28,'1592cbf33c4248dba7eb288a72e89c38','2432659588','缘分额','4235752356588','0'),(29,'fca30a78cae146988536cc9fd10a049c','23333333333333333333','萨芬','12345426754624','0'),(30,'96db910943c64e27915d3841bb6d26e1','2996355555555','何松虎','12415431224542112','0'),(31,'5021c470e2eb4f63ba83625120f77aa7','22222233','5555555555','555555555555555555','0'),(32,'8f2f296a1d104633a54e35c3bf97c0f4','666666666666','市八幡','12324','0'),(33,'14330c5f46884a129bb97c9cdbf75ae4','2324','符凡迪','3456783567787980','0'),(34,'','26124100234','陈红玉','351243023625231532','0');

#
# Structure for table "test"
#

CREATE TABLE `test` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `test_uuid` varchar(255) DEFAULT '',
  `test_question` varchar(255) DEFAULT NULL,
  `test_select_a` varchar(255) DEFAULT NULL,
  `test_select_b` varchar(255) DEFAULT NULL,
  `test_select_c` varchar(255) DEFAULT NULL,
  `test_select_d` varchar(255) DEFAULT NULL,
  `test_answer` varchar(255) DEFAULT NULL,
  `test_explain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "test"
#

INSERT INTO `test` VALUES (1,'','下列是小明使用天平的几点做法，其中正确的是（）','测量前将天平放在水平桌面上\r\n测量前将天平放在水平桌面上\r\n','调节横梁平衡时，游码可不在零刻度处\r\n','用手直接加减砝码\r\n','所测物体质量可以超过天平最大测量值\r\n','A','本题考查托盘天平的使用。在测量时，天平放在水平工作台上，A对；\r\n调节横梁平衡时，游码移至标尺零刻度线处后再旋动平衡螺母调节天平平衡，B错；\r\n在加减砝码时，需用镊子，不可用手，C错；\r\n所测物体质量不可以超过天平最大测量值，D错。\r\n'),(2,'','下列措施中能使蒸发变快的是（）','用电吹风机吹头发','给墨水瓶加盖','用地膜覆盖农田','把新鲜的苹果装入塑料袋 ','A','略'),(3,'','下列现象中，通过热传递改变物体内能的是（）','打开啤酒瓶盖，瓶口处气体温度降低','放进冰箱冷冻室的水变成冰块','用锯锯木头，锯条发热','用锯条锯木头，锯条发热','C','略'),(4,'','晚上,在桌面上铺一张白纸,把一块小平面镜压在白纸上,让手电筒的光正对着平面镜和白纸照射,人观察平面镜和白纸看到的现象是（）','平面镜比较亮','可能是白纸亮,也可能是平面镜亮','白纸比较亮','以上说法都不对','B','略'),(5,'','雨后的晚上，天刚放晴，地面虽已干，但仍留有不少积水，为了不致踩到地上的积水，下面正确的是（）','迎着月光走地上发亮处是积水，背着月光走地上暗处是积水','迎着月光走地上暗处是积水，背着月光走地上发亮处是积水','迎着月光或背着月光走，都是地上发亮处是积水','迎着月交或背着月光走，都是地上暗处是积水人站在竖直放','C','略'),(6,'','用托盘天平测物体的质量前，调节横梁平衡时，发现指针指在分度盘中线的左侧，这时应该（）','将游码向左移动\r\n','将右端平衡螺母向左旋进一些\r\n','将游码向右移动\r\n','将右端平衡螺母向右旋出一些\r\n','D','本题考查托盘天平的调节。调节天平横梁\r\n平衡的过程中，不能调节游码的位置；\r\n指针偏向分度盘的左侧，横\r\n梁左边的质量大，应该向右调节平衡螺母。\r\n'),(7,'','为了测一瓶油的质量，某同学采用了如下步骤错误的是（）','将游码置于左端零位置。\r\n','瓶放左盘，称得瓶的质量；\r\n','移动平衡螺母使横梁平衡','瓶放右盘，称得瓶的质量','D','本题考查测液体质量的方法。使用天\r\n平称量液体的质量时，为使测量结果准确，\r\n一般先称量容器的质量再称量液体和容器的\r\n总质量，用液体和容器的总质量减去容器的\r\n质量就得液体的质量。\r\n'),(8,'','用托盘天平测物体的质量前，调节横梁平衡时，发现指针指在分度盘中线的左侧，这时应该（）','将游码向左移动\r\n','将右端平衡螺母向左旋进一些\r\n','将游码向右移动\r\n','将右端平衡螺母向右旋出一些\r\n','D','本题考查托盘天平的调节。调节天平横梁\r\n平衡的过程中，不能调节游码的位置；\r\n指针偏向分度盘的左侧，横\r\n梁左边的质量大，应该向右调节平衡螺母。\r\n'),(9,'','为了测一瓶油的质量，某同学采用了如下步骤错误的是（）','将游码置于左端零位置。\r\n','瓶放左盘，称得瓶的质量；\r\n','移动平衡螺母使横梁平衡','瓶放右盘，称得瓶的质量','D','本题考查测液体质量的方法。使用天\r\n平称量液体的质量时，为使测量结果准确，\r\n一般先称量容器的质量再称量液体和容器的\r\n总质量，用液体和容器的总质量减去容器的\r\n质量就得液体的质量。\r\n'),(10,'','下列现象中，通过热传递改变物体内能的是（）','打开啤酒瓶盖，瓶口处气体温度降低','放进冰箱冷冻室的水变成冰块','用锯锯木头，锯条发热','用锯条锯木头，锯条发热','C','略'),(11,'','晚上,在桌面上铺一张白纸,把一块小平面镜压在白纸上,让手电筒的光正对着平面镜和白纸照射,人观察平面镜和白纸看到的现象是（）','平面镜比较亮','可能是白纸亮,也可能是平面镜亮','白纸比较亮','以上说法都不对','B','略'),(12,'','下列现象中，通过热传递改变物体内能的是（）','打开啤酒瓶盖，瓶口处气体温度降低','放进冰箱冷冻室的水变成冰块','用锯锯木头，锯条发热','用锯条锯木头，锯条发热','C','略'),(13,'','晚上,在桌面上铺一张白纸,把一块小平面镜压在白纸上,让手电筒的光正对着平面镜和白纸照射,人观察平面镜和白纸看到的现象是（）','平面镜比较亮','可能是白纸亮,也可能是平面镜亮','白纸比较亮','以上说法都不对','B','略'),(14,'9a5a01ffe9f649a0938e6cfbdafc4bbd','在一次实验中，用托盘天平测物体的质量前，调节横梁平衡时，发现指针指在分度盘中线的左侧，这时应该（）\r\n\r\n\r\n','将游码向左移动','将右端平衡螺母向左旋进一些','将游码向右移动','将右端平衡螺母向右旋出一些','D','本题考查托盘天平的调节。调节天平横梁 平衡的过程中，不能调节游码的位置； 指针偏向分度盘的左侧，横'),(15,'1321a5f2a68b40ccabecef74501faf17','有一次实验中，小红用托盘天平测物体的质量前，调节横梁平衡时，发现指针指在分度盘中线的左侧，这时他应该（）\r\n\r\n','将游码向左移动\r\n','将右端平衡螺母向左旋进一些\r\n','将右端平衡螺母向右旋出一些\r\n','将游码向右移动\r\n','C','略'),(16,'62dc289f0b9b4caeb32ae4f06d1184de','有一次实验中，实验人员甲用托盘天平测物体的质量前，调节横梁平衡时，发现指针指在分度盘中线的左侧，这时甲应该做什么（）\r\n\r\n','将游码向左移动\r\n','\r\n将右端平衡螺母向右旋出一些','将右端平衡螺母向左旋进一些\r\n','将游码向右移动\r\n','B','略，简单问题'),(17,'102fe5c896bc4a66a89f68e5f97d8553','下面熄灭酒精灯火的正确方法是（）','用嘴吹灭','用水熄灭','用灯盖盖灭','用抹布盖灭','C','此题为常识，简单的一批！');

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` varchar(255) DEFAULT NULL,
  `user_uuid` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_idcard` varchar(255) DEFAULT NULL,
  `user_phonenumber` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (9,'其它','16964f8ed23c400b9b3676132e6fe344','16124123514','陈雨力','123456','4423512635212232545','14235241125','1265689882@qq.com','是'),(31,'教务员','b4b050094f8a455cbe91fb0908441261','3123456','陈云南','123456','250212355201235685','17815362456','17815362456@163.com','是'),(32,'教务员','306984dc8c8349a4809712b74bdecdb3','31234567','李胡思','123456','250212355201235685','18815362456','18815362456@163.com','是'),(36,'管理员','d7a8e81b9efc4702b63868a859a06509','46124100238','楚云娜','111111','440235612225030211','123446622341','123446622341@qq.com','是'),(37,'学生','b24455f7e74541ed8c826e5fd7020b93','16124100238','楚娜','111111','440231612225030211','113446622341','113446622341@qq.com','是'),(38,'学生','995c450390a445d6b5a327b56c5e61a6','16543213245','胡都都','123456','234567433345667567','123456667544','123456667544@qq.com','是'),(39,'学生','95b6632389ed44ee949863e028fd7d06','123454654','司点点','23234','21312','11134132422','1113413242233@qq.com','是'),(40,'管理员','f281a609d0344f6c879e9a3a1abfb9d8','12345678','朱玉环','12345678','668235612532652356','17826354569','17826354569@qq.com','是'),(41,'学生','3735b7ed75754df6a6485dfe507a8eeb','16124100234','赵宇雨','123456','442316188523022615','13432652365','3264536258@qq.com','是'),(42,'管理员','dbf1f6bd103246d0a43d078729f125a4','13432819958','赵飞燕','111111','2234565333453345644','13432819958','13432819958@163.com','是'),(43,'管理员','b9843afe090c405a9745c34094eb999c','16543223245','胡都都','12345678','234567433387567567','123456567544','123456656544@qq.com','是'),(44,'学生','7df459af2ee94cfa8672f73ed553d24b','16543213245','胡都头','123456','23456723435667567','1234566621344','1234566621344@qq.com','是'),(45,'学生','9ca06d125104492eb927367a519cb9c1','16124100234','胡刘理','123456','34565782222233344556','13432819958','13432819958@163.com','是'),(46,'管理员','ca1cb762e0ce4c41984a85d31d8152f6','123','123','123','●●●','●●●','●●●@qq.com','是'),(47,'学生','db1e72439bb747ef9d135c2edf8ec69f','11111111111','露露','11111111111','33445625567565645656','13445567565','11111111111@qq.com','是'),(48,'管理员','369beeb0dcfc459bb97f35370a56b4b0','111','111','111','111','111','111@163.com','是'),(49,'学生','2b7e5ee140e74cd8993f5d96c3bf9d96','666666','露小云','666666','335436256552352545','134328165482','134328165482@162.com','是'),(50,'管理员','205ddc8cd7fb4ac184cae7c60bbc0f3a','246','陈云路','246','442315625862543256','1534625852','1534625852@163.com','是'),(55,'学生','b7e8cf643064437ea38c327e6f21d820','789','李热如','789','334556762667856789767','123457788797','123457788797@qq.com','是'),(56,'管理员','9fedcf9df36e4131886b85f92238cfe0','987','糊虎虎','987','3345634456455645645','13453282958','13453282958@163.com','是'),(58,'学生','46ce9ebc41f3489683463df2028b9804','100000','胡梳理','100000','442131595226322','1234552223','1234552223@qq.com','是'),(59,'管理员','b341eb6c3dca415293621cc63a9d285a','400000','胡胡户','400000','442256152351561','15242352625','15242352625@163.com','是'),(60,'学生','c8b60e99d7f24cf38f63524e3ecd59ca','15678','李云市','15678','44235612236565225','12354236525','12354236525@163.com','否');
