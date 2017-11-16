package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Nick Chi
 */
@Theme("valo")
@SpringUI
public class MainUI extends UI {
    @Autowired
    private CounterRepository repository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
        Counter cnt  = repository.findByPage("all");
        Integer counter = new Integer(cnt.value);
        counter++;
        cnt.value =  counter.toString();
        repository.save(cnt);
        layout.addComponent(new Button("This is a button"+counter));
        setContent(layout);
    }
}