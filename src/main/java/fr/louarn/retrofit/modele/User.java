package fr.louarn.retrofit.modele;

public class User {
    /**
     * Attributs
     */

    private String login;
    private Long id;
    private String url;

    /**
     * Constructeurs
     */

    public User() {
    }

    /**
     * Accesseurs
     */

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
