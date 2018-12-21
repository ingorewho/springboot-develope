/**
 * 
 */
package mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author ignore1992
 *
 */
@Service
public class MailSendService
{
	@Autowired
	private JavaMailSender mailSender;
	
	/**日志打印.*/
	private Logger logger = Logger.getLogger(MailSendService.class);
	
	/**
	 * 发送简单邮件
	 * @param fromPos 发送地址
	 * @param toPos 目的地址
	 * @param subject 邮件主题
	 * @param text 邮件内容
	 * @return 发送是否成功
	 */
	public boolean sendSimpleMail(String fromPos, String toPos, String subject, String text)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromPos);
		//可添加多个目的地址
		msg.setTo(toPos);
		msg.setSubject(subject);
		msg.setText(text);
		//msg.setBcc(bcc) 密送地址 
		//msg.setCc(cc) 抄送地址
		try
		{
			mailSender.send(msg);
		}
		catch (Exception e) 
		{
			logger.error("发送简单邮件失败.", e);
			return false;
		}
		return true;
	}
	
	/**
	 * 发送带有附件的邮件
	 * @param fromPos 发送地址
	 * @param toPos 目的地址
	 * @param subject 邮件主题
	 * @param file 附件
	 * @return 发送是否成功 
	 */
	public boolean sendAttachFileMail(String fromPos, String toPos, String subject, String text, FileSystemResource file)
	{
		MimeMessage msg = mailSender.createMimeMessage();
		try
		{
			//MimeMessageHelper构造器，如果要发送附件邮件，必须指定multipart参数为true
			MimeMessageHelper helper  = new MimeMessageHelper(msg, true);
			helper.setFrom(fromPos);
			helper.setTo(toPos);
			helper.setSubject(subject);
			helper.setText(text);
			helper.addAttachment(file.getFilename(), file);
			mailSender.send(msg);
		} 
		catch (MessagingException e)
		{
			logger.error("发送附件邮件失败.", e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 发送静态资源的文件,如：图片
	 * @param fromPos 发送地址
	 * @param toPos 目的地址
	 * @param subject 邮件主题
	 * @param file 附件
	 * @return 发送是否成功 
	 */
	public boolean sendInlineMail(String fromPos, String toPos, String subject, FileSystemResource file)
	{
		MimeMessage msg = mailSender.createMimeMessage();
		try
		{
			//MimeMessageHelper构造器，如果要发送附件邮件，必须指定multipart参数为true
			MimeMessageHelper helper  = new MimeMessageHelper(msg, true);
			helper.setFrom(fromPos);
			helper.setTo(toPos);
			helper.setSubject(subject);
			helper.setText("<html><body>静态资源:<img src='cid:pic' /></body></html>", true);
			helper.addInline("pic", file);
			mailSender.send(msg);
		} 
		catch (MessagingException e)
		{
			logger.error("发送附件邮件失败.", e);
			return false;
		}
		
		return true;
	}
	
	
}
