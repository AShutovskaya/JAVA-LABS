package Elements;
public class Cinemas{
    String title;
    String address;
    String parking;
    public Cinemas(String title,String address,String parking){
        this .title = title;
        this.address = address;
        this.parking = parking;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title ){
        this .title = title;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address ){
        this .address = address;
    }
    public String getParking(){
        return parking;
    }
    public void setParking(String parking){
        this .parking= parking;
    }
    public String toString(){
        return    title +":"+address+","+parking;
    }
}