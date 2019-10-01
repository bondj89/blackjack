package edu.cnm.deepdive.blackjack.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity( // this is an annotation.
    foreignKeys = {
        @ForeignKey(
           entity = Round.class,
            childColumns = "round_id", // without curly brackets because an array
            parentColumns = "round_id",
            onDelete = ForeignKey.CASCADE // this deletes everything.
        )
    }
)
public class Hand {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "hand_id")
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  // adding index speed up retrieval but do slow down updates & deletions.
  private Date created = new Date();

  @NonNull
  @ColumnInfo(index = true)
  private Date updated = new Date();

  private boolean dealer;

  @ColumnInfo(name = "round_id", index = true)
  private long roundId;

  private int wager;

  @ColumnInfo(index = true)
  private Outcome outcome;

  public long getIt() {
    return id;
  }

  public void setIt(long it) {
    this.id = it;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  @NonNull
  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(@NonNull Date updated) {
    this.updated = updated;
  }

  public boolean isDealer() {
    return dealer;
  }

  public void setDealer(boolean dealer) {
    this.dealer = dealer;
  }

  public long getRoundId() {
    return roundId;
  }

  public void setRoundId(long roundId) {
    this.roundId = roundId;
  }

  public int getWager() {
    return wager;
  }

  public void setWager(int wager) {
    this.wager = wager;
  }

  public Outcome getOutcome() {
    return outcome;
  }

  public void setOutcome(Outcome outcome) {
    this.outcome = outcome;
  }

  public enum Outcome {
    WIN, LOSS, PUSH;
  }

}
