package org.nemanjamarjanovic.rekomendator.presentation.user;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.nemanjamarjanovic.rekomendator.bussines.user.boundary.UserDao;

/**
 *
 * @author nemanja
 */
@Named
@ConversationScoped
public class UserRegistrationForm implements Serializable
{

//    @EJB
//    UserDao userDao;
//
//    @Inject
//    Conversation conversation;
//
//    private String username;
//
//    @PostConstruct
//    public void init()
//    {
//        username = "";
//        conversation.begin();
//    }
//
//    public void createUser()
//    {
//        userDao.create(username);
//        username = "";
//        conversation.end();
//        conversation.begin();
//    }
//    
//    public void reset(){}
//
//    public String getUsername()
//    {
//        return username;
//    }
//
//    public void setUsername(String username)
//    {
//        this.username = username;
//    }

}
