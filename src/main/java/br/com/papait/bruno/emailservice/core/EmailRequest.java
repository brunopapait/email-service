package br.com.papait.bruno.emailservice.core;

public record EmailRequest(String to, String subject, String body) {
}
