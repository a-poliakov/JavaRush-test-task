package javarush.test.config;

import javarush.test.dao.UserDao;
import javarush.test.entity.User;
import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Component
public class AppInitialiser implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        CheckForUsers();
        alreadySetup = true;
    }

    private void CheckForUsers(){
        if(userDao.getAll().size() == 0){
            for (int i = 0; i < 30; i++) {
                User user = new User();
                user.setAge(new Random().nextInt(100));
                user.setIsAdmin(false);
                if(i%3 == 0){
                    user.setName("Петя");
                } else if(i%3 == 1){
                    user.setName("Вася");
                } else {
                    user.setName("Коля");
                }
                userDao.save(user);
            }
        }
    }
}

