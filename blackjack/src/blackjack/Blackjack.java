package blackjack;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
public class Blackjack {
    public static void main(String[] args) throws InterruptedException {
        /*
         * For now, aces are worth 1, not 11.
         */
        
        Scanner k = new Scanner(System.in);
        
        int dealtCard = 0;
        boolean rep = false;
        String choice = "poop";
        int bet;
        String uhh;
        ArrayList <Integer> yourHand = new ArrayList();
        ArrayList <Integer> dealerHand = new ArrayList();
        ArrayList <Integer> values = new ArrayList();
        values = PopulateValues(values);        // IT WORKS!!!
        //System.out.println("values: " + values);

        //System.out.println(values.size());
        
        for(int i = 0; i < 10; ++i){            // Populates yourHand<> and 
                                                //  dealerHand<> with 10 
            yourHand.add(0);                    // indexes of 0
            dealerHand.add(0);
            //System.out.println("yourHand: " + yourHand.size());
            //System.out.println("dealerHand: " + dealerHand.size());
        }
        
        
        
        int rounds = 1;
        int yourHandTotal = 0;
        int dHandTotal = 0;
        int yourStartTotal = 0;
        
        int newCard, g = 0, i = 0;
        
        int t = 1;
        //System.out.println("values: " + values);
        
        yourHand = PlayerHandStart(yourHand, values);
        //System.out.println(yourHand);
        
        
        System.out.print("Your Cards: ");
        
        for(t = 0; t < 10; ++t){
            
            yourStartTotal += yourHand.get(t);
            
            if(yourHand.get(t) == 0)
                break;
            
            if(yourHand.get(t + 1) == 0){
                
                System.out.print(yourHand.get(t));
                break;
                
            }
            
            System.out.print(yourHand.get(t) + ", ");
            
            
        }
        
        System.out.println("\nYour hand equals: " + yourStartTotal);
        
        ++g;
        
        dealerHand = DealerHandStart(dealerHand, values);
        //System.out.println("dealerHand: " + dealerHand);
        
        ++g;
            
        //String[] choices = {"bet", "stay"};
        ArrayList <String> choices = new ArrayList();    choices.add("bet");     choices.add("stay");
        
        
        
        Collections.sort(yourHand, Collections.reverseOrder());
        Collections.sort(dealerHand, Collections.reverseOrder());
        
        printHands(yourHand, dealerHand);
        System.out.println("");
        
        
        while(dHandTotal < 21 && yourHandTotal < 21){
            
            System.out.println("\nDealer shows: " + dealerHand.get(1));
            //System.out.println("choice: " + choice);
            
                    //choice = "";
                    while(!"bet".equalsIgnoreCase(choice) && !"stay".equalsIgnoreCase(choice)){

                        System.out.println("Bet or stay?");
                            choice = k.nextLine();
                            System.out.println("============\nchoice: " + choice);
                            
                        if("bet".equals(choice) || "stay".equals(choice)){
                            break;
                        }
                        
                        else{
                            System.out.println("=================================\nInvalid choice. Please try again.\n=================================");
                        }
                        
                    }
                    
                    System.out.println("g: " + g + "\nrounds: " + rounds + "\n============");

                    if(choice.equalsIgnoreCase("stay")){
                        dealerHand.add(rounds + 1, values.get(g));
                    }

                    else if(choice.equalsIgnoreCase("bet")){
                        
                        System.out.println("How much would you like to bet?");
                            bet = k.nextInt();
                            uhh = k.nextLine();         // Grabs the empty character at the end of the bet so it isn't used next time the Scanner gets an input
                            
                        yourHand.add(rounds + 1, values.get(g));
                        
                        ++g;
                        
                        dealerHand.add(rounds + 1, values.get(g));
                        
//                        Collections.sort(yourHand);
//                        Collections.sort(dealerHand);
                        
                        Collections.sort(yourHand, Collections.reverseOrder());
                        Collections.sort(dealerHand, Collections.reverseOrder());
                        
                        printHands(yourHand, dealerHand);
                        System.out.println("");
                        
                    }
                    
                    choice = "poop";
                    
            ++rounds;
            
        }

        System.out.println(values);
        
        System.out.println(values.size());
    }
    
    
    
    
    
    // Add cards to player hand
    public static ArrayList PlayerHandStart(ArrayList <Integer> yourHand, ArrayList <Integer> values) {
        
        int g = 0, i = 0;
            for(i = 0; i < 2; ++i){         // Populates initial 2 cards for dealer and player.
                                            // Player gets indexes 1 and 3. Dealer get indexes 2 and 4.
                //System.out.println("i: " + i);
                
                yourHand.set(i, values.get(g));
                ++g;
                ++i;
                yourHand.set(i, values.get(g));
                ++g;
                
            }
            ++g;
        
    return yourHand;
    }
    
    
    
    
    
    // Add cards to dealer hand
    public static ArrayList DealerHandStart(ArrayList <Integer> dealerHand, ArrayList <Integer> values) {
        
        int g = 2, i = 0;
            for(i = 0; i < 2; ++i){         // Populates initial 2 cards for dealer and player.
                                            // Player gets indexes 1 and 3. Dealer get indexes 2 and 4.
                //System.out.println("i: " + i);
                
                dealerHand.set(i, values.get(g));
                ++g;
                ++i;
                dealerHand.set(i, values.get(g));
                
            }
            ++g;
        
    return dealerHand;
    }
    
    
    
    
    // Add cards to player hand
    public static ArrayList PlayerHand(ArrayList <Integer> yourHand) {
        
        
        
    return yourHand;
    }
    
    
    
    
    // Add cards to dealer hand
    public static ArrayList DealerHand(ArrayList <Integer> dealerHand) {
        
        
        
    return dealerHand;
    }
    
    
    
    
    // Add cards to player and dealer hands
    public static ArrayList Compare(ArrayList <Integer> yourHand, ArrayList <Integer> dealerHand){
        
        int yourHandTotal = 0;
        for(int handVal = 0; handVal < yourHand.size(); ++handVal){

            yourHandTotal = yourHandTotal + yourHand.get(handVal);

        }
        System.out.println("Your hand: " + yourHand);

        System.out.println("Your hand adds up to: " + yourHandTotal);
        if(yourHandTotal == 21){
            System.out.println("You have blackjack!");
            System.exit(0);
        }
        else if(yourHandTotal > 21){
            System.out.println("------------\nYou busted.\n------------");
            System.exit(0);
        }
        else{}



        int dHandTotal = 0;
        for(int dHandVal = 0; dHandVal < dealerHand.size(); ++dHandVal){

            dHandTotal += dealerHand.get(dHandVal);
            System.out.println("dHandVal: " + dHandVal);
            System.out.println("dHandTotal: " + dHandTotal);
            System.out.println("Adding: " + dealerHand.get(dHandVal));
        }
        
        if(dHandTotal == 21){
            System.out.println("Dealer has blackjack.");
            System.exit(0);
        }
        
        if(yourHandTotal == 21)
            System.out.println("You have blackjack.");

        if(dHandTotal > 21){
            System.out.println("------------\nDealer busted.\nDealer total: " + dHandTotal + "\n------------");
            System.exit(0);
        }

        if(yourHandTotal > 21)
            System.out.println("You busted.");
        
        
        ArrayList <Integer> compare = new ArrayList();
        compare.add(0, dHandTotal);
        compare.add(1, yourHandTotal);
        
        
    return compare;
    }
    
    
    
    
    // Literally just populates
    // ArrayList values<> and then
    // shuffles it
    public static ArrayList PopulateValues(ArrayList <Integer> values) {
                                                                                
        for(int y = 1; y <= 9; ++y){                                            
        
            for(int r = 0; r < 4; ++r)
                values.add(y);

        }
        
        for(int y = 0; y < 16; ++y)
            values.add(10);

        Collections.shuffle(values);
        
    return values;
    }
    
    private static void printHands(ArrayList yourHand, ArrayList dealerHand){
        
        System.out.println("yourHand: ");
        for(int f = 0; f < yourHand.size(); ++f){

            System.out.print(yourHand.get(f));
            if(f < (yourHand.size() - 1))
                System.out.print(", ");

        }

        System.out.println("\ndealerHand: ");
        for(int f = 0; f < yourHand.size(); ++f){

            System.out.print(dealerHand.get(f));
            if(f < (yourHand.size() - 1))
                System.out.print(", ");
            
        }
        
    }
    
    
    
}