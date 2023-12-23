public class Score extends Turn{
    private int matchLength = 0;
    
    public Score()
    {
        matchLength = 0;
    }

    public void setMatchength(int length)
    {
        matchLength = length;
    }

    public int getMatchLength()
    {
        return matchLength;
    }

    public void setScore(Player player)
    {
       player.setScore(getScore(player)+1);
    }

    public int getScore(Player player)
    {
        return player.getScore();
    }

    /*
     * Will return true if the players score matches the match length
     * else returns false.
     */
    public boolean compareMatchLength(Player player)
    {
        return getScore(player) == getMatchLength() ? true : false;
    }

}
