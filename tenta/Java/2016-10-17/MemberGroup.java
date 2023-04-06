// Lösningsförslag till tentamen 2016-10-17
// Uppgift B2

import java.util.*;

public class MemberGroup {
  // Instansvariablerna är givna
  private String identity;
  private ArrayList<Member> memberList;
  
  // uppg a)
  public MemberGroup(String id) {
    this.identity = id;
    this.memberList = new ArrayList<Member>();
  }
  
  // Given metod
  public String getIdentity() {
    return this.identity;
  }

// uppg b)
  public int getAntal() {
    return this.memberList.size();
  }
  
  // uppg c)
   public void add(Member m) {
    this.memberList.add(m);
  }
  
   // uppg d)
  public void printMatchValues() {
    for (int i=0; i<this.memberList.size()-1; i++) {
      for (int j=i+1; j<this.memberList.size(); j++) {
        System.out.println(this.memberList.get(i) + " vs " + this.memberList.get(j) + ": matchVärde=" + this.memberList.get(i).matchValue(this.memberList.get(j)));
      }
    }
  }
  
  // Given metod
  public int searchMember(Member m) {
     for (int i=0; i<this.memberList.size(); i++) {
       if (m.getIdentity().equals(this.memberList.get(i).getIdentity())) {
         return i;
       }
     }
     return -1;
  }
  
  // uppg e)
  // Returnerar en array med två element som är de medlemmar som matchar bäst
  public Member[] bestMatchPair() {
    // Skapa en array för resultatet
    Member [] best = new Member[2];
    int index1=-1, index2=-1, m, min=10000000;
    for (int i=0; i<this.memberList.size()-1; i++) {
      for (int j=i+1; j<this.memberList.size(); j++) {
        m = this.memberList.get(i).matchValue( this.memberList.get(j));
        if (m<min) {
          index1=i;  // i och j är "bästa" paret av individer
          index2=j;
          min=m;
        }
      } // j-loopen  
    } // i-loopen
    best[0]=this.memberList.get(index1);
    best[1]=this.memberList.get(index2);
    return best;
  }
  
  // uppg f)
  // Returnerar true om medlemmen finns, annars false
  public boolean deleteMember(Member m) {
    int index=this.searchMember(m);
    if (index>=0) {
      this.memberList.remove(index);
      return true;
    }
    return false;
  }
  
  
  // Given metod
  public  String toString() {
    String s ="";
    for (int i=0;i<this.memberList.size();i++) {
      s = s + this.memberList.get(i) + "\n";
    }
    return s;
  }
}  // MemberGroup
