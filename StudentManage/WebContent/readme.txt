1.tic(technology innovation competition)采用Struts2.3+Spring4.0+Hibernate3.6集成框架
  Mysql数据库   tomcat7+jdk1.7
2.1)android登录访问地址：http://localhost:8080/StudentManage/android/loginAction
      用户名student.username  密码：student.password （字符串格式） ，登录成功返回success和student信息（学号，姓名，性别，出生年月，
      手机号，班级名称，专业名称，院系名称），都是json格式的
      
                                                           
  2)android修改个人信息地址：http://localhost:8080/StudentManage/android/updateAction
                          json数据，封装学号number，用户名username，性别sex，出生日期birthday（date类型），
                                                                      手机号phone,修改成功返回success，json格式
  3)android修改个人密码地址：http://localhost:8080/StudentManage/android/pwdAction
                                                                    提交 学号：student.number   最终密码student.password（字符串格式）
  4)android获取同班的学生地址：http://localhost:8080/StudentManage/android/stuListAtion
                                                                     提交学号 student.number  字符串      
                                                                     
备注：android客户端提交的字段需要和上面的保持一致，后端才能获取到。                                                                                                                           
                          

                                       