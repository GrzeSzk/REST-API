package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyDetails companyDetails;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://grzeszk.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_name", companyDetails.getCompanyName());
        context.setVariable("company_goal", companyDetails.getCompanyGoal());
        context.setVariable("company_mail", companyDetails.getCompanyMail());
        context.setVariable("company_phone", companyDetails.getCompanyPhone());
        context.setVariable("goodbye_message", "Yours sincerely task CRUD api team");
        context.setVariable("preview_message", "Trello board update info");
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
