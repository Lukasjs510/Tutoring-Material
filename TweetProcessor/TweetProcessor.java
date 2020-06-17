import java.util.ArrayList;

class TweetProcessor { 
    ArrayList<String> recentHashtags;
    int numTweets;
    int numTerms;
    int numChars;
    int numHashtags;
    int numMentions;

    public TweetProcessor(){
        recentHashtags = new ArrayList<String>();
        numTweets = 0;
        numTerms = 0;
        numChars = 0;
        numHashtags = 0;
        numMentions = 0;
    }

    public void reset(){
        recentHashtags = new ArrayList<String>();
        numTweets = 0;
        numTerms = 0;
        numChars = 0;
        numHashtags = 0;
        numMentions = 0;
    }

    public boolean isHashtag(String s){
        if (s.substring(0,1).equals("#") && s.length() > 1){
            return true;
        }
        return false;
    }

    public boolean isMention(String s) {
        if (s.substring(0,1).equals("@") && s.length() > 1){
            return true;
        }
        return false;
    }

    public String history(){
        String s = "History (" + this.recentHashtags.size() + "): ";
        for (String tag : recentHashtags) {
            s += tag + " ";
        }
        return s;
    }

    public void processTweet(String s) {
        s = s.toLowerCase();
        String[] tokens = s.split(" ");
        this.numTweets ++;
        this.numTerms += tokens.length;
        this.numChars += s.length();

        for (String token : tokens){
            if (isHashtag(token)){
                numHashtags++;
                if (recentHashtags.indexOf(token) == -1){
                    this.recentHashtags.add(token);
                }
            } else if (isMention(token)){
                numMentions++;
            }
        }
    }

    public String toString(){
        return ("Tweets: " + numTweets + "\nTerms: " + numTerms + "\nCharacters per tweet: " + (((double)numChars)/((double)numTweets)) + "\nHashtags: " + numHashtags + "\nMentions: " + numMentions + "\n" + history());
    }

}