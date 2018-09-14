import java.util.Scanner;

/**
 * Class for show.
 */
class Show {
    String moviename;
    String timedate;
    String[] seats;
    public Show(String a, String b, String[] c) {
        this.moviename = a;
        this.timedate = b;
        this.seats = c;
    }
}
/**
 * Class for patron.
 */
class Patron {
    String Patronname;
    String Mobilenumber;
    public Patron(String a, String b) {
        this.Patronname = a;
        this.Mobilenumber = b;
    }
}
/**
 * Class for BookYourShow.
 */
class BookYourShow {
    /**
     * Constructs the object.
     */
    Show[] movielist;
    Patron[] patronlist;
    int size = 0;
    int patronsize = 0;

    /**
     * Constructs the object.
     */
    public BookYourShow() {
        this.movielist = new Show[10];
        this.patronlist = new Patron[10];
        this.size = 0;
    }

    /**
     * Adds a show.
     *
     * @param      k     { parameter_description }
     */
    public void addAShow(Show k) {
        movielist[size++] = k;
    }


    /**
     * Gets a show.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     A show.
     */
    public Show getAShow(String a, String b) {
        for (int i = 0; i < size; i++) {
            if ((movielist[i].moviename).equals(a)) {
                if ((movielist[i].timedate).equals(b)) {
                    return movielist[i];
                }
            }
        }
        return null;
    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     * @param      d     { parameter_description }
     */
    public void bookAShow(String a, String b, Patron c, String[] d) {
        int cnt = 0;
        if (size == 0) {
            System.out.println("No show");
        } else {

            for (int k = 0; k < size; k++) {
                if (a.equals(movielist[k].moviename)) {
                    if ((movielist[k].timedate).equals(b)) {
                        String[] availseats = movielist[k].seats;
                        for (int i = 0; i < d.length; i++) {
                            for (int j = 0; j < availseats.length; j++) {
                                if (availseats[j].equals(d[i])) {
                                    availseats[j] = "N/A";
                                    cnt += 1;
                                }

                            }

                        }
                        if (cnt > 0) {
                            patronlist[patronsize] = c;
                            patronsize++;
                        }
                    } else {
                        System.out.println("No show");
                        break;
                    }

                }
            }
        }
    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean printTicket(String a, String b, String c) {
        for (int i = 0; i < patronsize; i++) {
            if (c.equals(patronlist[i].Mobilenumber)) {
                for (int j = 0; j < size; j++) {
                    if (b.equals(movielist[j].timedate) && a.equals(movielist[j].moviename)) {
                        System.out.println(patronlist[i].Mobilenumber + " " + a + " " + b);
                        return true;
                    }
                }
            }
        }
        return false;

    }
    /**
     * Shows all.
     */
    public void showAll() {
        if (movielist.length > 0) {
            for (int i = 0; i < size; i++) {
                String str = "";
                str += movielist[i].moviename + ",";
                str += movielist[i].timedate + ",";
                String str2 = "[";
                String[] availseats = movielist[i].seats;
                for (int j = 0; j < availseats.length - 1; j++) {
                    str2 += availseats[j] + ",";
                }
                str2 += availseats[availseats.length - 1] + "]";
                str += str2;
                System.out.println(str);
            }
        }

    }
}

/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(check[1] + "," + tokens[1]);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                if (bys.printTicket(check[1], tokens[1], tokens[2])) {
                    break;
                } else {
                    System.out.println("Invalid");
                }
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}
