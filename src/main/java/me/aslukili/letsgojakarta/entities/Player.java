package me.aslukili.letsgojakarta.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billiards_table_id")
    private BilliardsTable billiardsTable;

    public Player() {

    }

    // we don't add the constractor to accept only the name of player and not the table where he will play! we add that later by the setter
    public Player(String fullName) {
      this.fullName = fullName;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public BilliardsTable getBilliardsTable() {
    return billiardsTable;
  }

  public void setBilliardsTable(BilliardsTable billiardsTable) {
    this.billiardsTable = billiardsTable;
  }

  @Override
    public String toString() {
      return "Course [id=" + id + ", title=" + fullName + "]";
    }
}
