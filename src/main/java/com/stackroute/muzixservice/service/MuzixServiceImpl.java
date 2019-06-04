package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.TrackDetails;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {
    private MuzixRepository muzixRepository;
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository)

    {
        this.muzixRepository=muzixRepository;
    }
    @Override
    public TrackDetails saveTrack(TrackDetails trackDetails)throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(trackDetails.getTrackId()))
        {
            throw new TrackAlreadyExistsException("tack is not found");
        }
        TrackDetails savedTrack=muzixRepository.save(trackDetails);
        return savedTrack;
    }
    @Override
    public TrackDetails displayTrackById(int trackId)
    {
        return muzixRepository.findById(trackId).get();
    }
//    @Override
//    public TrackDetails displayTrackByName(String trackName)
//    {
//        return muzixRepository.displayTrackByName(trackName);
    //}

    @Override
    public List<TrackDetails> displayTrack() {
    return muzixRepository.findAll();
    }

    @Override
    public void removeTrack(int trackId) {
         muzixRepository.deleteById(trackId);
    }

    @Override
    public TrackDetails updateTrackComments(TrackDetails trackDetails,int trackId) throws TrackNotFoundException {
        if(!muzixRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("tack is not found");
        }
        TrackDetails trackDetails1=muzixRepository.findById(trackId).get();
        trackDetails1.setTrackComment(trackDetails.getTrackComment());
        return muzixRepository.save(trackDetails1);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        muzixRepository.save(new TrackDetails(4,"hey baby","this is not good"));
//
//    }
//@Value("hello")
//String trackname;
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        muzixRepository.save(new TrackDetails(3,trackname,"this is bad"));
//    muzixRepository.save(new TrackDetails(1,"kesari","this is awesome"));
//    muzixRepository.save(new TrackDetails(2,"hey baby","this is good"));
//
//    }
}
