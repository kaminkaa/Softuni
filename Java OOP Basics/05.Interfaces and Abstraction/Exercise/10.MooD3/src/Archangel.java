public class Archangel extends BaseCharacter {
    private int specialPoints;

    protected Archangel(String username, String characterType, int specialPoints, int level) {
        super(username, characterType, level);
        this.specialPoints = specialPoints;
        super.setHashedPassword(new StringBuilder(username).reverse().toString() + username.length() * 21);
    }

    @Override
    public String printInfo() {
        return String.format("\"%s\" | \"%s\" | -> %s\n", super.getUsername(), this.getHashedPassword(), super.getCharacterType()) + this.specialPoints * super.getLevel();
    }
}
