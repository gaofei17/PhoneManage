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
	*JavaMail�����ʼ�:ǰ����QQ�������ʺ�����Ҫ����POP3/SMTPЭ��
	*/
	public class SendMail {
		
		//String time = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1) +"-"+ ""+now.get(Calendar.DAY_OF_MONTH)+"^"+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
		static String phinf = null; //��ȡ������ϸ
		static String users = null;//��ȡ�����
		static String address = null;//��ȡ�ʼ���ַ

	public void send(String phoneinf,String user,String mail_address) throws Exception {
        phinf = phoneinf;
        users = user;
        address = mail_address;
	Properties prop = new Properties();
	// ����debug���ԣ��Ա��ڿ���̨�鿴
	prop.setProperty("mail.debug", "true");
	// �����ʼ�������������
	prop.setProperty("mail.host", "smtp.qq.com");
	// ���ͷ�������Ҫ�����֤
	prop.setProperty("mail.smtp.auth", "true");
	// �����ʼ�Э������
	prop.setProperty("mail.transport.protocol", "smtp");

	// ����SSL���ܣ������ʧ��
	MailSSLSocketFactory sf = new MailSSLSocketFactory();
	sf.setTrustAllHosts(true);
	prop.put("mail.smtp.ssl.enable", "true");
	prop.put("mail.smtp.ssl.socketFactory", sf);

	// ����session
	Session session = Session.getInstance(prop);
	// ͨ��session�õ�transport����
	Transport ts = session.getTransport();
	// �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
	ts.connect("smtp.163.com","tpmsys", "jiah2017");//������ַ�����Ȩ�룬��qq���뷴������ʧ���ˣ����Լ��ģ������ҵģ����������Ϲ��ģ�Ϊ�ˡ���������
	// �����ʼ�
	Message message = createSimpleMail(session);
	// �����ʼ�
	ts.sendMessage(message, message.getAllRecipients());
	ts.close();
	}

	/**
	* @Method: createSimpleMail
	* @Description: ����һ��ֻ�����ı����ʼ�
	*/
	public static MimeMessage createSimpleMail(Session session)
	throws Exception {
	// �����ʼ�����
	MimeMessage message = new MimeMessage(session);
	// ָ���ʼ��ķ�����
	message.setFrom(new InternetAddress("tpmsys@163.com"));
	// ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
	//���ͳ�����
	//message.setRecipients(Message.RecipientType.CC, "1311484647@qq.com");
	//message.setRecipients(Message.RecipientType.CC, "1595745320@qq.com");
	
	//���ö��������
	// ��ȡ��������Ϣ
    String[] ccs = {"zhong_t@tengruifeng.com","jia_h@tengruifeng.com"};
    if (ccs != null){
        // Ϊÿ���ʼ������ߴ���һ����ַ
        Address[] ccAdresses = new InternetAddress[ccs.length];
        for (int i=0; i<ccs.length; i++){
            ccAdresses[i] = new InternetAddress(ccs[i]);
        }
        // ����������Ϣ���õ��ʼ���Ϣ�У�ע������ΪMessage.RecipientType.CC
        message.setRecipients(Message.RecipientType.CC, ccAdresses);
    }
    
   // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
  //  String time = format.format(Calendar.getInstance().getTime()); //��ȡ������ʱ����
    
    //
     //��ȡϵͳ����ʱ��
    Calendar now = Calendar.getInstance(); //��ȡϵͳʱ��
	String time = now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH) + 1) +"-"+ ""+now.get(Calendar.DAY_OF_MONTH)+"^"+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND);
	
	// �ʼ��ı���
	//message.setSubject(users+",���"+"���ѽ�"+phinf+"����֪Ϥ��");
	
	message.setSubject(users+",�����½������");
	//����
	String htmltext= phinf+"��"+time+"��� "+users+"��ע��! ���������Ʊ��ܣ������뼰ʱ�黹����ʧһ���ɸ��˸���----------------------------------------------------------------------------------------------------------------------------------"+"���ʼ���ϵͳ�Զ�����������ظ����������뼰ʱ��ͨлл������ ���ʼ���Ϊ�������ƾ֤��";
	// �ʼ����ı�
	message.setContent(htmltext, "text/html;charset=UTF-8");
	// ���ش����õ��ʼ�����
	return message;
	}
	}