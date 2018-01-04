package com.dingrui.gaofei.tools;
	
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

	/**
	*JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
	*/
	public class SendMail {
		
		//String time = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1) +"-"+ ""+now.get(Calendar.DAY_OF_MONTH)+"^"+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
		static String phinf = null; //获取样机详细
		static String users = null;//获取借机人
		static String address = null;//获取邮件地址

	public void send(String phoneinf,String user,String mail_address) throws Exception {
        phinf = phoneinf;
        users = user;
        address = mail_address;
	Properties prop = new Properties();
	// 开启debug调试，以便在控制台查看
	prop.setProperty("mail.debug", "true");
	// 设置邮件服务器主机名
	prop.setProperty("mail.host", "smtp.qq.com");
	// 发送服务器需要身份验证
	prop.setProperty("mail.smtp.auth", "true");
	// 发送邮件协议名称
	prop.setProperty("mail.transport.protocol", "smtp");

	// 开启SSL加密，否则会失败
	MailSSLSocketFactory sf = new MailSSLSocketFactory();
	sf.setTrustAllHosts(true);
	prop.put("mail.smtp.ssl.enable", "true");
	prop.put("mail.smtp.ssl.socketFactory", sf);

	// 创建session
	Session session = Session.getInstance(prop);
	// 通过session得到transport对象
	Transport ts = session.getTransport();
	// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
	ts.connect("smtp.163.com","tpmsys", "jiah2017");//后面的字符是授权码，用qq密码反正我是失败了（用自己的，别用我的，这个号是我瞎编的，为了。。。。）
	// 创建邮件
	Message message = createSimpleMail(session);
	// 发送邮件
	ts.sendMessage(message, message.getAllRecipients());
	ts.close();
	}

	/**
	* @Method: createSimpleMail
	* @Description: 创建一封只包含文本的邮件
	*/
	public static MimeMessage createSimpleMail(Session session)
	throws Exception {
	// 创建邮件对象
	MimeMessage message = new MimeMessage(session);
	// 指明邮件的发件人
	message.setFrom(new InternetAddress("tpmsys@163.com"));
	// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
	//发送抄送人
	//message.setRecipients(Message.RecipientType.CC, "1311484647@qq.com");
	//message.setRecipients(Message.RecipientType.CC, "1595745320@qq.com");
	
	//设置多个抄送人
	// 获取抄送者信息
    String[] ccs = {"zhong_t@tengruifeng.com","jia_h@tengruifeng.com"};
    if (ccs != null){
        // 为每个邮件接收者创建一个地址
        Address[] ccAdresses = new InternetAddress[ccs.length];
        for (int i=0; i<ccs.length; i++){
            ccAdresses[i] = new InternetAddress(ccs[i]);
        }
        // 将抄送者信息设置到邮件信息中，注意类型为Message.RecipientType.CC
        message.setRecipients(Message.RecipientType.CC, ccAdresses);
    }
    
   // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
  //  String time = format.format(Calendar.getInstance().getTime()); //获取年月日时分秒
    
    //
     //获取系统日期时间
    Calendar now = Calendar.getInstance(); //获取系统时间
	String time = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1) +"-"+ ""+now.get(Calendar.DAY_OF_MONTH)+"^"+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
	
	// 邮件的标题
	//message.setSubject(users+",你好"+"你已借"+phinf+"，请知悉！");
	
	message.setSubject(users+",你有新借机器。");
	//内容
	String htmltext= phinf+"于"+time+"借给 "+users+"；注意! 样机请妥善保管，不用请及时归还，丢失一概由个人负责！----------------------------------------------------------------------------------------------------------------------------------"+"此邮件由系统自动发出，请勿回复，有疑问请及时沟通谢谢！！！ 此邮件做为样机借机凭证。";
	// 邮件的文本
	message.setContent(htmltext, "text/html;charset=UTF-8");
	// 返回创建好的邮件对象
	return message;
	}
	}