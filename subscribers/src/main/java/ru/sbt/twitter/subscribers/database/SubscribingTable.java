package ru.sbt.twitter.subscribers.database;

import javax.persistence.*;

@Entity
@IdClass(Subscribing.class)
@Table(name="SUBSCRIBING")
public class SubscribingTable {
    @Id
    @Column(name = "USER_ID")
    private Long user_id;

    @Id
    @Column(name = "SUBSCRIBING_ID")
    private Long subscribing_id;
}