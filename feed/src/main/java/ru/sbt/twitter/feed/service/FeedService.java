package ru.sbt.twitter.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.twitter.feed.entity.FeedTable;
import ru.sbt.twitter.feed.repository.FeedRepositoryImpl;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private final FeedRepositoryImpl feedRepository;

    public FeedService(FeedRepositoryImpl feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<FeedTable> getFeed(Long ownerId) {
        List<FeedTable> news = feedRepository.findByOwnerid(ownerId);
        return news;
    }
}
