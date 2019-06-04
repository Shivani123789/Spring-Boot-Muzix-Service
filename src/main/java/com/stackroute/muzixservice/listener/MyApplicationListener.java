package com.stackroute.muzixservice.listener;

import com.stackroute.muzixservice.domain.TrackDetails;
import com.stackroute.muzixservice.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:configure.properties")
public class MyApplicationListener implements CommandLineRunner {
    @Value("${music2.id}")
    private int id;
    @Value("${music2.name}")
    private String name;
    @Value("${music2.comments}")
    private String comments;

    TrackDetails music=new TrackDetails();
    @Autowired
    MuzixRepository muzixRepository;
    @Override
    public void run(String... args) throws Exception {
        music.setTrackId(id);
        music.setTrackName(name);
        music.setTrackComment(comments);
        muzixRepository.save(music);
    }
}