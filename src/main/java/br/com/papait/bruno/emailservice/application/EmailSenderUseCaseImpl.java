package br.com.papait.bruno.emailservice.application;

import br.com.papait.bruno.emailservice.adapters.EmailSenderGateway;
import br.com.papait.bruno.emailservice.core.EmailSenderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailSenderUseCaseImpl implements EmailSenderUseCase {

  private final EmailSenderGateway emailSenderGateway;
  @Override
  public void execute(String to, String subject, String body) {
    this.emailSenderGateway.sendEmail(to, subject, body);
  }
}
