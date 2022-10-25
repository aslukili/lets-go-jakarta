package me.aslukili.letsgojakarta.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "billiards_tables")
public class BilliardsTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "table_name")
  private String firstName;


  @OneToMany(mappedBy = "billiardsTable", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  private List<Player> players;

  public BilliardsTable() {

  }

  public BilliardsTable(int id, String firstName) {
    this.id = id;
    this.firstName = firstName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BilliardsTable that = (BilliardsTable) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(players, that.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, players);
  }
}
