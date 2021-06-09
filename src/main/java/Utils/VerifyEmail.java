package Utils;


import java.util.Properties;
 
import javax.mail.*;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;


 
public class VerifyEmail {
 
	public void checkMail(String mail , String Password) {
	
		try{
			
			Properties props = new Properties();
			props.put("mail.store.protocol", "imaps");
			
			Session session = Session.getInstance(props);
			Store store = session.getStore("imaps");

			store.connect("imap.gmail.com", mail , Password );

			Folder folder = store.getFolder("[Gmail]/Inbox");
			folder.open(Folder.READ_ONLY);
			

			Message[] messages = folder.getMessages();
            
			for(int i=0;i<messages.length;i++){
				
				Message msg = messages[i];
				
				String subText = "";
				Object subject = msg.getSubject();
				subText = (String) subject;
				
				if(subText.equalsIgnoreCase("Testing Demo Shop"))
				{
					System.out.print("verification mail sent");
					break;
					
				}

				
			}
			
			
		}catch(MessagingException ME){
			ME.printStackTrace();
			
		}catch(Exception E){
			E.printStackTrace();
			
		}
		
		
	}
 
}