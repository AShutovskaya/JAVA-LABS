package Elements;
public class Halls{
    private static Halls ourInstance1;
    String hall;
    int row;
    int seat;
    String func;
    public Halls(  String hall, int row,int seat,String func)
    {
        this.hall = hall;
        this .row = row;
        this .seat=seat;
        this.func = func;
    }
    public String get_halls()
    {return hall;
    }
    public void  set_halls(String hall ){
        this.hall = hall;
    }
    public int get_row()
    {return row;
    }
    public void set_row()
    {this.row=row;
    }
    public int get_seat()
    {return seat;
    }
    public void set_seat()
    {this.seat=seat;
    }
    public String get_func()
    {return func;
    }
    public void  set_func(String func ){
        this.func = func;
    }
    public String toString(){
        return   hall +","+ row+"x"+ seat +","+ func;
    }


}