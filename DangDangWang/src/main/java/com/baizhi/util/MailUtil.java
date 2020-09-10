package com.baizhi.util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

	// 1.设置发送邮件的一些参数
	private static Properties pro = new Properties();

	static {
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.host", "smtp.qq.com");
		pro.setProperty("mail.smtp.auth", "true");
		pro.setProperty("mail.smtp.port", "587");
	}

	public static int sendSimpleMail(String accepter,String title,String content) {
		int res = 0;
		String sender="574432753@qq.com";//发件人
		String code="anslcusqzgipbdda";//发件人账号对应的授权码
		try {
			// 2.创建一个会话对象和邮件服务器交互
			Session session = Session.getDefaultInstance(pro);
			// 3.创建一个邮件对象
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(sender)); // 发送人

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(accepter)); // 收件人

			message.setSubject(title);// 设置邮件的标题

			//email是收件人的邮箱地址。
			message.setContent(content, "text/html;charset=UTF-8");// 设置邮件的正文

			message.setSentDate(new Date());// 发送时间

			message.saveChanges(); // 保存设置

			Transport transport = session.getTransport();// 获取一个传输对象

			transport.connect(sender, code);// 设置发送邮件用户名和密码

			transport.sendMessage(message, message.getAllRecipients());// 发送邮件

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
