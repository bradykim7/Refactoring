import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name){
        _name = name;
    }
    public void addRental(Rental arg){
        _rentals.addElement(arg);

    }
    public String getName(){
        return _name;
    }

    /* Before Refactoring Code
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + " 고객님의 대여 기록 \n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // 비디오의 종류별로 대여료 계산
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += (each.getDaysRented()) * 3;
                    break;
                case Movie.CHILDERNS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // 적립포인트를 1 포인트 증가
            frequentRenterPoints++;

            // 최신작을 2일 이상 대여할 경우 보넛 ㅡ포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // 대여하는 비디오의 정보와 대여료를 출력

            result += '\t' + each.getMovie().getTitle() + '\t' + String.valueOf(thisAmount) + '\n';

            // 누적된 총 대여료
            totalAmount += thisAmount;
        }
        result += "누적 대여료 :" + String.valueOf(totalAmount)+'\n';
        result += "적립 포인트 :" + String.valueOf(frequentRenterPoints)+'\n';
        return result;
    }
     */

    public String statement(){
        double totalAmount =0;
        int frequentRenterPoints =0;
        Enumeration rentals = _rentals.elements();
        String result = getName()+ " 고객님의 대여 기록\n";

        while(rentals.hasMoreElements()){
            double thisAmount=0;
            Rental each = (Rental) rentals.nextElement();
            // 바뀐 부분 #1
            // thisAmount = amountFor(each);
            // 재수정 #2
            thisAmount = each.getCharge();

            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints++;
            // 최신물을 2일 이상 대여할 경우 보너스 포인트 지급
            if((each.getMovie().getPriceCode()  == Movie.NEW_RELEASE) && each.getDaysRented() >1)
                frequentRenterPoints++;

            // 대여하는 비디오의 정보와 대여료를 출력
            result += '\t'+each.getMovie().getTitle()+'\t'+String.valueOf(thisAmount)+'\n';
            totalAmount+=thisAmount;

        }
        result += "누적 대여료:" + String.valueOf(totalAmount)+'\n';
        result += "적립 포인트:" + String.valueOf(frequentRenterPoints);
        return result;
    }
    /* Before Renaming variable
    private double amountFor(Rental each){
        double thisAmount = 0;

        switch (each.getMovie().getPriceCode()){
            case Movie.REGULAR:
                thisAmount +=2;
                if(each.getDaysRented() >2 )
                    thisAmount+=(each.getDaysRented()-2)*1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount+= each.getDaysRented() *3;
                break;
            case Movie.CHILDERNS:
                thisAmount+=1.5;
                if(each.getDaysRented() >3)
                    thisAmount+= (each.getDaysRented() -3)*1.5;
                break;
        }
        return thisAmount;
    }

     */
    /* Actually we don't use any data from customer class so we move amountFor Method to Rental class.
    private double amountFor(Rental aRental){
        double result = 0;
        switch(aRental.getMovie().getPriceCode()){
            case Movie.REGULAR:
                result +=2;
                if(aRental.getDaysRented() >2)
                    result += (aRental.getDaysRented()-2)*1.5;
                break;
            case Movie.NEW_RELEASE:
                result+=aRental.getDaysRented()*3;
                break;
            case Movie.CHILDERNS:

                result+=1.5;
                if(aRental.getDaysRented() >3)
                    result += (aRental.getDaysRented()-3)*1.5;
                break;
        }
        return result;
    }
     */
    /* #2
    private double amountFor(Rental aRental){
        return aRental.getCharge();
    }
     */
}
