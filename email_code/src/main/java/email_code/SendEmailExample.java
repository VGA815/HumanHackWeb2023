package email_code;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import config.Сonfig;

import java.io.IOException;
import java.security.SecureRandom;

public class SendEmailExample {

    public boolean getMessage(String email,String key) throws IOException  {
    	Сonfig cfg = new Сonfig();
    	
        String apiKey = cfg.getApiKey();
        Email from = new Email(cfg.getDisgustingMail());
        String subject = "Код подтверждения";
        Email to = new Email(email);
        Content content = new Content("text/plain", cfg.getTextMessage()+" "+key);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
        	 request.setMethod(Method.POST);
             request.setEndpoint("mail/send");
             request.setBody(mail.build());
             Response response = sg.api(request);

             if (response.getStatusCode() == 202)  return true;
              else  return false;
             

        } catch (IOException ex) {
            return false;
        }
    }
    
    
    public String generateKey() {
        // Задаем символы, которые могут использоваться в ключе
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Устанавливаем длину ключа
        int keyLength = 6;

        // Создаем объект SecureRandom для генерации случайных чисел
        SecureRandom random = new SecureRandom();

        // Используем StringBuilder для построения ключа
        StringBuilder keyBuilder = new StringBuilder(keyLength);

        // Генерируем случайные символы и добавляем их к ключу
        for (int i = 0; i < keyLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            keyBuilder.append(randomChar);
        }

        // Возвращаем сгенерированный ключ
        return keyBuilder.toString();
    }
    
}
