package example.codeclan.com.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public enum Symbol {
        CHERRY("Cherry"),
        PEAR("Pear"),
        BANANA("Banana"),
        BELL("Bell"),
        SEVEN("Seven"),
        WATERMELON("Watermelon"),
        GRAPES("Grapes"),
        LEMON("Lemon"),
        STARPRIZE("StarPrize"),
        HORSESHOE("Horseshoe");


        private String type;

        Symbol(String type){
            this.type = type;
        }

        public String getSymbol() {
            return type;
        }
    }

