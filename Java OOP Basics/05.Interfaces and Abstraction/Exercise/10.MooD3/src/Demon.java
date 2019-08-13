public class Demon extends BaseCharacter {
    private Double specialPoints;

    protected Demon(String username, String characterType, Double specialPoints, int level) {
        super(username, characterType, level);
        this.specialPoints = specialPoints;
        super.setHashedPassword(username.length() * 217 + "");
    }

    @Override
    public String printInfo() {
        return String.format("\"%s\" | \"%s\" | -> %s\n", super.getUsername(), this.getHashedPassword(), super.getCharacterType()) + this.specialPoints * super.getLevel();
    }
}
