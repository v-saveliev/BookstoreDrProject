package org.bookstore.app.services;
import org.apache.log4j.Logger;
import org.bookstore.app.aspects.LoggerMark;
import org.bookstore.web.dto.LoginForm;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);

    @LoggerMark
    public boolean authenticate(LoginForm loginForm) {
        logger.info("try auth with user-form: " + loginForm);
        return loginForm.getUsername().equals("root") && loginForm.getPassword().equals("123");
    }

}