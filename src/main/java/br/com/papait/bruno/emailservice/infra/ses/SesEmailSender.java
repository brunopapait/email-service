package br.com.papait.bruno.emailservice.infra.ses;

import br.com.papait.bruno.emailservice.adapters.EmailSenderGateway;
import br.com.papait.bruno.emailservice.core.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesEmailSender implements EmailSenderGateway {

  private final AmazonSimpleEmailService amazonSimpleEmailService;

  @Override
  public void sendEmail(String to, String subject, String body) {
    var sendEmailRequest = new SendEmailRequest();
    sendEmailRequest.withSource("brunohpapait@gmail.com");
    sendEmailRequest.withDestination(new Destination().withToAddresses(to));

    var message = new Message();
    message.withSubject(new Content(subject));
    message.withBody(new Body().withText(new Content(body)));
    sendEmailRequest.withMessage(message);

    try {
      this.amazonSimpleEmailService.sendEmail(sendEmailRequest);
    } catch (AmazonServiceException amazonServiceException) {
      amazonServiceException.printStackTrace();
      throw new EmailServiceException("Failure sending email", amazonServiceException);
    }
    }
}
