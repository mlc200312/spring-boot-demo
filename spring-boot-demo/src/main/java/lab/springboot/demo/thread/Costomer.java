package lab.springboot.demo.thread;

public class Costomer {
    //arrivalTime跟踪顾客抵达售票口的时间，departureTime跟踪顾客买票后离开售票口的时间
    private int arrivalTime, departureTime;
    
    public Costomer(int arrives){
        arrivalTime = arrives;
        departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }
    //顾客买票所花的总时间就是离开时间-抵达时间
    public int totalTime(){
        return (departureTime-arrivalTime);
    }
    
}