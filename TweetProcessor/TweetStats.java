class TweetStats{
    public static void main(String[] args){
        System.out.println("====================================");
        System.out.println("Welcome to the TweetStats Program!");
        System.out.println("====================================");

        TweetProcessor tp = new TweetProcessor();
        tp.processTweet("Hi @univpugetsound loggers!");
        tp.processTweet("#hack #hack #chop #chop");
        tp.processTweet("The Lady Logs vie for the D3 championship! #LoggerUp @univpugetsound");
        tp.processTweet("What a send-off! Good luck, Loggers! RT @PSLoggers: Logger Sports Network: Good luck, @PSwbasketball! #LoggerUP");
        tp.processTweet("I like sandwiches");
        System.out.println(tp.toString());
    }
}