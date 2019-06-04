package com.stackroute.muzixservice.listener;
import com.stackroute.muzixservice.domain.TrackDetails;
import com.stackroute.muzixservice.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class CommandlineListener implements ApplicationListener<ContextRefreshedEvent> {
    TrackDetails music=new TrackDetails();
    @Autowired
    MuzixRepository muzixRepository;
    @Autowired
    private Environment environment;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        music.setTrackId(Integer.parseInt(environment.getProperty("music1.tid")));
        music.setTrackName(environment.getProperty("music1.tname"));
        music.setTrackComment(environment.getProperty("music1.comments"));
        muzixRepository.save(music);
    }
}
