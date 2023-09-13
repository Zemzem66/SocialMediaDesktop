package com.example.socialmedia.view;

import com.example.socialmedia.data.HibernateSessionFactory;
import com.example.socialmedia.event.EventAggregator;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.RegisterService;
import com.example.socialmedia.viewmodel.LoginViewModel;
import com.example.socialmedia.viewmodel.RegisterViewModel;

public class ViewFactory {

    private static ViewFactory instance;

    private final EventAggregator eventAggregator;

    //private final MainViewModel mainViewModel;
    private final LoginViewModel loginViewModel;

    private final HibernateSessionFactory sessionFactory;


    private final UserRepository userRepository;

    private final RegisterViewModel registerViewModel;

    private final RegisterService registerService;

    private ViewFactory() {

        eventAggregator = new EventAggregator();

        sessionFactory = new HibernateSessionFactory();
        userRepository = new UserRepository(sessionFactory,eventAggregator);
        registerService = new RegisterService(userRepository);
        loginViewModel = new LoginViewModel();
        registerViewModel = new RegisterViewModel(eventAggregator,registerService);


     // mainViewModel = new MainViewModel();
    }


    public Object create(Class<?> viewClass)
    {
        if(viewClass == MainView.class)
        {
            return new MainView();
        }

        if(viewClass == LoginView.class)
        {
            return new LoginView(loginViewModel);
        }

        if(viewClass == RegisterView.class)
        {
            return new RegisterView(registerViewModel);
        }
        throw new IllegalArgumentException("Unknown view class" + viewClass);
    }




    //To create a new instance if not able do this ->
    public static ViewFactory getInstance()
    {
        if(null == instance)
        {
            instance = new ViewFactory();
        }
        return instance;
    }
}
