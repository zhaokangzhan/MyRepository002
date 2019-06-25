-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2018 年 08 月 04 日 06:56
-- 服务器版本: 5.5.53
-- PHP 版本: 5.4.45

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `userdb`
--

-- --------------------------------------------------------

--
-- 表的结构 `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(30) DEFAULT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `author` varchar(30) NOT NULL,
  `print` varchar(30) NOT NULL,
  `price` varchar(30) NOT NULL,
  `tip` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=98 ;

--
-- 转存表中的数据 `books`
--

INSERT INTO `books` (`id`, `bookid`, `bookname`, `author`, `print`, `price`, `tip`) VALUES
(61, '61', '61', '61', '61', '61', '61'),
(58, '1', '1', '1', '1', '1', '1'),
(59, '59', '59', '59', '新华出版社', '59', '已付款'),
(89, '赵', '答', '沙发', '新华出版社', '333的', '未付款'),
(72, '2', '2', '2', '', '2', 'on'),
(82, '2', '2', '2', '2', '2', '2'),
(68, '2', '2', '2', '2', '2', '2'),
(79, '2', '2', '2', '2', '2', '2'),
(78, '历史类', '《铭记》', '葫芦娃', '天津出版社', '30￥', '未付款'),
(83, '1', '1', '1', '', '1', '已付款'),
(84, '文学', '《说我是谁》', '葫芦娃', '新华出版社', '11￥', '未付款'),
(87, '2', '查询', '订单', '新华出版社', '23￥', '已付款'),
(88, 'zhans', 'zhans', 'zhans', '新华出版社', 'zhans', '未付款'),
(90, '阿萨德', '1赵', '1我', '新华出版社', '11￥', '已付款'),
(91, '123', '1赵康展', '16124100234赵康展', '天津出版社', '11￥', '未付款');

-- --------------------------------------------------------

--
-- 表的结构 `suppliers`
--

CREATE TABLE IF NOT EXISTS `suppliers` (
  `id` int(60) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `suppliername` text NOT NULL,
  `suppliercertificate` text NOT NULL,
  `supplierpnumber` text NOT NULL,
  `supplieremail` text NOT NULL,
  `supplieraddress` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `suppliers`
--

INSERT INTO `suppliers` (`id`, `suppliername`, `suppliercertificate`, `supplierpnumber`, `supplieremail`, `supplieraddress`) VALUES
(1, '新东方', '中国书籍许可001号', '17819184355', '3541102658@qq.com', '中国/广东省/茂名市/茂南区/广东石油化工学院'),
(2, '新鸿集团', '兴华印刷许可002号', '13421628957', '3542681975@163.com', '中国/湖南/香江/鸿鹄市'),
(3, '图书百汇', '兴华印刷许可002号', '153566254822', '2358566@126.com', '中国/湖南/香江/鸿鹄市'),
(4, '新鸿集团', '兴华印刷许可003号', '13421628957', '3542681975@163.com', '中国/四川/昆明市/贵干'),
(5, '图书百汇', '兴华印刷许可005号', '153566254822', '2358566@126.com', '中国/湖南/香江/鸿鹄市'),
(6, '图书百汇\r\n\r\n\r\n\r\n', '兴华印刷许可005号', '153566254822', '2358566@126.com', '中国/四川/攀枝花/......'),
(7, '华南教科书', '广东省图书监管局005号', '153468255668', '3584922777@163.com', '广东省/湛江市/遂溪'),
(8, '百汇通\r\n\r\n\r\n\r\n', '兴华印刷许可026号', '15354254822', '2358566@126.com', '中国/广西/桂林/......'),
(9, '华南教科书', '广东省图书监管局345号', '15346349568', '352755777@163.com', '浙江/扣扣市/肉肉');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `phonenumber`, `email`) VALUES
(1, '1', '1', '1', '1'),
(20, 'newuser', '133456', '13432819958', '3543338298@qq.com'),
(17, 'zhao', '123456', '13432819958', '3543338298@qq.com'),
(16, 'zhaokangzhan', '123456', '12333456647322', '3543338298@qq.com'),
(15, '44', '44', '44', '44'),
(18, '用户名称', '用户密码', '用户电话：', '电子邮箱：'),
(19, '用户名', '密码', '手机号', '@qq.com'),
(35, '赵康展', '1234567', '1531234567', '354333828@qq.com'),
(28, '赵康展', '123', '13432819958', '3543338298@qq.com'),
(37, '赵康展', '123456', '1531234567', '3123456@163.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
