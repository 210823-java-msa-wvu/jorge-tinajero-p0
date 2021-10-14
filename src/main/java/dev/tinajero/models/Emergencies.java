package dev.tinajero.models;

public class Emergencies {
   private String emergency;
   private int id;
   private boolean completed = false;
   private String medic, popo, ff;
   public Emergencies(){

   }

   public Emergencies(String medic, String popo, String ff) {
      this.medic = "You called for Medical help, get to safety!";
      this.popo = "Police Services are on their way, get to safety";
      this.ff = "Fire Services are on their way, get to safety";
   }

   public Emergencies(int id, boolean completed) {
      this.id = id;
      this.completed = completed;
   }

   public Emergencies(String emergency) {
      this.emergency = emergency;
   }

   public Emergencies(int id){
      this.id = id;
   }

   public Emergencies(boolean completed){
      this.completed = completed;
   }

   public String getEmergency() {

      return emergency;
   }

   public void setEmergency(String emergency) {

      this.emergency = emergency;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public boolean isCompleted() {
      return completed;
   }

   public void setCompleted(boolean completed) {
      this.completed = completed;
   }

   public String getMedic() {
      return medic;
   }

   public void setMedic() {
      this.medic = medic;
   }

   public String getPopo() {
      return popo;
   }

   public void setPopo() {
      this.popo = popo;
   }

   public String getFf() {
      return ff;
   }

   public void setFf() {
      this.ff = ff;
   }

   @Override
   public String toString() {
      return ("Select: "+ id +" - Emergency: "+ emergency);
   }
}
