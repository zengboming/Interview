README

测试一：
运行程序，输入：
U002 2017-08-01 19:00~22:00 A
U003 2017-08-02 13:00~17:00 B
U004 2017-08-03 15:00~16:00 C
U005 2017-08-05 09:00~11:00 D

正确输出为：
Success: the booking is accepted!
Success: the booking is accepted!
Success: the booking is accepted!
Success: the booking is accepted!

继续输入：回车
正确输出为：
收入汇总
---
场地:A
2017-08-01 19:00~22:00 200元
小计: 200元

场地:B
2017-08-02 13:00~17:00 200元
小计: 200元

场地:C
2017-08-03 15:00~16:00 50元
小计: 50元

场地:D
2017-08-05 09:00~11:00 80元
小计: 80元
---
总计: 530元
	
	
测试二：
运行程序，输入：
U002 2017-08-01 19:00~22:00 A
U003 2017-08-01 18:00~20:00 A
U002 2017-08-01 19:00~22:00 A C
U002 2017-08-01 19:00~22:00 A C
U003 2017-08-01 18:00~20:00 A
U003 2017-08-02 13:00~17:00 B

正确输出为：
Success: the booking is accepted!
Error: the booking conflicts with existing bookings!
Success: the booking is accepted!
Error: the booking being cancelled does not exist!
Success: the booking is accepted!
Success: the booking is accepted!

继续输入：回车
正确输出为：
收入汇总
---
场地:A
2017-08-01 19:00~22:00 违约金 100元
2017-08-01 18:00~20:00 160元
小计: 260元

场地:B
2017-08-02 13:00~17:00 200元
小计: 200元

场地:C
小计: 0元

场地:D
小计: 0元
---
总计: 460元