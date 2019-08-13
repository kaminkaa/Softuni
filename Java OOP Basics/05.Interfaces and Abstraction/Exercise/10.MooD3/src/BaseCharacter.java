public abstract class BaseCharacter<T> implements CharacterInterface {
    private String characterType;
    private String username;
    private String hashedPassword;
    private int level;

    protected BaseCharacter(String username, String characterType, int level) {
        this.characterType = characterType;
        this.username = username;
        this.level = level;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
