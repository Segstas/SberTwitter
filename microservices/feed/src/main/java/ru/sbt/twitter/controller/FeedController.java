package ru.sbt.twitter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.OwnerSubscriptions;
import ru.sbt.twitter.entity.Tweet;
import ru.sbt.twitter.entity.User;
import ru.sbt.twitter.service.FeedService;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class FeedController {
    private final RestTemplate template;
    private final FeedService feedService;

    @GetMapping("/feed/{ownerid}")
    public ResponseEntity<List<FeedDTOInterface>> getFeed(@PathVariable("ownerid") Long ownerid) {
        List<FeedDTOInterface> feed = feedService.getFeed(ownerid);
        return new ResponseEntity<>(feed, OK);
    }
    @GetMapping("/tweets/{userid}")
    public ResponseEntity<Set<Tweet>> getTweets(@PathVariable("userid") Long userid) {
        Set<Tweet> tweets = feedService.getTweets(userid);
        return new ResponseEntity<>(tweets, OK);
    }
    @GetMapping("/userinfo/{userid}")
    public ResponseEntity<User> getUser(@PathVariable("userid") Long userid) {
        User user = feedService.getUserInfoById(userid);
        return new ResponseEntity<>(user, OK);
    }
    @PostMapping("/addSubscriber/{ownerid}")
    public void getTwitts(@PathVariable("ownerid") Long ownerid,
                                       @RequestParam("userid") Long userid) {
        OwnerSubscriptions subs = new OwnerSubscriptions(ownerid, userid);
        feedService.addSubscriber(subs);
    }



}
