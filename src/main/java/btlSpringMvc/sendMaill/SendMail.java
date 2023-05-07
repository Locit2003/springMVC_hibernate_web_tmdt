package btlSpringMvc.sendMaill;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class SendMail {
	public static void main(final String[] args) {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	    MailSender mailSender = (MailSender) context.getBean("mailSender2");
	    System.out.println("Sending text...");
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom("locit2003@gmail.com");
	    message.setTo("locpham5155@gmail.com");
	    message.setSubject("Subject");
	    message.setText("test send gmail using spring");
	    // sending message
	    mailSender.send(message);
	    System.out.println("Sending text done!");
	    context.close();
	  }
}
