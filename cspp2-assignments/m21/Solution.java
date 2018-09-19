import java.util.Scanner;
import java.util.ArrayList;
class Log {
    public String date;
    public String time;
    Log(String date1,String time1) {
        this.date=date1;
        this.time=time1;
    }
}
class FoodLog extends Log{
    private String foodName;
    private String quantity;
    public String getfoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getquantity() {
        return quantity;
    }

    public void setquantity(String quantity1) {
        this.quantity = quantity1;
    }
    public String getdate() {
        return super.date;
    }

    public void setdate(String date1) {
        super.date = date1;
    }
    public String gettime() {
        return super.time;
    }

    public void settime(String time) {
        super.time = time;
    }
    FoodLog(String foodName1,String quantity1,String date1,String time1) {
        super(date1,time1);
        foodName=foodName1;
        quantity=quantity1;
    }
    public String toString() {
        String str = "";
        str += "Date:" + date + "\n";
        str += "Time:" + time + "\n";
        str += "Name:" + foodName + "\n";
        str += "Quantity:" + quantity;
        return str;
    }
}
class WaterLog extends Log{
    private String quantity;
    public String gettime() {
        return super.time;
    }

    public void settime(String time) {
        super.time = time;
    }
    public String getquantity() {
        return quantity;
    }

    public void setquantity(String quantity) {
        this.quantity = quantity;
    }
    public String getdate() {
        return super.date;
    }

    public void setdate(String date) {
        super.date = date;
    }
   WaterLog(String quantity1, String date1, String time1) {
        super(date1,time1);
        quantity=quantity1;
    }
    public String toString() {
        String str = "";
        str += "Date:" + date + "\n";
        str += "Quantity:" + quantity + "ml";
        return str;
    }
}
/**
 * Class for physical activity.
 */
class PhysicalaLog extends Log{
    private String activityname;
    public String getactivityname() {
        return activityname;
    }

    public void setactivityname(String activityname) {
        this.activityname = activityname;
    }
    public String getdate() {
        return super.date;
    }

    public void setdate(String date) {
        super.date = date;
    }
    public String getstarttime() {
        return super.time;
    }

    public void setstarttime(String starttime) {
        super.time = starttime;
    }
    private String endtime;
    public String getendtime() {
        return endtime;
    }

    public void setendtime(String endtime) {
        this.endtime = endtime;
    }
    private String notes;
    public String getnotes() {
        return notes;
    }

    public void setnotes(String notes) {
        this.notes = notes;
    }
    PhysicalaLog(String activityname1, String date1, String starttime, String endtime1,String notes1) {
        super(date1,starttime);
        activityname=activityname1;
        endtime=endtime1;
        notes = notes1;
    }
    public String toString() {
        String str = "";
        str += "Name:" + activityname + "\n";
        str += "Notes:" + notes + "\n";
        str += "Date:" + date + "\n";
        str += "Starttime:" + time + "\n";
        str += "Endtime:" + endtime;
        return str;
    }
}
class WeightLog extends Log{
    private String weight;
    private String fatprecent;
    public String gettime() {
        return super.time;
    }

    public void settime(String time) {
        super.time = time;
    }
    public String getweight() {
        return weight;
    }

    public void setweight(String weight) {
        this.weight = weight;
    }
    public String getfatprecent() {
        return fatprecent;
    }

    public void setfatprecent(String fatprecent) {
        this.fatprecent = fatprecent;
    }
    public String getdate() {
        return super.date;
    }

    public void setdate(String date) {
        super.date = date;
    }
    WeightLog(String date1, String time1, String weight1, String fat1) {
        super(date1,time1);
        weight = weight1;
        fatprecent = fat1;
    }
    public String toString() {
        String str = "";
        str += "Date:" + date + "\n";
        str += "Time:" + time + "\n";
        str += "Weight:" + weight + "\n";
        str += "Fat:" + fatprecent;
        return str;
    }
}
class SleepLog extends Log{
    private String endtime;
    public String getdate() {
        return super.date;
    }

    public void setdate(String date) {
        super.date = date;
    }
    public String getstarttime() {
        return super.time;
    }

    public void setstarttime(String starttime1) {
        super.time = starttime1;
    }
    public String getendtime() {
        return endtime;
    }

    public void setendtime(String endtime1) {
        this.endtime = endtime;
    }
    SleepLog(String date1, String starttime1, String endtime1) {
        super(date1,starttime1);
        endtime = endtime1;
    }
    public String toString() {
        String str = "";
        str += "Date:" + date + "\n";
        str += "Starttime:" + time + "\n";
        str += "Endtime:" + endtime;
        return str;
    }
}
class FitBit {
    ArrayList<FoodLog> foodlog;
    ArrayList<WaterLog> waterlog;
    ArrayList<PhysicalaLog> physicallog;
    ArrayList<WeightLog> weightlog;
    ArrayList<SleepLog> sleeplog;
    FitBit() {
        foodlog = new ArrayList<FoodLog>();
        waterlog = new ArrayList<WaterLog>();
        physicallog = new ArrayList<PhysicalaLog>();
        weightlog = new ArrayList<WeightLog>();
        sleeplog = new ArrayList<SleepLog>();
    }
    public void food(String foodfoodName, String quantity, String date, String time) {
        foodlog.add(new FoodLog(foodfoodName, quantity, date, time));
    }
    public void water(String quantity, String date, String time) {
        waterlog.add(new WaterLog(quantity, date, time));
    }
    public void physical(String activityname, String notes, String starttime, String endtime, String date) {
        physicallog.add(new PhysicalaLog(activityname, notes, starttime, endtime, date));
    }
    public void weight(String date, String time, String weight, String percent) {
        weightlog.add(new WeightLog(date, time, weight, percent));
    }
    public void sleep(String date, String starttimedate, String endtimedate) {
        sleeplog.add(new SleepLog(date, starttimedate, endtimedate));
    }
    public void Foodlog() {
        System.out.println("Food");
        for (FoodLog k : foodlog) {
            System.out.println(k);
        }
    }
    public void Waterlog() {
        System.out.println("Water");
        for (WaterLog k : waterlog) {
            System.out.println(k);
        }
    }
    public void PhysicalActivitylog() {
        System.out.println("PhysicalActivity");
        if (physicallog.size() > 0) {
            for (PhysicalaLog k : physicallog) {
                System.out.println(k);
            }
        } else {
            System.out.println("None");
        }
    }
    public void Weightlog() {
        System.out.println("Weight");
        for (WeightLog k : weightlog) {
            System.out.println(k);
        }
    }
    public void Sleeplog() {
        System.out.println("Sleep");
        for (SleepLog k : sleeplog) {
            System.out.println(k);
        }
    }
    public void printall() {
        Foodlog();
        Waterlog();
        PhysicalActivitylog();
        Weightlog();
        Sleeplog();
    }
    public void printall(String date) {
        System.out.println("Food");
        String str = "Food" + "\n";
        for (FoodLog k : foodlog) {
            if (k.getdate().equals(date)) {
                System.out.println(k + "\n");
                str += k+"\n";
            }
        }
        System.out.println("Water");
        str += "Water" + "\n";
        for (WaterLog k : waterlog) {
            if (k.getdate().equals(date)) {
                System.out.println(k+"\n");
                str += k+"\n";
            }
        }
        System.out.println("PhysicalActivity");
        str += "PhysicalActivity" + "\n";
        for (PhysicalaLog k : physicallog) {
            if (k.getdate().equals(date)) {
                System.out.println(k + "\n");
                str += k+"\n";
            }
        }
        System.out.println("Weight");
        str += "Weight" + "\n";
        for (WeightLog k : weightlog) {
            if (k.getdate().equals(date)) {
                System.out.println(k+"\n");
                str += k+"\n";
            }
        }
        System.out.println("Sleep");
        str += "Sleep" + "\n";
        for (SleepLog k : sleeplog) {
            if (k.getdate().equals(date)) {
                System.out.println(k+"\n");
                str += k+"\n";
            }
        }
        System.out.println(str);
    }
}
public class Solution {
    public static void main(final String[] args) {
        Scanner sc =  new Scanner(System.in);
        FitBit fb = new FitBit();
        while (sc.hasNext()) {
            String in = sc.nextLine();
            String[] token = in.split(" ");
            switch (token[0]) {
            case "Food":
                String[] loglist = token[1].split(",");
                fb.food(loglist[0], loglist[1], loglist[2], loglist[3]);
                break;
            case "Water":
                loglist = token[1].split(",");
                fb.water(loglist[0], loglist[1], loglist[2]);
                break;
            case "PhysicalActivity":
                loglist = token[1].split(",");
                fb.physical(loglist[0], loglist[1], loglist[2], loglist[3], loglist[4]);
                break;
            case "Weight":
                loglist = token[1].split(",");
                fb.weight(loglist[0], loglist[1], loglist[2], loglist[3]);
                break;
            case "Sleep":
                loglist = token[1].split(",");
                fb.sleep(loglist[0], loglist[1], loglist[2]);
                break;
            case "Foodlog":
                System.out.println();
                fb.Foodlog();
                System.out.println();
                break;
            case "Waterlog":
                fb.Waterlog();
                System.out.println();
                break;
            case "PhysicalActivitylog":
                fb.PhysicalActivitylog();
                System.out.println();
                break;
            case "Weightlog":
                fb.Weightlog();
                System.out.println();
                break;
            case "Sleeplog":
                fb.Sleeplog();
                System.out.println();
                break;
            case "Summary":
                if (token.length == 2) {
                    System.out.println();
                    fb.printall(token[1]);
                } else {
                    fb.printall();
                }
                break;
            default:
                break;
            }
        }
    }
}